package com.example.jetpack;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Address {

    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;
}

@Entity
class User5 {
    @PrimaryKey
    public int id;
    public String firstName;
    @Embedded
    public Address address;
}
