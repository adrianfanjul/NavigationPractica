package com.tokioschool.navigationpractica.features.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tokioschool.navigationpractica.databinding.FragmentHomeThreeBinding;

public class FragmentHomeThree extends Fragment {

    private static final String TAG = "FragmentHomeThree";
    private FragmentHomeThreeBinding binding;

    public FragmentHomeThree() {

    }

    public static FragmentHomeThree newInstance() {
        FragmentHomeThree fragment=new FragmentHomeThree();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeThreeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}