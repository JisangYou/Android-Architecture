package com.example.myapplication;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * 추상 클래스 DaggerApplication 상속
 * 필수적인 dispatcher들을 주입
 * dispatcher : 먼저 수행되야 할 작업을 선택해서 공급
 */
public class App extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.factory().create(this);
    }
}
