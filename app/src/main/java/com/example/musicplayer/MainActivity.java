package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView playbutton,pausebuttuon,leftbutton,rightbutton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbutton=findViewById(R.id.PlayButtonId);
        pausebuttuon=findViewById(R.id.PauseButtonId);
        leftbutton=findViewById(R.id.LeftButtonId);
        rightbutton=findViewById(R.id.RightButtonId);

        playbutton.setOnClickListener(this);
        pausebuttuon.setOnClickListener(this);
        leftbutton.setOnClickListener(this);
        rightbutton.setOnClickListener(this);

        mediaPlayer=MediaPlayer.create(this,R.raw.sarkar_shimu);
        mediaPlayer=MediaPlayer.create(this,R.raw.sarkar_shimu2);
    }

    @Override
    public void onClick(View view) {

         if(view.getId()==R.id.PlayButtonId){

             if(mediaPlayer!=null){
                 mediaPlayer.start();
                 mediaPlayer.getDuration();
                 Toast.makeText(MainActivity.this,"Play The Song",Toast.LENGTH_SHORT).show();
             }

         }
        if(view.getId()==R.id.PauseButtonId){

            if(mediaPlayer!=null){
                mediaPlayer.stop();
                Toast.makeText(MainActivity.this,"Stop The Song",Toast.LENGTH_SHORT).show();
            }

        }
        if(view.getId()==R.id.LeftButtonId){

            if(mediaPlayer!=null){

                Toast.makeText(MainActivity.this,"Move Left The Song",Toast.LENGTH_SHORT).show();
            }

        }
        if(view.getId()==R.id.RightButtonId){

            if(mediaPlayer!=null){

                Toast.makeText(MainActivity.this,"Move Right The Song",Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer!=null && mediaPlayer.isPlaying()){

            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }

        super.onDestroy();
    }
}