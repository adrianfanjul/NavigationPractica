package com.tokioschool.navigationpractica.features.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tokioschool.navigationpractica.databinding.FragmentLilaBinding;

public class LilaFragment extends Fragment {


    private FragmentLilaBinding binding;

    public LilaFragment() {
        // Required empty public constructor
    }

    public static LilaFragment newInstance() {
        LilaFragment fragment=new LilaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentLilaBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

}