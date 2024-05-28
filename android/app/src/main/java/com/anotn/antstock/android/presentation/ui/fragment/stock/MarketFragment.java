package com.anotn.antstock.android.presentation.ui.fragment.stock;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anotn.antstock.android.databinding.FragmentStockBinding;
import com.anotn.antstock.android.presentation.ui.adapter.MarketAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarketFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // TODO: Rename and change types of parameters

    public MarketFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment StockFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarketFragment newInstance() {
        MarketFragment fragment = new MarketFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
    }
    FragmentStockBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStockBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        View view = binding.getRoot();
        MarketViewModel viewModel = new MarketViewModel();
        MarketAdapter marketAdapter = new MarketAdapter(this, viewModel);
        NavHostFragment navHostFragment = (NavHostFragment) getParentFragment();
        assert navHostFragment != null: "navHostFragment is null";
        NavController navController = navHostFragment.getNavController();
        binding.stockList.setAdapter(marketAdapter);
        binding.stockList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}