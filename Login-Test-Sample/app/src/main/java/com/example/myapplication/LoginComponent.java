package com.example.myapplication;

import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }
    void inject(MainActivity mainActivity);
    void inject(LoginUsernameFragment loginUsernameFragment);
    void inject(LoginPasswordFragment loginPasswordFragment);
}
