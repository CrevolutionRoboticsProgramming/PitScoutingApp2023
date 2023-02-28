package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TechSpecs extends AppCompatActivity {

    ImageButton questionsBtn2, techspecsBtn2, commentsBtn2, picturesBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_specs);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


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