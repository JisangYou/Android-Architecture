package com.example.myapplication.di;


import com.example.myapplication.ui.login.LoginActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }
    void inject(LoginActivity loginActivity);
}
