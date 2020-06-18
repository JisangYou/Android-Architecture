package com.example.myapplication;


import android.app.Application;


// 어플리케이션 상속
public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(this, new AppModule());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
