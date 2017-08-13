package com.liemily.tradesimulation.accountstock;

import com.liemily.tradesimulation.accountstock.exceptions.InsufficientAccountStockException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Emily Li on 12/08/2017.
 */
@Repository
@Service
@Transactional
@Lazy
public class MySQLAccountStockService implements AccountStockService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public AccountStock getAccountStockForUser(String username, String stockSymbol) {
        AccountStockId id = new AccountStockId(username, stockSymbol);
        return findOne(id);
    }

    @Override
    public void addStock(String username, String stockSymbol, int volume) {
        Query query = entityManager.createQuery("UPDATE AccountStock SET volume = volume + ?3 WHERE username = ?1 AND stock_symbol = ?2");
        query.setParameter(1, username);
        query.setParameter(2, stockSymbol);
        query.setParameter(3, volume);

        boolean success = query.executeUpdate() > 0;
        if (!success) {
            AccountStock accountStock = new AccountStock(username, stockSymbol, volume);
            entityManager.persist(accountStock);
        }
    }

    @Override
    public void removeStock(String username, String stockSymbol, int volume) throws InsufficientAccountStockException {
        Query query = entityManager.createQuery("UPDATE AccountStock SET volume = volume - ?3 WHERE username = ?1 AND stock_symbol = ?2 AND volume - ?3 >= 0");
        query.setParameter(1, username);
        query.setParameter(2, stockSymbol);
        query.setParameter(3, volume);

        int affectedRows = query.executeUpdate();
        if (affectedRows <= 0) {
            throw new InsufficientAccountStockException("Failed to remove " + volume + " " + stockSymbol + " stocks from user " + username + " due to insufficient stock");
        }
    }

    @Override
    public AccountStock findOne(AccountStockId accountStockId) {
        return entityManager.find(AccountStock.class, accountStockId);
    }
}
