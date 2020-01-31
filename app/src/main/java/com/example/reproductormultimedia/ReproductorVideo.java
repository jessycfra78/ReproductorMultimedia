package com.example.reproductormultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class ReproductorVideo extends AppCompatActivity {

    VideoView videoView;
    MediaController controller;
    View video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor_video);

        videoView = (VideoView) findViewById(R.id.videoView);
        controller = new MediaController(this);
        videoView.setMediaController(controller);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));

        videoView.requestFocus();

    }

    protected void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        if(controller != null){

        }
    }
}
