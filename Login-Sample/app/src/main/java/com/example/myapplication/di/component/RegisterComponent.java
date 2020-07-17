package com.example.myapplication.di.component;

import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.register.RegisterActivity;

import dagger.Subcomponent;

@Subcomponent
public interface RegisterComponent {
    @Subcomponent.Factory
    interface Factory {
        RegisterComponent create();
    }
    void inject(RegisterActivity registerActivity);
}
