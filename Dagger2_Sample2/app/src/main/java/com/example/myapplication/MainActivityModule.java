package com.example.myapplication;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainFragmentSubComponent.class)
public abstract class MainActivityModule {
    @Named("activity")
    @Provides
//    @ActivityScope
    static String provideString(){
        return "String from MainActivityModule";
    }

    @Binds
    @IntoMap
    @ClassKey(MainFragment.class)
    abstract AndroidInjector.Factory<?> bindInjectorFactory(MainFragmentSubComponent.Factory factory);
}
