package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyActivity extends AppCompatActivity {

    private MyLocationListener myLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        myLocationListener = new MyLocationListener(this, getLifecycle(), location -> {

        });
        Util.checkUserStatus(result -> {
            if (result) {
                myLocationListener.enable();
            }
        });
    }
}