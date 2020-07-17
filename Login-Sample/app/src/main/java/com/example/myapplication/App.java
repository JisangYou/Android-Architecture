package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.di.component.AppComponent;
import com.example.myapplication.di.component.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
