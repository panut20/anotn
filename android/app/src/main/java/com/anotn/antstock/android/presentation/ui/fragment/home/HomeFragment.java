package com.anotn.antstock.android.presentation.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.anotn.antstock.android.R;
import com.anotn.antstock.android.databinding.FragmentHomeBinding;

    public class HomeFragment extends Fragment implements View.OnClickListener {

        public HomeFragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        private FragmentHomeBinding binding;


        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            binding = FragmentHomeBinding.inflate(inflater, container, false);
            View view = binding.getRoot();
            binding.searchView.setOnSearchClickListener(this);
            OnBackPressedCallback callback;
            callback = new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    FinishAppFragment dialog = new FinishAppFragment();
                    dialog.show(requireActivity().getSupportFragmentManager(), "dialog");
                }
            };
            requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

            return view;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
        @Override
        public void onClick(View v) {
            if (v == binding.searchView) {
                Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
            }
        }
    }