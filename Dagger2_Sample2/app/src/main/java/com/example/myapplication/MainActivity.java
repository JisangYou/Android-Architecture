package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

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

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}
