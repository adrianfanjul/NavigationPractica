package com.tokioschool.navigationpractica.features.login.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.FragmentRegisterBinding;
import com.tokioschool.navigationpractica.domain.User;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModel;

public class FragmentRegister extends Fragment {
    private User user;
    private FragmentRegisterBinding binding;
    private static final String TAG="FragmentRegister";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private SharedViewModel viewModel;

    public FragmentRegister() {

    }

    private final ActivityResultLauncher<Intent> register=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result.getResultCode()== Activity.RESULT_OK){
            if(result.getData()!=null){
                //Aquí se recogeria la imagen resultante
            }
        }
    });

    public static FragmentRegister newInstance() {
        FragmentRegister fragment=new FragmentRegister();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.setFragment(TAG);
        loadSpinner();
        listeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding= FragmentRegisterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    private void listeners() {
        binding.registerTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.registerTextName.getText().toString().length()>0){
                    if(binding.registerTextName.getText().toString().contains("@")||binding.registerTextName.getText().toString().contains("!")){
                        binding.registerTextNameLayout.setError(getString(R.string.register_text_error));
                    }else{
                        binding.registerTextNameLayout.setError(null);
                    }
                }
                enableButton();
            }
        });
        binding.registerTextSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.registerTextSurname.getText().toString().length()>0){
                    if(binding.registerTextSurname.getText().toString().contains("@")||binding.registerTextSurname.getText().toString().contains("!")){
                        binding.registerTextSurnameLayout.setError(getString(R.string.register_text_error));
                    }else{
                        binding.registerTextSurnameLayout.setError(null);
                    }
                }
                enableButton();
            }
        });
        binding.registerSpinnerAges.setOnItemClickListener((adapterView, view, position, id) -> {
            if(position<3){
                binding.registerSpinnerAgesLayout.setError((getString(R.string.register_age_error)));
            }else{
                binding.registerSpinnerAgesLayout.setError(null);
            }
        });
        binding.registerBtnOk.setOnClickListener(view -> {
            user =new User();
            user.setUsername(binding.registerTextName.getText().toString());
            user.setPassword(binding.registerTextSurname.getText().toString());

            NavHostFragment.findNavController(FragmentRegister.this).navigate(FragmentRegisterDirections.fragmentRegisterToFragmentLogin().setRegistredUser(user));
        });
        binding.registerImgPhoto.setOnClickListener(view ->btn_camera_click());
        binding.registerFootLink.setOnClickListener(view ->link_condiciones_click());
    }

    private void enableButton() {
        binding.registerBtnOk.setEnabled(false);
        if(binding.registerTextName.getText().toString().length()>0 && binding.registerTextSurname.getText().toString().length()>0){
            binding.registerBtnOk.setEnabled(true);
        }
    }

    private void loadSpinner() {
        ArrayAdapter<String> listAgesAdapter= new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.listAges));
        binding.registerSpinnerAges.setAdapter(listAgesAdapter);
    }

    private void btn_camera_click(){
        register.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
    }

    private void link_condiciones_click(){
        Uri uri=Uri.parse("https://developers.google.com/ml-kit/terms");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}