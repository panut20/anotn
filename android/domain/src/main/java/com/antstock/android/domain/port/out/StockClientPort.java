package com.antstock.android.domain.port.out;

import com.antstock.android.domain.entity.Stock;
import com.antstock.android.domain.entity.StockInfo;

import java.util.List;

public interface StockClientPort {
    public List<StockInfo> getStocksList();
    public Stock getStock(String ticker);
}
