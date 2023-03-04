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

public class Comments extends AppCompatActivity {

    EditText commentsInput;
    ImageButton questionsBtn3, techspecsBtn3, commentsBtn3, picturesBtn3;
    TextView questionsTitleTxt3, techspecsTitleTxt3, commentstitleTxt3, picturesTitleTxt3, inputBack3, pieceScoringAbilitytitleTxt, conesScoringTitleTxt, cubesScoringtitleTxt, floorScoringtitleTxt, middleScoringTitleTxt, highScoringtitleTxt, commentsInputTitleTxt;
    ImageView background3, home3;
    CheckBox  cubesFloorCheck, cubesMiddleCheck, cubesHighCheck, conesFloorCheck, conesMiddleCheck, conesHighCheck;
    SharedPreferences sp;
    String Comments;
    Boolean CubesFloorBoolean, CubesMiddleBoolean, CubesHighBoolean, ConesFloorBoolean, ConesMiddleBoolean, ConesHighBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        commentsInput = findViewById(R.id.comments);

        questionsBtn3 = findViewById(R.id.questionsUnclicked3);
        techspecsBtn3 = findViewById(R.id.techspecsUnclicked3);
        commentsBtn3 = findViewById(R.id.commentsClicked3);
        picturesBtn3 = findViewById(R.id.picturesUnclicked3);

        questionsTitleTxt3 = findViewById(R.id.questionsTitleText3);
        techspecsTitleTxt3 = findViewById(R.id.techspecsTitleText3);
        commentstitleTxt3 = findViewById(R.id.commentsTitleText3);
        picturesTitleTxt3 = findViewById(R.id.picturesTitleText3);
        inputBack3 = findViewById(R.id.commentsInputBack);
        pieceScoringAbilitytitleTxt = findViewById(R.id.pieceScoringAbilityTitle);
        conesScoringTitleTxt = findViewById(R.id.scoringAbilityConesTitle);
        cubesScoringtitleTxt = findViewById(R.id.scoringAbilityCubesTitle);
        floorScoringtitleTxt = findViewById(R.id.scoringAbilityFloorTitle);
        middleScoringTitleTxt = findViewById(R.id.scoringAbilityMiddleTitle);
        highScoringtitleTxt = findViewById(R.id.scoringAbilityHighTitle);
        commentsInputTitleTxt = findViewById(R.id.commentsTitle);

        background3 = findViewById(R.id.commentsBackground);
        home3 = findViewById(R.id.commentsHome);

