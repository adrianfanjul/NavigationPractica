package com.tokioschool.navigationpractica.features.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.tokioschool.navigationpractica.databinding.FragmentOnBoardingThreeBinding;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModelLogin;


public class FragmentOnBoardingThree extends Fragment {
    private SharedViewModelLogin viewModel;
    private static final String TAG="FragmentOnBoardingThree";
    private FragmentOnBoardingThreeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState ) {
        binding = FragmentOnBoardingThreeBinding.inflate(inflater, container, false);
        listeners();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModelLogin.class);
        viewModel.setFragment(TAG);
    }

    private void listeners() {
        binding.onboardingThreeLoginButton.setOnClickListener(
                view -> NavHostFragment.findNavController(FragmentOnBoardingThree.this)
                        .navigate(FragmentOnBoardingThreeDirections.toFragmentLogin()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
