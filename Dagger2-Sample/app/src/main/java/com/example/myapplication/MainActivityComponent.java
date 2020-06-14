package com.example.myapplication;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainActivityModule.class)
//@ActivityScope
public interface MainActivityComponent {
    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainActivityModule module);

        @BindsInstance
        Builder setActivity(MainActivity activity);

        MainActivityComponent build();
    }
}