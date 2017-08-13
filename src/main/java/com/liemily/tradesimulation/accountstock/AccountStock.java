package com.liemily.tradesimulation.accountstock;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Created by Emily Li on 12/08/2017.
 */
@Entity
@IdClass(AccountStockId.class)
public class AccountStock implements Serializable {
    @Id
    private String username;
    @Id
    private String stockSymbol;
    private int volume;

    // Required for Spring JPA
    private AccountStock() {
    }

    public AccountStock(String username, String stockSymbol, int volume) {
        this.username = username;
        this.stockSymbol = stockSymbol;
        this.volume = volume;
    }

    public String getUsername() {
        return username;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "AccountStock{" +
                "username='" + username + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStock that = (AccountStock) o;

        return volume == that.volume
                && (username != null ? username.equals(that.username) : that.username == null)
                && (stockSymbol != null ? stockSymbol.equals(that.stockSymbol) : that.stockSymbol == null);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (stockSymbol != null ? stockSymbol.hashCode() : 0);
        result = 31 * result + volume;
        return result;
    }
}
