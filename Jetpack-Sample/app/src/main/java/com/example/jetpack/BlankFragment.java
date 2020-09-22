package com.example.jetpack;

import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpack.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {

    UserAdapter adapter;
    UserViewModel viewModel;
    FragmentBlankBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = ...;
        viewModel.load();

        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(...);

        viewModel.getUsers().observe(users-> adapter.submitList(users));

        return binding.getRoot();
    }
}