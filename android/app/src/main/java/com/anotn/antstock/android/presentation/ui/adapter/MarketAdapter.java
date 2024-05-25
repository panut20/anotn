package com.anotn.antstock.android.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.anotn.antstock.android.R;
import com.anotn.antstock.android.databinding.ItemStockBinding;
import com.anotn.antstock.android.presentation.ui.fragment.stock.MarketViewModel;

import java.util.Objects;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    Fragment fragment;
    MarketViewModel marketViewModel;

    public MarketAdapter(MarketViewModel marketViewModel) {
        this.marketViewModel = marketViewModel;
    }
    public MarketAdapter(@NonNull Fragment fragment, MarketViewModel marketViewModel) {
        this.fragment = fragment;
        this.marketViewModel = marketViewModel;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout tvContainer;
        private final TextView tvName, tvTicker;
        private final AppCompatCheckBox stockStar;

        private final NavController controller;
        public ViewHolder(@NonNull ItemStockBinding binding, NavController controller) {
            super(binding.getRoot());
            tvContainer = binding.stockHeader;
            tvName = binding.stockName;
            tvTicker = binding.stockTicker;
            stockStar = binding.stockStar;
            this.controller = controller;

        }
        public void bind(MarketViewModel marketViewModel, int pos) {
            tvName.setText(marketViewModel.getName(pos));
            tvTicker.setText(marketViewModel.getTicker(pos));

            tvContainer.setOnClickListener(v -> {
                this.controller.navigate(R.id.action_stockFragment_to_chartFragment);
            });


            stockStar.setOnCheckedChangeListener((v, isChecked) -> {
                if (isChecked) {
                    marketViewModel.addFavorite(pos);
                    Toast.makeText(v.getContext(), "Added to favorites", Toast.LENGTH_SHORT).show();
                } else {
                    marketViewModel.removeFavorite(pos);
                    Toast.makeText(v.getContext(), "Removed from favorites", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    ItemStockBinding binding;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemStockBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, NavHostFragment.findNavController(fragment));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(marketViewModel, position);
    }


    @Override
    public int getItemCount() throws NullPointerException {
            return Objects.requireNonNull(marketViewModel.getStocks().getValue(), "NPE: getItemCount()").size();
    }
}
