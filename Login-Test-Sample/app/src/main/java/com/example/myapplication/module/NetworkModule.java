package com.example.myapplication.module;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

// @Module informs Dagger that this class is a Dagger Module
@Module
public class NetworkModule {

    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. LoginRetrofitService).
    // Function parameters are the dependencies of this type.

    //    public LoginRetrofitService provideLoginRetrofitService() {
//        // Whenever Dagger needs to provide an instance of type LoginRetrofitService,
//        // this code (the one inside the @Provides method) is run.
//        return new Retrofit.Builder()
//                .baseUrl("https://example.com")
//                .build()
//                .create(LoginRetrofitService.class);
//    }
    @Singleton
    @Provides
    public String provideLoginRetrofitService() {
        Log.e("NetworkModule", "provideLoginRetrofitService");
        return "jack";
    }
}