package com.example.myapplication.di;


import com.example.myapplication.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@Singleton
@Component(modules = {StorageModule.class, AppSubcomponents.class})
public interface AppComponent {

//    void inject(App app);
//
//    @Component.Factory
//    interface Factory {
//        // With @BindsInstance, the Context passed in will be available in the graph
//        AppComponent create(@BindsInstance App app);
//    }

    LoginComponent.Factory loginComponent();

}
