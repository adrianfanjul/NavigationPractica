package com.tokioschool.navigationpractica.features.home.fragments.vm;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tokioschool.navigationpractica.data.RepositoryCar;
import com.tokioschool.navigationpractica.domain.CarItem;

import java.util.List;


public class ListCarViewModel extends ViewModel {

    private RepositoryCar repositoryCar;
    private MutableLiveData<List<CarItem>> mutableCarList=new MutableLiveData<>();

    public ListCarViewModel(RepositoryCar repositoryCar) {
        this.repositoryCar = repositoryCar;
    }

    public void loadCarList(){
        mutableCarList.setValue(repositoryCar.getFakeCarList());
    }

    public LiveData<List<CarItem>> getCarList(){
        return mutableCarList;
    }

    public static class Factory implements ViewModelProvider.Factory{

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ListCarViewModel(new RepositoryCar());
        }
    }

}
