package com.example.jetpack;

import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlaylistSongJoinDao {
    @Insert
    void insert(Music.PlaylistSongJoin playlistSongJoin);

    @Query("SELECT * FROM playlist " + "INNER JOIN playlist_song_join.playlistId " + "WHERE playlist_song_join.songId=:songId")
    List<Music.Playlist> getPlaylistsForSong(final int songId);

    @Query("SELECT * FROM song " + "INNER JOIN playlist_song_join.songId " + "WHERE playlist_song_join.playlistId=:playlistId")
    List<Music.Song> getSongsForPlaylist(final int playlistId);
}
