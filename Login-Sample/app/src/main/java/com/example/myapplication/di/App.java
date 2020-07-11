package com.example.myapplication.di;

import android.app.Application;

public class App extends Application {

    AppComponent appComponent = DaggerAppComponent.create();

}
