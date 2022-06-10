package com.tokioschool.navigationpractica.features.home.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.FragmentHomeOneBinding;
import com.tokioschool.navigationpractica.domain.User;
import com.tokioschool.navigationpractica.features.home.fragments.viewmodel.SharedViewModelHome;

public class FragmentHomeOne extends Fragment {
    private static final String TAG = "FragmentHomeOne";
    private FragmentHomeOneBinding binding;
    private SharedViewModelHome viewModel;

    public static FragmentHomeOne newInstance() {
        FragmentHomeOne fragment=new FragmentHomeOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeOneBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModelHome.class);
        viewModel.getUser().observe(getViewLifecycleOwner(), user->{
            try {
                showUser(user);
             }catch (Exception e){
              Log.e(TAG,getString(R.string.home_user_error));
            }
        });
    }

    private void showUser(User user) {
        Snackbar.make(requireActivity().findViewById(R.id.fragmentHomeOneLayout)
                ,getString( R.string.home_fragment_one_snackbar_text, user.getUsername(), user.getPassword())
                , BaseTransientBottomBar.LENGTH_SHORT).show();
    }

}