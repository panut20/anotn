package com.anotn.antstock.android.presentation.ui.fragment.chart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.anotn.antstock.android.databinding.FragmentChartBinding;
import com.anotn.antstock.android.presentation.ui.adapter.StockDetailAdapter;

public class ChartFragment extends Fragment {

    public ChartFragment() {
        // Required empty public constructor
    }

    public static ChartFragment newInstance(String param1, String param2) {
        ChartFragment fragment = new ChartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentChartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.stockName.setText("삼성전자");
        binding.stockTicker.setText("005930");
        StockDetailAdapter adapter = new StockDetailAdapter();
        binding.stockDetailContainer.setAdapter(adapter);
        binding.stockDetailContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
