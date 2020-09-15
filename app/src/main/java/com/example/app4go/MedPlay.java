package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MedPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_play);

        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource("");
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this, mediaPlayer.getCurrentPosition(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();}
    }
}
