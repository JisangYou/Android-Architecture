package com.example.myapplication.module;

import com.example.myapplication.ui.login.LoginActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent {
//    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(LoginActivity loginActivity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(LoginActivityModule module);

        @BindsInstance
        Builder setActivity(LoginActivity loginActivity);

        LoginActivityComponent build();
    }
}
