package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;


class MainActivity extends AppCompatActivity {

    MutableLiveData<String> liveString = new MutableLiveData<>(); // -> LiveData는 데이터 읽기만 가능, 쓰려면 MutableLiveData

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getUsers().observe(this, users -> {
            // LiveData를 관찰하고 이곳에서 사용자 목록을 얻는다.
        });
    }
}

