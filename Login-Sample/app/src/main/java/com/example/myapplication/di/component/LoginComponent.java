package com.example.myapplication.di.component;


import com.example.myapplication.ui.login.LoginActivity;

import dagger.Subcomponent;

@Subcomponent
public interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }
    void inject(LoginActivity loginActivity);

    /**
     * 이 밑으로 용도에 맞는 Activity가 있다면
     * void inject(RegisterActivity registerActivity);
     * 이런식으로 추가해준다.
     */
}
