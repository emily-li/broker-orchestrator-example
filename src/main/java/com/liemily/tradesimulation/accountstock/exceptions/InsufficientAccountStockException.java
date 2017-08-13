package com.liemily.tradesimulation.accountstock.exceptions;

/**
 * Created by Emily Li on 12/08/2017.
 */
public class InsufficientAccountStockException extends Exception {
    public InsufficientAccountStockException(String message) {
        super(message);
    }

    public InsufficientAccountStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
