package com.antstock.android.domain.entity;


public class Stock {

    private String ticker;

    private String name;

    private String exchange_code;

    private String list_date;

    private String delist_date;

    private String sector;

    private String created;

    private String updated;
    public Stock(String ticker, String name, String exchange_code, String list_date, String delist_date, String sector, String created, String updated) {
        this.ticker = ticker;
        this.name = name;
        this.exchange_code = exchange_code;
        this.list_date = list_date;
        this.delist_date = delist_date;
        this.sector = sector;
        this.created = created;
        this.updated = updated;
    }
}
