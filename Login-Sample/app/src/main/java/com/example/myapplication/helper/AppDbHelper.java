package com.example.myapplication.helper;

import android.database.Observable;

import com.example.myapplication.data.model.User;
import com.example.myapplication.utils.AppDatabase;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }


    @Override
    public Observable<Boolean> insertUser(User user) {
        return null;
    }
}

