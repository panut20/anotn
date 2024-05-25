package com.anotn.antstock.android.presentation.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.anotn.antstock.android.R;
import com.anotn.antstock.android.databinding.FragmentHomeBinding;


/**
     * A simple {@link Fragment} subclass.
     * Use the {@link HomeFragment#newInstance} factory method to
     * create an instance of this fragment.
     */
    public class HomeFragment extends Fragment implements View.OnClickListener {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters

        public HomeFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         *
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static HomeFragment newInstance(String param1, String param2) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            return fragment;
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