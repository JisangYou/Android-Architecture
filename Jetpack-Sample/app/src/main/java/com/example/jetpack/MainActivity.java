package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;


class MainActivity extends AppCompatActivity {

    MutableLiveData<String> liveString = new MutableLiveData<>(); // -> LiveData는 데이터 읽기만 가능, 쓰려면 MutableLiveData

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 반드시 메인 스레드에서만 호출해야한다.
         */
        liveString.setValue("Hello Jay");

        /**
         * 주로 백그라운드 스레드에서 호출하는 용도로 사용된다.
         */
        liveString.postValue("Hello World");
        liveString.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });

    }
}

