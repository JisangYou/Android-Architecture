package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.FrameLayout;

import java.util.Random;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {


    @Provides
//    @FragmentScope
    Integer provideInt() {
        return new Random().nextInt();
    }
}

