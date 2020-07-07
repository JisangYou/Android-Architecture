package com.example.myapplication;


import android.app.Application;


/**
 * Application을 상속받아, 앱 전체적으로 component를 사용가능
 */
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
