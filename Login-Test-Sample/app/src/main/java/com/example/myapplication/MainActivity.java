package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    LoginComponent loginComponent;

    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        loginComponent = ((MyApplication) getApplicationContext())
                .appComponent.loginComponent().create();

        // Make Dagger instantiate @Inject fields in LoginActivity
        loginComponent.inject(this);

        setContentView(R.layout.activity_main);
    }
}