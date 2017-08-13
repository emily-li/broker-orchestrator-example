package com.liemily.tradesimulation.trade;

/**
 * Created by Emily Li on 13/08/2017.
 */
public interface TradeService {
    void delete(long tradeId);

    Trade findOne(long tradeId);

    long save(Trade trade);
}
