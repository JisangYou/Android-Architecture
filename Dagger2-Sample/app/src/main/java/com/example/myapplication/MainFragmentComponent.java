package com.example.myapplication;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * 해당 지점 파라마터 가지고옴
 */
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
