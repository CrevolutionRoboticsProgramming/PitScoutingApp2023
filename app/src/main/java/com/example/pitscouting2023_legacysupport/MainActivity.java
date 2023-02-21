package com.example.pitscouting2023_legacysupport;

import android.app.PictureInPictureUiState;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button picScreenBtn;

    //creating variables for everything on the .xml file
    Button startBtn;
    ImageView crevolutionLogoPic, startScreenBackground, startBtnUnderline;
    TextView pitScoutingTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //matching the variables created to the ids on the .xml files
        startBtn = findViewById(R.id.start);

        crevolutionLogoPic = findViewById(R.id.crevLogo);
        startScreenBackground = findViewById(R.id.mainActivityBack);
        startBtnUnderline = findViewById(R.id.startUnderline);

        pitScoutingTxt = findViewById(R.id.pitScouting);


        //click the startBtn to come to the auton screen
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //screen will be changed to the auton screen
                Intent changeScreens = new Intent(MainActivity.this, Questions.class);
                startActivity(changeScreens);
            }
        });


    }
}