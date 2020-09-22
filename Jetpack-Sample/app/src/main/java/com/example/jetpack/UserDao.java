package com.example.jetpack;

import androidx.paging.DataSource;
import androidx.room.Query;

public interface UserDao {
    @Query("SELECT * FROM User")
    DataSource.Factory<Integer, User> getUsers();
}
