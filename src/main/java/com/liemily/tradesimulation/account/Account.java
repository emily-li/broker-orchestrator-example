package com.liemily.tradesimulation.account;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Emily Li on 12/08/2017.
 */
@Entity
public class Account {
    @Id
    private String username;
    private BigDecimal credits;

    // Constructor used by Spring JPA
    private Account() {
    }

    public Account(String username, BigDecimal credits) {
        this.username = username;
        this.credits = credits;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return (username != null ? username.equals(account.username) : account.username == null)
                && (credits != null ? credits.equals(account.credits) : account.credits == null);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (credits != null ? credits.hashCode() : 0);
        return result;
    }
}
