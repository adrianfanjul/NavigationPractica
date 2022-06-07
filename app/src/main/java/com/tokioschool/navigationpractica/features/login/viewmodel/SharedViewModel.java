package com.tokioschool.navigationpractica.features.login.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tokioschool.navigationpractica.domain.User;

public class SharedViewModel extends ViewModel
{

    private final MutableLiveData<String> mutableFragment= new MutableLiveData<>();

    public void setFragment(String fragmentName){
        mutableFragment.setValue(fragmentName);
    }

    public LiveData<String> getFragment(){
        return mutableFragment;
    }
}