        cubesFloorCheck = findViewById(R.id.cubesFloor);
        cubesMiddleCheck = findViewById(R.id.cubesMiddle);
        cubesHighCheck = findViewById(R.id.cubesHigh);
        conesFloorCheck = findViewById(R.id.conesFloor);
        conesMiddleCheck = findViewById(R.id.conesMiddle);
        conesHighCheck = findViewById(R.id.conesHigh);


        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);
        commentsInput.setText(new_sp.getString("Comments",""));
        cubesFloorCheck.setChecked(new_sp.getBoolean("CubesFloorCheck", false));
        cubesMiddleCheck.setChecked(new_sp.getBoolean("CubesMiddleCheck", false));
        cubesHighCheck.setChecked(new_sp.getBoolean("CubesHighCheck", false));
        conesFloorCheck.setChecked(new_sp.getBoolean("ConesFloorCheck", false));
        conesMiddleCheck.setChecked(new_sp.getBoolean("ConesMiddleCheck", false));
        conesHighCheck.setChecked(new_sp.getBoolean("ConesHighCheck", false));


        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                Comments = commentsInput.getText().toString();
                //check box inputs turned into a boolean
                if (cubesFloorCheck.isChecked()){
                    CubesFloorBoolean = true;
                } else {
                    CubesFloorBoolean = false;
                }

                if (cubesMiddleCheck.isChecked()){
                    CubesMiddleBoolean = true;
                } else {
                    CubesMiddleBoolean = false;
                }

                if (cubesHighCheck.isChecked()){
                    CubesHighBoolean = true;
                } else {
                    CubesHighBoolean = false;
                }

                if (conesFloorCheck.isChecked()){
                    ConesFloorBoolean = true;
                } else {
                    ConesFloorBoolean = false;
                }

                if (conesMiddleCheck.isChecked()){
                    ConesMiddleBoolean = true;
                } else {
                    ConesMiddleBoolean = false;
                }

                if (conesHighCheck.isChecked()){
                    ConesHighBoolean = true;
                } else {
                    ConesHighBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Comments", Comments);
                editor.putBoolean("CubesFloorCheck", CubesFloorBoolean);
                editor.putBoolean("CubesMiddleCheck", CubesMiddleBoolean);
                editor.putBoolean("CubesHighCheck", CubesHighBoolean);
                editor.putBoolean("ConesFloorCheck", ConesFloorBoolean);
                editor.putBoolean("ConesMiddleCheck", ConesMiddleBoolean);
                editor.putBoolean("ConesHighCheck", ConesHighBoolean);
                //updates all the sp
                editor.commit();

                Intent intent = new Intent(Comments.this, MainActivity.class);
                startActivity(intent);
            }
        });

        questionsBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                Comments = commentsInput.getText().toString();
                //check box inputs turned into a boolean
                if (cubesFloorCheck.isChecked()){
                    CubesFloorBoolean = true;
                } else {
                    CubesFloorBoolean = false;
                }

                if (cubesMiddleCheck.isChecked()){
                    CubesMiddleBoolean = true;
                } else {
                    CubesMiddleBoolean = false;
                }

                if (cubesHighCheck.isChecked()){
                    CubesHighBoolean = true;
                } else {
                    CubesHighBoolean = false;
                }

                if (conesFloorCheck.isChecked()){
                    ConesFloorBoolean = true;
                } else {
                    ConesFloorBoolean = false;
                }

                if (conesMiddleCheck.isChecked()){
                    ConesMiddleBoolean = true;
                } else {
                    ConesMiddleBoolean = false;
                }

                if (conesHighCheck.isChecked()){
                    ConesHighBoolean = true;
                } else {
                    ConesHighBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Comments", Comments);
                editor.putBoolean("CubesFloorCheck", CubesFloorBoolean);
                editor.putBoolean("CubesMiddleCheck", CubesMiddleBoolean);
                editor.putBoolean("CubesHighCheck", CubesHighBoolean);
                editor.putBoolean("ConesFloorCheck", ConesFloorBoolean);
                editor.putBoolean("ConesMiddleCheck", ConesMiddleBoolean);
                editor.putBoolean("ConesHighCheck", ConesHighBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(Comments.this, Questions.class);
                startActivity(intent);
            }
        });

        techspecsBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                Comments = commentsInput.getText().toString();
                //check box inputs turned into a boolean
                if (cubesFloorCheck.isChecked()){
                    CubesFloorBoolean = true;
                } else {
                    CubesFloorBoolean = false;
                }

                if (cubesMiddleCheck.isChecked()){
                    CubesMiddleBoolean = true;
                } else {
                    CubesMiddleBoolean = false;
                }

                if (cubesHighCheck.isChecked()){
                    CubesHighBoolean = true;
                } else {
                    CubesHighBoolean = false;
                }

                if (conesFloorCheck.isChecked()){
                    ConesFloorBoolean = true;
                } else {
                    ConesFloorBoolean = false;
                }

                if (conesMiddleCheck.isChecked()){
                    ConesMiddleBoolean = true;
                } else {
                    ConesMiddleBoolean = false;
                }

                if (conesHighCheck.isChecked()){
                    ConesHighBoolean = true;
                } else {
                    ConesHighBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Comments", Comments);
                editor.putBoolean("CubesFloorCheck", CubesFloorBoolean);
                editor.putBoolean("CubesMiddleCheck", CubesMiddleBoolean);
                editor.putBoolean("CubesHighCheck", CubesHighBoolean);
                editor.putBoolean("ConesFloorCheck", ConesFloorBoolean);
                editor.putBoolean("ConesMiddleCheck", ConesMiddleBoolean);
                editor.putBoolean("ConesHighCheck", ConesHighBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(Comments.this, TechSpecs.class);
                startActivity(intent);
            }
        });

        picturesBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the screen is changed all inputs will be saved with shared preferences

                //making the inputs into a string for the sp
                Comments = commentsInput.getText().toString();
                //check box inputs turned into a boolean
                if (cubesFloorCheck.isChecked()){
                    CubesFloorBoolean = true;
                } else {
                    CubesFloorBoolean = false;
                }

                if (cubesMiddleCheck.isChecked()){
                    CubesMiddleBoolean = true;
                } else {
                    CubesMiddleBoolean = false;
                }

                if (cubesHighCheck.isChecked()){
                    CubesHighBoolean = true;
                } else {
                    CubesHighBoolean = false;
                }

                if (conesFloorCheck.isChecked()){
                    ConesFloorBoolean = true;
                } else {
                    ConesFloorBoolean = false;
                }

                if (conesMiddleCheck.isChecked()){
                    ConesMiddleBoolean = true;
                } else {
                    ConesMiddleBoolean = false;
                }

                if (conesHighCheck.isChecked()){
                    ConesHighBoolean = true;
                } else {
                    ConesHighBoolean = false;
                }

                //creating a editor for the sp and naming it editor
                SharedPreferences.Editor editor = sp.edit();
                //using the editor to store the strings and booleans in the sp (green) that can be called from other screens as well
                editor.putString("Comments", Comments);
                editor.putBoolean("CubesFloorCheck", CubesFloorBoolean);
                editor.putBoolean("CubesMiddleCheck", CubesMiddleBoolean);
                editor.putBoolean("CubesHighCheck", CubesHighBoolean);
                editor.putBoolean("ConesFloorCheck", ConesFloorBoolean);
                editor.putBoolean("ConesMiddleCheck", ConesMiddleBoolean);
                editor.putBoolean("ConesHighCheck", ConesHighBoolean);
                //updates all the sp
                editor.commit();

                Intent intent  = new Intent(Comments.this, PictureScreen.class);
                startActivity(intent);
            }
        });
    }
}