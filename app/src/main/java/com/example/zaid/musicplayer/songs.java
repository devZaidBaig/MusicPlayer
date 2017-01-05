package com.example.zaid.musicplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Zaid on 1/3/2017.
 */

public class songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void player(View view){
        Bundle obj = new Bundle();
        obj.putInt("SongA",R.raw.happy_birthday_to_you);
        Intent intent = new Intent(songs.this,m_song_1.class);
        intent.putExtras(obj);
        startActivity(intent);
    }
    public void player1(View view){
        Bundle obj = new Bundle();
        obj.putInt("SongA",R.raw.yeh_dil_tum_bin_lagta);
        Intent intent = new Intent(songs.this,m_song_1.class);
        intent.putExtras(obj);
        startActivity(intent);
    }

    public void player2(View view){
        Bundle obj = new Bundle();
        obj.putInt("SongA",R.raw.yeh_maane_meri_jaan);
        Intent intent = new Intent(songs.this,m_song_1.class);
        intent.putExtras(obj);
        startActivity(intent);
    }

    public void player3(View view){
        Bundle obj = new Bundle();
        obj.putInt("SongA",R.raw.mohd_rafi_1);
        Intent intent = new Intent(songs.this,m_song_1.class);
        intent.putExtras(obj);
        startActivity(intent);
    }

    public void player4(View view){
        Bundle obj = new Bundle();
        obj.putInt("SongA",R.raw.dil_ne_dil_ko_pukara);
        Intent intent = new Intent(songs.this,m_song_1.class);
        intent.putExtras(obj);
        startActivity(intent);
    }

}
