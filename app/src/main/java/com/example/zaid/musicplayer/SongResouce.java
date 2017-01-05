package com.example.zaid.musicplayer;

/**
 * Created by Zaid on 1/3/2017.
 */

public class SongResouce {
    private int SongResource;

    public void recieveSong (int Song){
        SongResource = Song;
    }
    public int getSong(){
        return SongResource;
    }

    @Override
    public String toString() {
        return "SongResouce{" +
                "SongResource=" + SongResource +
                '}';
    }
}
