package com.example.zaid.musicplayer;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Zaid on 1/3/2017.
 */

public class m_song_1 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private int count=0;
    private int SongResource;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    private boolean back = false;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Action bar Back button

    /**
     * Recieving song resources from songs class...
     * using key SongA
      */
    Bundle bm = getIntent().getExtras();
        SongResource = bm.getInt("SongA");
        mediaPlayer = MediaPlayer.create(m_song_1.this,SongResource);

    /**
     * Using Button operation
     */
    Button button = (Button)findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1){mediaPlayer = MediaPlayer.create(m_song_1.this,SongResource);}
                mediaPlayer.start();count=0;
                Toast.makeText(m_song_1.this, "Playing song", Toast.LENGTH_SHORT).show();
                mediaPlayer.setOnCompletionListener(onCompletionListener);

            }
        });

    Button button1 = (Button)findViewById(R.id.pause_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                Toast.makeText(m_song_1.this, "song paused", Toast.LENGTH_SHORT).show();
            }
        });

    Button button2 = (Button)findViewById(R.id.stop_button);
    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediaPlayer.stop();
            count=1;
            m_song_1.this.finish();
        }
      });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder exitdialog = new AlertDialog.Builder(this);
            exitdialog.setTitle("Exit Player");
            exitdialog.setMessage("Are you sure you want to go back?");
            exitdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(m_song_1.this,songs.class);startActivity(intent);
                    mediaPlayer.stop();
                    m_song_1.this.finish();
                }
            });
            exitdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = exitdialog.create();
            alertDialog.show();
        }
        return super.onKeyDown(keyCode,event);
    }
}
