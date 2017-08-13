package com.liemily.tradesimulation.stock.exceptions;

/**
 * Created by Emily Li on 12/08/2017.
 */
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }

    public InsufficientStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
