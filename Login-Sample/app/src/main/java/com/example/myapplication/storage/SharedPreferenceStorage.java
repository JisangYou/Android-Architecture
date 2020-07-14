package com.example.myapplication.storage;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedPreferenceStorage {
    Context context;

    @Inject
    public SharedPreferenceStorage(Context context) {
        this.context = context;
    }

    SharedPreferences sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE);

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }
}
