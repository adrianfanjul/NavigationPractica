package com.tokioschool.navigationpractica.features.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.tokioschool.navigationpractica.databinding.FragmentOnBoardingOneBinding;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModel;

public class FragmentOnBoardingOne extends Fragment {

    private FragmentOnBoardingOneBinding binding;
    private SharedViewModel viewModel;
    private static final String TAG="FragmentOnBoardingOne";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState ) {
        binding = FragmentOnBoardingOneBinding.inflate(inflater, container, false);
        listeners();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.setFragment(TAG);

    }

    private void listeners() {
        binding.mainNextButton.setOnClickListener(view -> NavHostFragment.findNavController(FragmentOnBoardingOne.this)
                .navigate(FragmentOnBoardingOneDirections.toFragmentOnBoardingTwo()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}