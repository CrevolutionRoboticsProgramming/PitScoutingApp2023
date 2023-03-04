package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TechSpecs extends AppCompatActivity {

    EditText weightInput, numberOfAutonPathsInput, topSpeedInput, topSpeedSecondGearInput;
    ImageButton questionsBtn2, techspecsBtn2, commentsBtn2, picturesBtn2;
    TextView questionsTitleTxt2, techspecsTitleTxt2, commentstitleTxt2, picturesTitleTxt2, inputBack2, weightTitleTxt, dockingTitleTxt, autonPathsTitleTxt, gearSpeedTitleTxt, topSpeedTitleTxt, topSpeedSecondGearTitleTxt;
    ImageView background2, home2;
    CheckBox ableToDockCheck, ableToEngageCheck, ableToBuddyClimbCheck, secondGearCheck;
    SharedPreferences sp;
    String WeightInputString, AutonPathsInputString, TopSpeedInputString, TopSpeedSecondGearInputString;
    Boolean AbleToDockBoolean, AbleToEngageBoolean, AbleToBuddyClimbBoolean, SecondGearBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_specs);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        weightInput = findViewById(R.id.robotWeightInput);
        numberOfAutonPathsInput = findViewById(R.id.autonPathsInput);
        topSpeedInput = findViewById(R.id.gearTopSpeedInput);
        topSpeedSecondGearInput = findViewById(R.id.secondGearTopSpeedInput);

        questionsBtn2 = findViewById(R.id.questionsUnclicked2);
        techspecsBtn2 = findViewById(R.id.techspecsClicked2);
        commentsBtn2 = findViewById(R.id.commentsUnclicked2);
        picturesBtn2 = findViewById(R.id.picturesUnclicked2);

        questionsTitleTxt2 = findViewById(R.id.questionsTitleText2);
        techspecsTitleTxt2 = findViewById(R.id.techspecsTitleText2);
        commentstitleTxt2 = findViewById(R.id.commentsTitleText2);
        picturesTitleTxt2 = findViewById(R.id.picturesTitleText2);
        inputBack2 = findViewById(R.id.techspecsInputBack);
        weightTitleTxt = findViewById(R.id.weightTitleText);
        dockingTitleTxt = findViewById(R.id.dockingTitleText);
        autonPathsTitleTxt = findViewById(R.id.numberOfAutonPathsTitleText);
        gearSpeedTitleTxt = findViewById(R.id.gearSpeedTitleText);
        topSpeedTitleTxt = findViewById(R.id.topSpeedTitleText);
        topSpeedSecondGearTitleTxt = findViewById(R.id.topSpeedSecondGearTitleText);

        background2 = findViewById(R.id.techspecsBackground);
        home2 = findViewById(R.id.techspecsHome);

        ableToDockCheck = findViewById(R.id.ableToDock);
        ableToEngageCheck = findViewById(R.id.ableToEngage);
        ableToBuddyClimbCheck = findViewById(R.id.ableToBuddyClimb);
        secondGearCheck = findViewById(R.id.secondGear);

        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        weightInput.setText(new_sp.getString("Weight", ""));
        numberOfAutonPathsInput.setText(new_sp.getString("AutonPaths", ""));
        topSpeedInput.setText(new_sp.getString("TopSpeed", ""));
        topSpeedSecondGearInput.setText(new_sp.getString("TopSpeedSecondGear", ""));
        ableToDockCheck.setChecked(new_sp.getBoolean("AbleToDock", false));
        ableToEngageCheck.setChecked(new_sp.getBoolean("AbleToEngage", false));
        ableToBuddyClimbCheck.setChecked(new_sp.getBoolean("AbleToBuddyClimb", false));
        secondGearCheck.setChecked(new_sp.getBoolean("SecondGear", false));

        secondGearCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(secondGearCheck.isChecked()){
                    topSpeedSecondGearTitleTxt.setVisibility(View.VISIBLE);
                    topSpeedSecondGearInput.setVisibility(View.VISIBLE);
                } else {
                    topSpeedSecondGearTitleTxt.setVisibility(View.INVISIBLE);
                    topSpeedSecondGearInput.setVisibility(View.INVISIBLE);
                }
            }
        });

        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                WeightInputString = weightInput.getText().toString();
                AutonPathsInputString = numberOfAutonPathsInput.getText().toString();
                TopSpeedInputString = topSpeedInput.getText().toString();
                TopSpeedSecondGearInputString = topSpeedSecondGearInput.getText().toString();
                //check box inputs turned into a boolean
                if (ableToDockCheck.isChecked()){
                    AbleToDockBoolean = true;
                } else {
                    AbleToDockBoolean = false;
                }

                if (ableToEngageCheck.isChecked()){
                    AbleToEngageBoolean = true;
                } else {
                    AbleToEngageBoolean = false;
                }

                if (ableToBuddyClimbCheck.isChecked()){
                    AbleToBuddyClimbBoolean = true;
                } else {
                    AbleToBuddyClimbBoolean = false;
                }

                if (secondGearCheck.isChecked()){
                    SecondGearBoolean = true;
                } else {
                    SecondGearBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Weight", WeightInputString);
                editor.putString("AutonPaths", AutonPathsInputString);
                editor.putString("TopSpeed", TopSpeedInputString);
                editor.putString("TopSpeedSecondGear", TopSpeedSecondGearInputString);
                editor.putBoolean("AbleToDock", AbleToEngageBoolean);
                editor.putBoolean("AbleToBuddyClimb", AbleToBuddyClimbBoolean);
                editor.putBoolean("SecondGear", SecondGearBoolean);
                //updates all the sp
                editor.commit();

                Intent intent = new Intent(TechSpecs.this, MainActivity.class);
                startActivity(intent);
            }
        });

        questionsBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                WeightInputString = weightInput.getText().toString();
                AutonPathsInputString = numberOfAutonPathsInput.getText().toString();
                TopSpeedInputString = topSpeedInput.getText().toString();
                TopSpeedSecondGearInputString = topSpeedSecondGearInput.getText().toString();
                //check box inputs turned into a boolean
                if (ableToDockCheck.isChecked()){
                    AbleToDockBoolean = true;
                } else {
                    AbleToDockBoolean = false;
                }

                if (ableToEngageCheck.isChecked()){
                    AbleToEngageBoolean = true;
                } else {
                    AbleToEngageBoolean = false;
                }

                if (ableToBuddyClimbCheck.isChecked()){
                    AbleToBuddyClimbBoolean = true;
                } else {
                    AbleToBuddyClimbBoolean = false;
                }

                if (secondGearCheck.isChecked()){
                    SecondGearBoolean = true;
                } else {
                    SecondGearBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Weight", WeightInputString);
                editor.putString("AutonPaths", AutonPathsInputString);
                editor.putString("TopSpeed", TopSpeedInputString);
                editor.putString("TopSpeedSecondGear", TopSpeedSecondGearInputString);
                editor.putBoolean("AbleToDock", AbleToEngageBoolean);
                editor.putBoolean("AbleToBuddyClimb", AbleToBuddyClimbBoolean);
                editor.putBoolean("SecondGear", SecondGearBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(TechSpecs.this, Questions.class);
                startActivity(intent);
            }
        });

        commentsBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                WeightInputString = weightInput.getText().toString();
                AutonPathsInputString = numberOfAutonPathsInput.getText().toString();
                TopSpeedInputString = topSpeedInput.getText().toString();
                TopSpeedSecondGearInputString = topSpeedSecondGearInput.getText().toString();
                //check box inputs turned into a boolean
                if (ableToDockCheck.isChecked()){
                    AbleToDockBoolean = true;
                } else {
                    AbleToDockBoolean = false;
                }

                if (ableToEngageCheck.isChecked()){
                    AbleToEngageBoolean = true;
                } else {
                    AbleToEngageBoolean = false;
                }

                if (ableToBuddyClimbCheck.isChecked()){
                    AbleToBuddyClimbBoolean = true;
                } else {
                    AbleToBuddyClimbBoolean = false;
                }

                if (secondGearCheck.isChecked()){
                    SecondGearBoolean = true;
                } else {
                    SecondGearBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Weight", WeightInputString);
                editor.putString("AutonPaths", AutonPathsInputString);
                editor.putString("TopSpeed", TopSpeedInputString);
                editor.putString("TopSpeedSecondGear", TopSpeedSecondGearInputString);
                editor.putBoolean("AbleToDock", AbleToEngageBoolean);
                editor.putBoolean("AbleToBuddyClimb", AbleToBuddyClimbBoolean);
                editor.putBoolean("SecondGear", SecondGearBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(TechSpecs.this, Comments.class);
                startActivity(intent);
            }
        });

        picturesBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                WeightInputString = weightInput.getText().toString();
                AutonPathsInputString = numberOfAutonPathsInput.getText().toString();
                TopSpeedInputString = topSpeedInput.getText().toString();
                TopSpeedSecondGearInputString = topSpeedSecondGearInput.getText().toString();
                //check box inputs turned into a boolean
                if (ableToDockCheck.isChecked()){
                    AbleToDockBoolean = true;
                } else {
                    AbleToDockBoolean = false;
                }

                if (ableToEngageCheck.isChecked()){
                    AbleToEngageBoolean = true;
                } else {
                    AbleToEngageBoolean = false;
                }

                if (ableToBuddyClimbCheck.isChecked()){
                    AbleToBuddyClimbBoolean = true;
                } else {
                    AbleToBuddyClimbBoolean = false;
                }

                if (secondGearCheck.isChecked()){
                    SecondGearBoolean = true;
                } else {
                    SecondGearBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Weight", WeightInputString);
                editor.putString("AutonPaths", AutonPathsInputString);
                editor.putString("TopSpeed", TopSpeedInputString);
                editor.putString("TopSpeedSecondGear", TopSpeedSecondGearInputString);
                editor.putBoolean("AbleToDock", AbleToEngageBoolean);
                editor.putBoolean("AbleToBuddyClimb", AbleToBuddyClimbBoolean);
                editor.putBoolean("SecondGear", SecondGearBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(TechSpecs.this, PictureScreen.class);
                startActivity(intent);
            }
        });
    }
}