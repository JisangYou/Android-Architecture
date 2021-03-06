package com.example.myapplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainActivitySubComponent.class)
public abstract class AppModule {
    // inject 하는 곳을 위한 세팅
    @Named("app")
    @Provides
    @Singleton
    static String provideString() {
        return "String from AppModule";
    }
    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainActivitySubComponent.Factory factory);
}
