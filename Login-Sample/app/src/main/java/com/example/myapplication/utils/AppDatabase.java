package com.example.myapplication.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.data.dao.UserDao;
import com.example.myapplication.data.model.User;

//@Database(entities = {User.class, Question.class, Option.class}, version = 2)
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}