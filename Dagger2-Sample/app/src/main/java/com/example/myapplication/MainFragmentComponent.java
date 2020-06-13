package com.example.myapplication;

import dagger.BindsInstance;
import dagger.Subcomponent;

//@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentComponent {
    void inject(MainFragment mainFragment);

    @Subcomponent.Builder
    interface Builder {
        MainFragmentComponent.Builder setModule(MainFragmentModule module);

        @BindsInstance
        MainFragmentComponent.Builder setFragment(MainFragment fragment);

        MainFragmentComponent build();
    }
}
