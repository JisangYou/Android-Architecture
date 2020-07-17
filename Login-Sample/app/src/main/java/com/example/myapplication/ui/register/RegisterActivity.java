package com.example.myapplication.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.App;
import com.example.myapplication.di.component.RegisterComponent;

import javax.inject.Inject;
import javax.inject.Named;

public class RegisterActivity extends AppCompatActivity {

    RegisterComponent registerComponent;


    @Inject
    @Named("register")
    String register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        registerComponent = ((App) getApplicationContext()).getAppComponent().registerComponent().create();
        registerComponent.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Log.d("check", "RegisterActivity");
    }
}