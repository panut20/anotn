package com.anotn.antstock.android.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.anotn.antstock.android.databinding.ItemStockDetailBinding;
import com.anotn.antstock.android.presentation.ui.fragment.chart.MyLineChart;
import com.github.mikephil.charting.charts.LineChart;

public class StockDetailAdapter extends RecyclerView.Adapter<StockDetailAdapter.ViewHolder> {

    ItemStockDetailBinding binding;

    public StockDetailAdapter() {

    }

    @NonNull
    @Override
    public StockDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemStockDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StockDetailAdapter.ViewHolder holder, int position) {
        holder.setMyLineChart(holder.myLineChart);
        holder.setNews("NEWS 1", "NEWS 2");

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        LineChart lineChart;
        MyLineChart myLineChart;

        ConstraintLayout tvContainer;

        TextView news1, news2;

        public ViewHolder(@NonNull ItemStockDetailBinding binding) {
            super(binding.getRoot());
            this.lineChart = binding.lineChart;
            this.tvContainer = binding.infoContainer;
            this.news1 = binding.itemNews1;
            this.news2 = binding.itemNews2;
            this.myLineChart = new MyLineChart(binding.getRoot().getContext());
        }
        public void setMyLineChart(MyLineChart myLineChart) {
            myLineChart.setData(lineChart);
        }
        public void setNews(String news1, String news2) {
            this.news1.setText(news1);
            this.news2.setText(news2);
        }
    }
}
