package com.tokioschool.navigationpractica.features.home.fragments.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tokioschool.navigationpractica.domain.User;

public class SharedViewModelHome extends ViewModel
{

    private  MutableLiveData<User> mutableUser= new MutableLiveData<>();

    public void setUser(User user){
        mutableUser.setValue(user);
    }

    public LiveData<User> getUser(){
        return mutableUser;
    }

}
