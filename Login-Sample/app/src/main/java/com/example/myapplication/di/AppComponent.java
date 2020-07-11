package com.example.myapplication.di;


import com.example.myapplication.ui.login.LoginActivity;

import dagger.Component;

@Component
public interface AppComponent {

    void inject(LoginActivity loginActivity);

}
