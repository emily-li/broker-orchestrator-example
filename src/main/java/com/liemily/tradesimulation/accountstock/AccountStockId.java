package com.liemily.tradesimulation.accountstock;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Emily Li on 13/08/2017.
 */
@Embeddable
public class AccountStockId implements Serializable {
    private String username;
    private String stockSymbol;

    // Required for Spring JPA
    private AccountStockId() {
    }

    AccountStockId(String username, String stockSymbol) {
        this.username = username;
        this.stockSymbol = stockSymbol;
    }

    public String getUsername() {
        return username;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    @Override
    public String toString() {
        return "AccountStockId{" +
                "username='" + username + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStockId that = (AccountStockId) o;

        return (username != null ? username.equals(that.username) : that.username == null)
                && (stockSymbol != null ? stockSymbol.equals(that.stockSymbol) : that.stockSymbol == null);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (stockSymbol != null ? stockSymbol.hashCode() : 0);
        return result;
    }
}
