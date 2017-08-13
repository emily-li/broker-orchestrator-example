package com.liemily.tradesimulation.accountstock;

import com.liemily.tradesimulation.accountstock.exceptions.InsufficientAccountStockException;

/**
 * Created by Emily Li on 13/08/2017.
 */
public interface AccountStockService {
    void removeStock(String username, String stockSymbol, int volume) throws InsufficientAccountStockException;

    void addStock(String username, String stockSymbol, int volume);

    AccountStock getAccountStockForUser(String username, String stockSymbol);

    AccountStock findOne(AccountStockId accountStockId);
}
