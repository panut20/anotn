package com.antstock.android.data.out.infra;

import com.antstock.android.domain.entity.Stock;
import com.antstock.android.domain.entity.StockInfo;
import com.antstock.android.domain.port.out.StockClientPort;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.Query;

import java.util.List;

class ApolloStockClient implements StockClientPort {
    private final ApolloClient apolloClient;
    public ApolloStockClient(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    @Override
    public List<StockInfo> getStocksList() {

        return null;
    }

    @Override
    public Stock getStock(String ticker) {
        return null;
    }
}
