package com.example.pitscouting2023_legacysupport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Questions extends AppCompatActivity {

    EditText teamNumberInput;
    TextView inputBack1, teamNumTitleTxt, drivetrainTitleTxt, gamePieceAcquisitionTitleTxt, acquisitionConesTitleTxt, acquisitionCubesTitleTxt, acquisitionFloorTitleTxt, acquisitionHPTitleTxt, conePickupTitleTxt;
    ImageView background1, home1;
    CheckBox floorCubesCheck, floorConesCheck, HPCubesCheck, HPConesCheck, conePickupNoneCheck, conePickupHPCheck, conePickupUpCheck, conePickupDownCheck, conePickupAnyCheck;
    Spinner drivetrainSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        teamNumberInput = findViewById(R.id.teamNumInput);

        inputBack1 = findViewById(R.id.questionsInputBack);
        teamNumTitleTxt = findViewById(R.id.teamNumberTitle);
        drivetrainTitleTxt = findViewById(R.id.drivetrainTitle);
        gamePieceAcquisitionTitleTxt = findViewById(R.id.gamePieceAcquisitionTitle);
        acquisitionConesTitleTxt = findViewById(R.id.acquisitionConesTitle);
        acquisitionCubesTitleTxt = findViewById(R.id.acquisitionCubesTitle);
        acquisitionFloorTitleTxt = findViewById(R.id.acquisitionFloorTitle);
        acquisitionHPTitleTxt = findViewById(R.id.acquisitionHPTitle);
        conePickupTitleTxt = findViewById(R.id.conePickupTitle);

        background1 = findViewById(R.id.questionsBackground);
        home1 = findViewById(R.id.questionsHome);

        floorCubesCheck = findViewById(R.id.floorCubes);
        floorConesCheck = findViewById(R.id.floorCones);
        HPCubesCheck = findViewById(R.id.HPCubes);
        HPConesCheck = findViewById(R.id.HPCones);
        conePickupNoneCheck = findViewById(R.id.conePickupNone);
        conePickupHPCheck = findViewById(R.id.conePickupHP);
        conePickupUpCheck = findViewById(R.id.conePickupUp);
        conePickupDownCheck = findViewById(R.id.conePickupDown);
        conePickupAnyCheck = findViewById(R.id.conePickupAny);

        drivetrainSpinner = findViewById(R.id.drivetrain);

    }
}