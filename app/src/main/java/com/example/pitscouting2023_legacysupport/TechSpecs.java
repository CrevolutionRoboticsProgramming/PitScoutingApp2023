package com.example.pitscouting2023_legacysupport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TechSpecs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_specs);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}