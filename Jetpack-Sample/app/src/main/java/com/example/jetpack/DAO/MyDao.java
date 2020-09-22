package com.example.jetpack.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.jetpack.User4;

import java.util.List;

@Dao
public interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User4... users);

    @Insert
    public void insertBothUsers(User4 user1, User4 user2);

    @Insert
    public void insertUsersAndFriends(User4 user1, List<User4> friends);

    @Update
    public void updateUsers(User4... user4s);

    @Delete
    public void deleteUsers(User4... users);

    @Query("SELECT * FROM user")
    public User4[] loadAllUsers();

    @Query("SELECT * FROM user4 WHERE age > :minAge")
    public User4[] loadAllUsersOlderThan(int minAge);

    @Query("SELECT * FROM user where firstName LIKE :search " + "OR lastName Like :search")
    public List<User4> findUSerWithName(String search);

    @Query("SELECT first_name, last_name FROM nametuple")
    public List<NameTuple> loadFullName();


}
