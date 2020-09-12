package com.example.jetpack;

import androidx.lifecycle.MutableLiveData;

public class InitMutableLiveData<T> extends MutableLiveData<T> {

    public InitMutableLiveData(T initValue) {
        setValue(initValue);
    }
}
