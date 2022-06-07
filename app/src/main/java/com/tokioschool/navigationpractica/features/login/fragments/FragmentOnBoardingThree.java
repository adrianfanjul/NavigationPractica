package com.tokioschool.navigationpractica.features.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.FragmentOnBoardingThreeBinding;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModel;


public class FragmentOnBoardingThree extends Fragment {
    private SharedViewModel viewModel;
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
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
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
