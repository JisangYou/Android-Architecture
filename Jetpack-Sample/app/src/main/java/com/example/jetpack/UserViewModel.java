package com.example.jetpack;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class UserViewModel extends AndroidViewModel {
    MutableLiveData<String> nameQueryLiveData = new MutableLiveData<>();

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

//    LiveData<User> getUsersWithNameLiveData(){
//        return Transformations.switchMap(nameQueryLiveData, name-> myDataSource.getUserWithNameLiveData(name));
//    }

    void setNameQuery(String name){
        this.nameQueryLiveData.setValue(name);
    }
}
