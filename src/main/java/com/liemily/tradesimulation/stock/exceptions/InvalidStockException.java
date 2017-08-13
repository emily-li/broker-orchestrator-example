package com.liemily.tradesimulation.stock.exceptions;

/**
 * Created by Emily Li on 12/08/2017.
 */
public class InvalidStockException extends Exception {
    public InvalidStockException(String message) {
        super(message);
    }

    public InvalidStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
