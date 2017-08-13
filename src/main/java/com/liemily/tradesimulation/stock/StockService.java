package com.liemily.tradesimulation.stock;

import com.liemily.tradesimulation.stock.exceptions.InsufficientStockException;
import com.liemily.tradesimulation.stock.exceptions.InvalidStockException;

/**
 * Created by Emily Li on 13/08/2017.
 */
public interface StockService {
    void remove(String stockSymbol, int volume) throws InsufficientStockException;

    void add(String stockSymbol, int volume) throws InvalidStockException;

    Stock getStock(String stockSymbol);

    void save(Stock stock);

    void delete(String stockSymbol);
}
