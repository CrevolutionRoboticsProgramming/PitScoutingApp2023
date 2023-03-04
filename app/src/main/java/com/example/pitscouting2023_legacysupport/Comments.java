package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Comments extends AppCompatActivity {

    EditText commentsInput;
    ImageButton questionsBtn3, techspecsBtn3, commentsBtn3, picturesBtn3;
    TextView questionsTitleTxt3, techspecsTitleTxt3, commentstitleTxt3, picturesTitleTxt3, inputBack3, pieceScoringAbilitytitleTxt, conesScoringTitleTxt, cubesScoringtitleTxt, floorScoringtitleTxt, middleScoringTitleTxt, highScoringtitleTxt, commentsInputTitleTxt;
    ImageView background3, home3;
    SharedPreferences sp;

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


        //getting shared preferences
        sp = getSharedPreferences("TeamData", MODE_PRIVATE);

        //when the screen is changed to the auton screen if there was any text or checks already inputed then they will replace the otherwise blank inputs
        SharedPreferences new_sp = getApplicationContext().getSharedPreferences("TeamData", MODE_PRIVATE);

        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Comments.this, MainActivity.class);
                startActivity(intent);
            }
        });

        questionsBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Comments.this, Questions.class);
                startActivity(intent);
            }
        });

        techspecsBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Comments.this, TechSpecs.class);
                startActivity(intent);
            }
        });

        picturesBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Comments.this, PictureScreen.class);
                startActivity(intent);
            }
        });
    }
}