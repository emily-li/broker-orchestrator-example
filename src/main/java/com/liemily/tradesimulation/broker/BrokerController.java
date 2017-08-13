package com.liemily.tradesimulation.broker;

import com.liemily.tradesimulation.account.exceptions.InsufficientFundsException;
import com.liemily.tradesimulation.accountstock.exceptions.InsufficientAccountStockException;
import com.liemily.tradesimulation.stock.exceptions.InsufficientStockException;
import com.liemily.tradesimulation.stock.exceptions.InvalidStockException;
import com.liemily.tradesimulation.trade.Trade;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by Emily Li on 13/08/2017.
 */
@Component
@Lazy
public class BrokerController {
    private Broker broker;

    public BrokerController(Broker broker) {
        this.broker = broker;
    }

    public long process(Trade trade) throws InsufficientAccountStockException, InsufficientFundsException, InsufficientStockException, InvalidStockException {
        return broker.process(trade);
    }
}
