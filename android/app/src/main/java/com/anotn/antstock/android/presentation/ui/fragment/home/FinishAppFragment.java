package com.anotn.antstock.android.presentation.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.anotn.antstock.android.databinding.FragmentFinishAppBinding;

public class FinishAppFragment extends DialogFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }
    FinishAppFragment() {
    }

    FragmentFinishAppBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFinishAppBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.dialogButtonYes.setOnClickListener(v -> {
            requireActivity().finish();
        });
        binding.dialogButtonNo.setOnClickListener(v -> {
            dismiss();
        });
        return view;
    }
}
