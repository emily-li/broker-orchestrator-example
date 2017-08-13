package com.liemily.tradesimulation.trade;

import javax.persistence.*;

/**
 * Created by Emily Li on 12/08/2017.
 */
@Entity
public class Trade {
    @Id
    @GeneratedValue
    private long tradeId;
    private String username;
    private String stockSymbol;
    private int volume;
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;

    // Default constructor required for Spring JPA
    private Trade() {
    }

    public Trade(String username, String stockSymbol, int volume, TradeType tradeType) {
        this.username = username;
        this.stockSymbol = stockSymbol;
        this.volume = volume;
        this.tradeType = tradeType;
    }

    public long getTradeId() {
        return tradeId;
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

    public TradeType getTradeType() {
        return tradeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        return tradeId == trade.tradeId
                && volume == trade.volume
                && (username != null ? username.equals(trade.username) : trade.username == null)
                && (stockSymbol != null ? stockSymbol.equals(trade.stockSymbol) : trade.stockSymbol == null)
                && tradeType == trade.tradeType;
    }

    @Override
    public int hashCode() {
        int result = (int) (tradeId ^ (tradeId >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (stockSymbol != null ? stockSymbol.hashCode() : 0);
        result = 31 * result + volume;
        result = 31 * result + (tradeType != null ? tradeType.hashCode() : 0);
        return result;
    }

    public enum TradeType {
        BUY,
        SELL
    }
}
