package com.anotn.antstock.android.presentation.ui.fragment.chart;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anotn.antstock.android.presentation.ui.fragment.stock.MarketViewModel;
import com.antstock.android.domain.entity.Stock;

public class ChartViewModel extends ViewModel {
    private MutableLiveData<Stock> mText;

    private MarketViewModel marketViewModel;

    public ChartViewModel(String ticker, String name) {
        mText = new MutableLiveData<>();
        Stock stock = new Stock(ticker, name, "", "", "", "", "", "");
        mText.setValue(stock);
    }

    public MutableLiveData<Stock> getStock() {
        return mText;
    }

}
