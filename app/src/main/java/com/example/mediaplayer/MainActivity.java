package com.example.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;
    private Button buttonPause;
    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);

        buttonPlay.setOnClickListener(v -> startMediaService("PLAY"));
        buttonPause.setOnClickListener(v -> startMediaService("PAUSE"));
        buttonStop.setOnClickListener(v -> startMediaService("STOP"));
    }

    private void startMediaService(String action) {
        Intent intent = new Intent(this, MediaPlayerService.class);
        intent.setAction(action);
        startService(intent);
    }
}