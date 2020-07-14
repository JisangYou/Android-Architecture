package com.example.myapplication.di;
import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules = {StorageModule.class, AppModule.class})
public interface AppComponent {

    LoginComponent.Factory loginComponent();

}

