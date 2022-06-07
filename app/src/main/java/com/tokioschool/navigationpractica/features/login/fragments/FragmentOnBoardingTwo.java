package com.tokioschool.navigationpractica.features.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.tokioschool.navigationpractica.databinding.FragmentOnBoardingTwoBinding;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModel;

public class FragmentOnBoardingTwo extends Fragment {

    private FragmentOnBoardingTwoBinding binding;
    private SharedViewModel viewModel;
    private static final String TAG="FragmentOnBoardingTwo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState ) {
        binding = FragmentOnBoardingTwoBinding.inflate(inflater, container, false);
        listeners();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.setFragment(TAG);
    }

    private void listeners() {
        binding.onboardingTwoNextButton.setOnClickListener(
                view -> NavHostFragment.findNavController(FragmentOnBoardingTwo.this)
                .navigate(FragmentOnBoardingTwoDirections.toFragmentOnBoardingThree()));

        binding.onboardingTwoSkipButton.setOnClickListener(
                view -> NavHostFragment.findNavController(FragmentOnBoardingTwo.this)
                        .navigate(FragmentOnBoardingTwoDirections.fragmentOnBoardingTwoToFragmentLogin()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
