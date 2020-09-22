package com.example.jetpack;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.PrimaryKey;


/**
 * Fts4 Full Text Search로서 테이블 안에 존재하는 모든 텍스트를 검색하는 것이다.
 */

@Fts4(languageId = "lid")
@Entity(tableName = "users")
public class User3 {
    @PrimaryKey
    @ColumnInfo(name = "rowid")
    public int id;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "lid")
    int languageId;

}
