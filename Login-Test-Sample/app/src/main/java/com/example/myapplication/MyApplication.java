package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.component.ApplicationComponent;
import com.example.myapplication.component.DaggerApplicationComponent;

public class MyApplication extends Application {
    ApplicationComponent appComponent = DaggerApplicationComponent.create();
}
