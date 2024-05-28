package com.anotn.antstock.android.presentation.ui.fragment.stock;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anotn.antstock.android.presentation.ui.adapter.MarketAdapter;
import com.antstock.android.domain.entity.StockInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarketViewModel {
    private MutableLiveData<List<StockInfo>> stocksData;
    private MarketAdapter adapter;

    public LiveData<List<StockInfo>> getStocks() {
        return stocksData;
    }

    public MarketViewModel() {
        init();
    }
    protected void init() {
        if(stocksData == null) {
            stocksData = new MutableLiveData<>();
        }
        if(stocksData.getValue() == null) {
            List<StockInfo> stocks = new ArrayList<>();
            stocks.add(
                    new StockInfo("005930", "삼성전자")
            );
            stocks.add(
                    new StockInfo("000660", "SK하이닉스")
            );
            stocks.add(
                    new StockInfo("035420", "NAVER")
            );
            stocks.add(
                    new StockInfo("005380", "현대차")
            );
            stocks.add(
                    new StockInfo("000270", "삼성SDI")
            );
            stocksData.setValue(stocks);
        }
        if(adapter == null) {
            adapter = new MarketAdapter(this);
        }
    }
    public MarketAdapter getAdapter() {
        return adapter;
    }
   public String getName(int position) throws NullPointerException {
            return Objects.requireNonNull(stocksData.getValue(), "NPE: getName()").get(position).getName();
   }
   public String getTicker(int position) throws NullPointerException {
           return Objects.requireNonNull(stocksData.getValue(), "NPE: getTicker()").get(position).getTicker();
   }
   public void addFavorite(int pos) {
       Objects.requireNonNull(stocksData.getValue()).get(pos).setFavorite(true);
       adapter.notifyItemChanged(pos);
   }
   public void removeFavorite(int pos) {
       Objects.requireNonNull(stocksData.getValue()).get(pos).setFavorite(false);
       adapter.notifyItemChanged(pos);
   }
}
