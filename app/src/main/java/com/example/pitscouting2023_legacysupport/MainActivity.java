package com.example.pitscouting2023_legacysupport;

import android.app.PictureInPictureUiState;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button picScreenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picScreenBtn = findViewById(R.id.picScreenBtn);

        picScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPicScreen = new Intent(MainActivity.this, PictureScreen.class);
                startActivity(goToPicScreen);
            }
        });
    }
}