package com.example.exampractice2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.VideoView;
import android.widget.MediaController;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private MediaPlayer ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       // button = findViewById(R.id.button); // Ensure the button ID matches your layout
       // button.setOnClickListener(this::PlayMusic);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gotoNext(View view){
        EditText editTextText=findViewById(R.id.editTextText);
        String str=editTextText.getText().toString();

        Intent i=new Intent(MainActivity.this,NextActivity.class);
        i.putExtra("message","Hello ");
        i.putExtra("a",str);
        startActivity(i);
    }

    public void PlayMusic(View view) {
        ringtone = MediaPlayer.create(MainActivity.this, R.raw.ringtone);
        ringtone.start();
    }

    public void PlayVideo(View view){
        VideoView v=findViewById(R.id.videoView);

        v.setVideoPath("android.resource://" +getPackageName() + "/" + R.raw.video_demo);

        MediaController mc=new MediaController(this);
        mc.setAnchorView(v);
        mc.setMediaPlayer(v);
        v.setMediaController(mc);
        v.start();
    }
}
