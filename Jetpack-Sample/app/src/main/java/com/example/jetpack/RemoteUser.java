package com.example.jetpack;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(ignoredColumns = "picture")
public class RemoteUser extends User2 {
    @PrimaryKey
    public int id;
    public boolean hasVpn;
}
