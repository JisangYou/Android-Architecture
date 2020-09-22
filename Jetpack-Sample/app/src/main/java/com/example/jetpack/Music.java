package com.example.jetpack;

import androidx.room.Dao;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

/**
 * 다 대 다 관계 정의하기.
 */

public class Music {
    @Entity
    class Playlist {
        @PrimaryKey
        public int id;
        public String name;
        public String description;
    }

    @Entity
    class Song {
        @PrimaryKey
        public int id;
        public String songName;
        public String artistName;
    }

    @Entity(tableName = "playlist_song_join", primaryKeys = {"playlistId", "songId"}, foreignKeys = {
            @ForeignKey(entity = Playlist.class, parentColumns = "id", childColumns = "playlistId"),
            @ForeignKey(entity = Song.class, parentColumns = "id", childColumns = "songId")
    })
    class PlaylistSongJoin {
        public int playlistId;
        public int songId;
    }

}



