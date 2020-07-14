package com.example.myapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.data.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Delete
    void delete(User user);

//    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
//    Single<User> findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

    @Query("SELECT * FROM users")
    List<User> loadAll();

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<User> loadAllByIds(List<Integer> userIds);
}
