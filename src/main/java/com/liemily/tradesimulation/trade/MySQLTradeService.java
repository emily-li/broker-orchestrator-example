package com.liemily.tradesimulation.trade;

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
public class MySQLTradeService implements TradeService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long save(Trade trade) {
        entityManager.persist(trade);
        entityManager.flush();
        return trade.getTradeId();
    }

    @Override
    public void delete(long tradeId) {
        Query query = entityManager.createQuery("DELETE FROM Trade WHERE trade_id = ?1");
        query.setParameter(1, tradeId);
        query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public Trade findOne(long tradeId) {
        return entityManager.find(Trade.class, tradeId);
    }
}
