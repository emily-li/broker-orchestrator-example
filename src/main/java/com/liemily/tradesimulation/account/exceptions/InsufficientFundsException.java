package com.liemily.tradesimulation.account.exceptions;

/**
 * Created by Emily Li on 12/08/2017.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
