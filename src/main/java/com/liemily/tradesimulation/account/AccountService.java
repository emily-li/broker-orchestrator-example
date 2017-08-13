package com.liemily.tradesimulation.account;

import com.liemily.tradesimulation.account.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

/**
 * Created by Emily Li on 13/08/2017.
 */
public interface AccountService {
    void removeCredits(String username, BigDecimal credits) throws InsufficientFundsException;

    void save(Account account);

    void delete(String username);
}
