package com.antstock.android.domain.entity;

public class StockInfo {

    private final String ticker;
    private final String name;

    private boolean isFavorite = false;

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
    public StockInfo(String ticker, String name) {
        this.ticker = ticker;
        this.name = name;
    }

    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
