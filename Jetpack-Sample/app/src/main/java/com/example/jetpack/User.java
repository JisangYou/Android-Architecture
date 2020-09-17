package com.example.jetpack;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int id;

    public String firstName;
    public String lastName;
}
