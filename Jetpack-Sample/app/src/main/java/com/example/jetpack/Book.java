package com.example.jetpack;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


/**
 * 일 대 다 관계 정의하기
 */
@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id", childColumns = "user_id"))
public class Book {
    @PrimaryKey
    public int bookId;
    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;
}
