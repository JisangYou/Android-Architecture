package com.example.jetpack;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;


/**
 * LiveData를 사용하면서 양방향 바인딩 사용하기.
 */
public class UserViewModel2 extends BaseObservable {

    private MutableLiveData<String> name = new MutableLiveData<>();

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }
}
