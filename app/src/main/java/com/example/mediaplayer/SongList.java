package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class SongList extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    Button play,prev,next;
    int pauseCurrentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);


        play=(Button)findViewById(R.id.playbtn);
        prev=(Button)findViewById(R.id.btnprev);
        next=(Button)findViewById(R.id.btnnext);

        play.setOnClickListener(this);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.playbtn:
                if(mediaPlayer==null) {
                    mediaPlayer = mediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                }else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPos);
                    mediaPlayer.start();
                }else {
                    mediaPlayer.pause();
                    pauseCurrentPos=mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.btnnext:
                break;
            case R.id.btnprev:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}