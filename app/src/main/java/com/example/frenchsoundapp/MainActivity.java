package com.example.frenchsoundapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button , button2,button3,button4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

       button.setOnClickListener(this);
       button2.setOnClickListener(this);
       button3.setOnClickListener(this);
       button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Find the button by Id and play the sound

        int clickedButtonID = v.getId();

        if (clickedButtonID == R.id.button)
        {
            PlaySounds(R.raw.black);
        } else if (clickedButtonID == R.id.button2) {
            PlaySounds(R.raw.green);
        } else if (clickedButtonID == R.id.button3) {
            PlaySounds(R.raw.purple);
        } else if (clickedButtonID == R.id.button4) {
            PlaySounds(R.raw.red);
        }

    }

    public void PlaySounds(int id)
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}