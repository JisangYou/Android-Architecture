package com.example.myapplication.module;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    LoginActivityComponent.Builder loginActivityComponentBuilder();

    void inject(App app);

    @Component.Factory
    interface Factory {
        AppComponent create(
                @BindsInstance App app,
                AppModule appModule
        );
    }
}
