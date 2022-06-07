package com.tokioschool.navigationpractica.features.home.fragments;

import static com.tokioschool.navigationpractica.constants.Constants.USER;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.FragmentHomeOneBinding;
import com.tokioschool.navigationpractica.domain.User;

public class FragmentHomeOne extends Fragment {

    private static final String TAG = "FragmentHomeOne";
    private User user;
    private FragmentHomeOneBinding binding;


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
        try {
            showUser();
        }catch (Exception e){
            Log.e(TAG,getString(R.string.home_user_error));
        }
    }

    private void showUser() {
        user=(User)getArguments().getParcelable(USER);
        Snackbar.make(requireActivity().findViewById(R.id.fragmentHomeOneLayout)
               ,getString( R.string.home_snackbar_text,user.getUsername(),user.getPassword())
               , BaseTransientBottomBar.LENGTH_SHORT).show();
    }

}