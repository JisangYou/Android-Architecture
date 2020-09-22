package com.example.jetpack.databaseView;


import androidx.room.DatabaseView;
import androidx.room.RoomDatabase;



public abstract class AppDatabase extends RoomDatabase{
    public abstract UserDao userDao();
}

/**
 * 뷰 생성하기
 */
@DatabaseView("SELECT user.id, user.name, user.departmentId," + "department.name AS departmentName FROM user " + "INNER JOIN department ON user.departmentId = department.id")
public class UserDetail {
    public long id;
    public String name;
    public long departmentId;
    public String departmentName;
}