package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TechSpecs extends AppCompatActivity {

    ImageButton questionsBtn2, techspecsBtn2, commentsBtn2, picturesBtn2;
    TextView questionsTitleTxt2, techspecsTitleTxt2, commentstitleTxt2, picturesTitleTxt2, inputBack2;
    ImageView background2, home2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_specs);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        questionsBtn2 = findViewById(R.id.questionsUnclicked2);
        techspecsBtn2 = findViewById(R.id.techspecsClicked2);
        commentsBtn2 = findViewById(R.id.commentsUnclicked2);
        picturesBtn2 = findViewById(R.id.picturesUnclicked2);

        questionsTitleTxt2 = findViewById(R.id.questionsTitleText2);
        techspecsTitleTxt2 = findViewById(R.id.techspecsTitleText2);
        commentstitleTxt2 = findViewById(R.id.commentsTitleText2);
        picturesTitleTxt2 = findViewById(R.id.picturesTitleText2);
        inputBack2 = findViewById(R.id.techspecsInputBack);

        background2 = findViewById(R.id.techspecsBackground);
        home2 = findViewById(R.id.techspecsHome);


        questionsBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(TechSpecs.this, Questions.class);
                startActivity(intent);
            }
        });

        commentsBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(TechSpecs.this, Comments.class);
                startActivity(intent);
            }
        });

        picturesBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(TechSpecs.this, PictureScreen.class);
                startActivity(intent);
            }
        });
    }
}