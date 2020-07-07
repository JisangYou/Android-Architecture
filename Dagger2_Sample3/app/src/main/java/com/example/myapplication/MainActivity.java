package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * DaggerAppCompatActivity를 상속
 * Dagger Library에 종속성이 높아짐
 */
public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    @Named("app")
    String appString;

    @Inject
    @Named("activity")
    String activityString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        Log.e("MainActivity", appString);
        Log.e("MainActivity", activityString);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
    }
}
