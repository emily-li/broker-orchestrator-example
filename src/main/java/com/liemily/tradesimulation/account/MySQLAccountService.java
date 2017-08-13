package com.liemily.tradesimulation.account;

import com.liemily.tradesimulation.account.exceptions.InsufficientFundsException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

/**
 * Created by Emily Li on 12/08/2017.
 */
@Repository
@Service
@Transactional
@Lazy
public class MySQLAccountService implements AccountService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void removeCredits(String username, BigDecimal credits) throws InsufficientFundsException {
        Query query = entityManager.createQuery("UPDATE Account SET credits = credits - ?2 WHERE username = ?1 AND credits - ?2 >= 0");
        query.setParameter(1, username);
        query.setParameter(2, credits);

        boolean success = query.executeUpdate() > 0;
        if (!success) {
            throw new InsufficientFundsException("Attempted to withdraw " + credits + " but failed as user " + username + " has insufficient funds");
        }
    }

    @Override
    public void save(Account account) {
        entityManager.persist(account);
    }

    @Override
    public void delete(String username) {
        Query query = entityManager.createQuery("DELETE FROM Account WHERE username = ?1");
        query.setParameter(1, username);
        query.executeUpdate();
    }
}
