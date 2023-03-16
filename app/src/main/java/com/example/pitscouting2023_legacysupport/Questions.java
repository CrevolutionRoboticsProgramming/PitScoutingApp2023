package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Questions extends AppCompatActivity {

    EditText teamNumberInput;
    ImageButton questionsBtn1, techspecsBtn1, commentsBtn1, picturesBtn1;
    TextView questionsTitleTxt1, techspecsTitleTxt1, commentstitleTxt1, picturesTitleTxt1, inputBack1, teamNumTitleTxt, drivetrainTitleTxt, gamePieceAcquisitionTitleTxt, acquisitionConesTitleTxt, acquisitionCubesTitleTxt, acquisitionFloorTitleTxt, acquisitionHPTitleTxt, conePickupTitleTxt;
    ImageView background1, home1;
    CheckBox floorCubesCheck, floorConesCheck, HPCubesCheck, HPConesCheck, conePickupNoneCheck, conePickupHPCheck, conePickupUpCheck, conePickupDownCheck, conePickupAnyCheck;
    Spinner drivetrainSpinner;
    SharedPreferences sp;
    String teamNumberInputString;
    Boolean floorCubesBoolean, floorConesBoolean, HPCubesBoolean, HPConesBoolean, coneNoneBoolean, coneHPBoolean, coneUpBoolean, coneDownBoolean, coneAnyBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        teamNumberInput = findViewById(R.id.teamNumInput);

        questionsBtn1 = findViewById(R.id.questionsClicked);
        techspecsBtn1 = findViewById(R.id.techspecsUnclicked);
        commentsBtn1 = findViewById(R.id.commentsUnclicked);
        picturesBtn1 = findViewById(R.id.picturesUnclicked);

        questionsTitleTxt1 = findViewById(R.id.questionsTitleText);
        techspecsTitleTxt1 = findViewById(R.id.techspecsTitleText);
        commentstitleTxt1 = findViewById(R.id.commentsTitleText);
        picturesTitleTxt1 = findViewById(R.id.picturesTitleText);
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
        String[] spinnerOptions = new String[]{"Swerve Drive", "Tank Drive", "Option 3", "Option 4?", "Other"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerOptions);
        drivetrainSpinner.setAdapter(adapter);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        teamNumberInput.setText(new_sp.getString("TeamNumber",""));
        //drivetrainSpinner
        floorCubesCheck.setChecked(new_sp.getBoolean("FloorCubesCheck",false));
        floorConesCheck.setChecked(new_sp.getBoolean("FloorConesCheck",false));
        HPCubesCheck.setChecked(new_sp.getBoolean("HPCubesCheck",false));
        HPConesCheck.setChecked(new_sp.getBoolean("HPConesCheck",false));
        conePickupNoneCheck.setChecked(new_sp.getBoolean("ConePickupNoneCheck", false));
        conePickupHPCheck.setChecked(new_sp.getBoolean("ConePickupHPCheck", false));
        conePickupUpCheck.setChecked(new_sp.getBoolean("ConePickupUpCheck", false));
        conePickupDownCheck.setChecked(new_sp.getBoolean("ConePickupDownCheck", false));
        conePickupAnyCheck.setChecked(new_sp.getBoolean("ConePickupAnyCheck", false));


        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                teamNumberInputString = teamNumberInput.getText().toString();
                //check box inputs turned into a boolean
                if (floorCubesCheck.isChecked()){
                    floorCubesBoolean = true;
                } else {
                    floorCubesBoolean = false;
                }

                if (floorConesCheck.isChecked()){
                    floorConesBoolean = true;
                } else {
                    floorConesBoolean = false;
                }

                if (HPConesCheck.isChecked()){
                    HPConesBoolean = true;
                } else {
                    HPConesBoolean = false;
                }

                if (HPCubesCheck.isChecked()){
                    HPCubesBoolean = true;
                } else {
                    HPCubesBoolean = false;
                }

                if (conePickupNoneCheck.isChecked()){
                    coneNoneBoolean = true;
                } else {
                    coneNoneBoolean = false;
                }

                if (conePickupHPCheck.isChecked()){
                    coneHPBoolean = true;
                } else {
                    coneHPBoolean = false;
                }

                if (conePickupUpCheck.isChecked()){
                    coneUpBoolean = true;
                } else {
                    coneUpBoolean = false;
                }

                if (conePickupDownCheck.isChecked()){
                    coneDownBoolean = true;
                } else {
                    coneDownBoolean = false;
                }

                if (conePickupAnyCheck.isChecked()){
                    coneAnyBoolean = true;
                } else {
                    coneAnyBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putBoolean("FloorCubesCheck", floorCubesBoolean);
                editor.putBoolean("FloorConesCheck", floorConesBoolean);
                editor.putBoolean("HPCubesCheck", floorCubesBoolean);
                editor.putBoolean("HPConesCheck", HPConesBoolean);
                editor.putBoolean("ConePickupNoneCheck", coneNoneBoolean);
                editor.putBoolean("ConePickupHPCheck", coneHPBoolean);
                editor.putBoolean("ConePickupUpCheck", coneUpBoolean);
                editor.putBoolean("ConePickupDownCheck", coneDownBoolean);
                editor.putBoolean("ConePickupAnyCheck", coneAnyBoolean);
                //updates all the sp
                editor.commit();

                //screen will be changed to the home screen
                Intent intent = new Intent(Questions.this, MainActivity.class);
                startActivity(intent);
            }
        });

        techspecsBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                teamNumberInputString = teamNumberInput.getText().toString();
                //check box inputs turned into a boolean
                if (floorCubesCheck.isChecked()){
                    floorCubesBoolean = true;
                } else {
                    floorCubesBoolean = false;
                }

                if (floorConesCheck.isChecked()){
                    floorConesBoolean = true;
                } else {
                    floorConesBoolean = false;
                }

                if (HPConesCheck.isChecked()){
                    HPConesBoolean = true;
                } else {
                    HPConesBoolean = false;
                }

                if (HPCubesCheck.isChecked()){
                    HPCubesBoolean = true;
                } else {
                    HPCubesBoolean = false;
                }

                if (conePickupNoneCheck.isChecked()){
                    coneNoneBoolean = true;
                } else {
                    coneNoneBoolean = false;
                }

                if (conePickupHPCheck.isChecked()){
                    coneHPBoolean = true;
                } else {
                    coneHPBoolean = false;
                }

                if (conePickupUpCheck.isChecked()){
                    coneUpBoolean = true;
                } else {
                    coneUpBoolean = false;
                }

                if (conePickupDownCheck.isChecked()){
                    coneDownBoolean = true;
                } else {
                    coneDownBoolean = false;
                }

                if (conePickupAnyCheck.isChecked()){
                    coneAnyBoolean = true;
                } else {
                    coneAnyBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putBoolean("FloorCubesCheck", floorCubesBoolean);
                editor.putBoolean("FloorConesCheck", floorConesBoolean);
                editor.putBoolean("HPCubesCheck", floorCubesBoolean);
                editor.putBoolean("HPConesCheck", HPConesBoolean);
                editor.putBoolean("ConePickupNoneCheck", coneNoneBoolean);
                editor.putBoolean("ConePickupHPCheck", coneHPBoolean);
                editor.putBoolean("ConePickupUpCheck", coneUpBoolean);
                editor.putBoolean("ConePickupDownCheck", coneDownBoolean);
                editor.putBoolean("ConePickupAnyCheck", coneAnyBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(Questions.this, TechSpecs.class);
                startActivity(intent);
            }
        });

        commentsBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                teamNumberInputString = teamNumberInput.getText().toString();
                //check box inputs turned into a boolean
                if (floorCubesCheck.isChecked()){
                    floorCubesBoolean = true;
                } else {
                    floorCubesBoolean = false;
                }

                if (floorConesCheck.isChecked()){
                    floorConesBoolean = true;
                } else {
                    floorConesBoolean = false;
                }

                if (HPConesCheck.isChecked()){
                    HPConesBoolean = true;
                } else {
                    HPConesBoolean = false;
                }

                if (HPCubesCheck.isChecked()){
                    HPCubesBoolean = true;
                } else {
                    HPCubesBoolean = false;
                }

                if (conePickupNoneCheck.isChecked()){
                    coneNoneBoolean = true;
                } else {
                    coneNoneBoolean = false;
                }

                if (conePickupHPCheck.isChecked()){
                    coneHPBoolean = true;
                } else {
                    coneHPBoolean = false;
                }

                if (conePickupUpCheck.isChecked()){
                    coneUpBoolean = true;
                } else {
                    coneUpBoolean = false;
                }

                if (conePickupDownCheck.isChecked()){
                    coneDownBoolean = true;
                } else {
                    coneDownBoolean = false;
                }

                if (conePickupAnyCheck.isChecked()){
                    coneAnyBoolean = true;
                } else {
                    coneAnyBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putBoolean("FloorCubesCheck", floorCubesBoolean);
                editor.putBoolean("FloorConesCheck", floorConesBoolean);
                editor.putBoolean("HPCubesCheck", floorCubesBoolean);
                editor.putBoolean("HPConesCheck", HPConesBoolean);
                editor.putBoolean("ConePickupNoneCheck", coneNoneBoolean);
                editor.putBoolean("ConePickupHPCheck", coneHPBoolean);
                editor.putBoolean("ConePickupUpCheck", coneUpBoolean);
                editor.putBoolean("ConePickupDownCheck", coneDownBoolean);
                editor.putBoolean("ConePickupAnyCheck", coneAnyBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(Questions.this, Comments.class);
                startActivity(intent);
            }
        });

        picturesBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                teamNumberInputString = teamNumberInput.getText().toString();
                //check box inputs turned into a boolean
                if (floorCubesCheck.isChecked()){
                    floorCubesBoolean = true;
                } else {
                    floorCubesBoolean = false;
                }

                if (floorConesCheck.isChecked()){
                    floorConesBoolean = true;
                } else {
                    floorConesBoolean = false;
                }

                if (HPConesCheck.isChecked()){
                    HPConesBoolean = true;
                } else {
                    HPConesBoolean = false;
                }

                if (HPCubesCheck.isChecked()){
                    HPCubesBoolean = true;
                } else {
                    HPCubesBoolean = false;
                }

                if (conePickupNoneCheck.isChecked()){
                    coneNoneBoolean = true;
                } else {
                    coneNoneBoolean = false;
                }

                if (conePickupHPCheck.isChecked()){
                    coneHPBoolean = true;
                } else {
                    coneHPBoolean = false;
                }

                if (conePickupUpCheck.isChecked()){
                    coneUpBoolean = true;
                } else {
                    coneUpBoolean = false;
                }

                if (conePickupDownCheck.isChecked()){
                    coneDownBoolean = true;
                } else {
                    coneDownBoolean = false;
                }

                if (conePickupAnyCheck.isChecked()){
                    coneAnyBoolean = true;
                } else {
                    coneAnyBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("TeamNumber", teamNumberInputString);
                editor.putBoolean("FloorCubesCheck", floorCubesBoolean);
                editor.putBoolean("FloorConesCheck", floorConesBoolean);
                editor.putBoolean("HPCubesCheck", floorCubesBoolean);
                editor.putBoolean("HPConesCheck", HPConesBoolean);
                editor.putBoolean("ConePickupNoneCheck", coneNoneBoolean);
                editor.putBoolean("ConePickupHPCheck", coneHPBoolean);
                editor.putBoolean("ConePickupUpCheck", coneUpBoolean);
                editor.putBoolean("ConePickupDownCheck", coneDownBoolean);
                editor.putBoolean("ConePickupAnyCheck", coneAnyBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(Questions.this, PictureScreen.class);
                startActivity(intent);
            }
        });

    }
}