package com.liemily.tradesimulation.stock;

import com.liemily.tradesimulation.stock.exceptions.InsufficientStockException;
import com.liemily.tradesimulation.stock.exceptions.InvalidStockException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Emily Li on 23/07/2017.
 */
@Repository
@Service
@Transactional
@Lazy
public class MySQLStockService implements StockService {
    private static final Logger logger = LogManager.getLogger(StockService.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public void remove(String stockSymbol, int volume) throws InsufficientStockException {
        Query query = em.createQuery("UPDATE Stock SET volume = volume - ?2 WHERE symbol = ?1 AND volume - ?2 >= 0");
        query.setParameter(1, stockSymbol);
        query.setParameter(2, volume);

        boolean success = query.executeUpdate() > 0;
        if (!success) {
            String error = "Failed to withdraw " + volume + " " + stockSymbol + " stocks due to insufficient volume";
            logger.error(error);
            throw new InsufficientStockException(error);
        }
    }

    @Override
    public void add(String stockSymbol, int volume) throws InvalidStockException {
        Query query = em.createQuery("UPDATE Stock SET volume = volume + ?2 WHERE symbol = ?1");
        query.setParameter(1, stockSymbol);
        query.setParameter(2, volume);

        boolean success = query.executeUpdate() > 0;
        if (!success) {
            String error = "Failed to add stock for stock symbol " + stockSymbol;
            logger.error(error);
            throw new InvalidStockException(error);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Stock getStock(String stockSymbol) {
        return em.find(Stock.class, stockSymbol);
    }

    @Override
    public void save(Stock stock) {
        em.persist(stock);
    }

    @Override
    public void delete(String stockSymbol) {
        Query query = em.createQuery("DELETE FROM Stock WHERE symbol = ?1");
        query.setParameter(1, stockSymbol);
        query.executeUpdate();
    }
}
