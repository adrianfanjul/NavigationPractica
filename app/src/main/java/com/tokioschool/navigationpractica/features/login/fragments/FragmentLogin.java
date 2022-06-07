package com.tokioschool.navigationpractica.features.login.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.FragmentLoginBinding;
import com.tokioschool.navigationpractica.domain.User;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModel;

public class FragmentLogin extends Fragment {
    private FragmentLoginBinding binding;
    private SharedViewModel viewModel;
    private static final String TAG="FragmentLogin";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        listeners();
        viewModel.setFragment(TAG);
    }

    private void listeners() {
        binding.loginForgotLink.setOnClickListener(view -> Snackbar.make(binding.getRoot(), R.string.login_snackbar_text, BaseTransientBottomBar.LENGTH_SHORT).show());
        binding.loginAccountLink.setOnClickListener(view -> NavHostFragment.findNavController(FragmentLogin.this).navigate(FragmentLoginDirections.toFragmentRegister()));
        binding.loginInputLoginText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });
        binding.loginInputPasswordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });
        binding.loginButtonLogin.setOnClickListener(view -> userLogin());
    }

    private void userLogin() {
        User user = FragmentLoginArgs.fromBundle(getArguments()).getRegistredUser();
        if(user ==null){
            Toast.makeText(requireActivity(), R.string.login_no_register, Toast.LENGTH_SHORT).show();
        }else{
            if(binding.loginInputLoginText.getText().toString().equals(user.getUsername()) && binding.loginInputPasswordText.getText().toString().equals(user.getPassword())){

                NavHostFragment.findNavController(FragmentLogin.this).navigate(FragmentLoginDirections.toHomeActivity().setLoginUser(user));

            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                builder.setTitle(R.string.login_validation_fail);
                builder.setPositiveButton(R.string.login_button_ok, (dialog, id) -> {
                    dialog.dismiss();
                }).create().show();
            }
        }
    }

    private void enableButton() {
        if(binding.loginInputLoginText.getText().length()>0 && binding.loginInputPasswordText.getText().length()>0)
            binding.loginButtonLogin.setEnabled(true);
        else
            binding.loginButtonLogin.setEnabled(false);
    }

}