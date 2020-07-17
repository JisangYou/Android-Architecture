package com.example.myapplication.di.module;


import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.myapplication.di.annotation.ApiInfo;
import com.example.myapplication.di.annotation.DatabaseInfo;
import com.example.myapplication.di.annotation.PreferenceInfo;
import com.example.myapplication.di.component.LoginComponent;
import com.example.myapplication.di.component.RegisterComponent;
import com.example.myapplication.helper.ApiHelper;
import com.example.myapplication.helper.AppApiHelper;
import com.example.myapplication.helper.AppDbHelper;
import com.example.myapplication.helper.AppPreferencesHelper;
import com.example.myapplication.helper.DbHelper;
import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.utils.AppConstants;
import com.example.myapplication.utils.AppDataManager;
import com.example.myapplication.utils.AppDatabase;
import com.example.myapplication.utils.DataManager;
import com.example.myapplication.helper.PreferencesHelper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * 추후 NetworkModule, RegisterComponent 등으로 추가할 수 있다.
 */

@Module(subcomponents = {LoginComponent.class,RegisterModule.class})
public class AppModule {

    //    @ActivityScope -? scope referrence error
    @Provides
    @Named("login")
    String login() {
        return LoginActivity.class.getSimpleName();
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "ApiKey";
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

//    @Provides
//    @Singleton
//    CalligraphyConfig provideCalligraphyDefaultConfig() {
//        return new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build();
//    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

//    @Provides
//    @Singleton
//    Gson provideGson() {
//        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }


//    @Provides
//    @Singleton
//    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
//                                                           PreferencesHelper preferencesHelper) {
//        return new ApiHeader.ProtectedApiHeader(
//                apiKey,
//                preferencesHelper.getCurrentUserId(),
//                preferencesHelper.getAccessToken());
//    }
//
//    @Provides
//    SchedulerProvider provideSchedulerProvider() {
//        return new AppSchedulerProvider();
//    }
}
