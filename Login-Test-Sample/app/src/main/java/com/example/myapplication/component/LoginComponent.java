package com.example.myapplication.component;

import com.example.myapplication.ActivityScope;
import com.example.myapplication.LoginPasswordFragment;
import com.example.myapplication.LoginUsernameFragment;
import com.example.myapplication.MainActivity;

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
