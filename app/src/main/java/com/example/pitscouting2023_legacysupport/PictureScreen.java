package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PictureScreen extends AppCompatActivity {
    Button frontCaptureBtn, backCaptureBtn, sideCaptureBtn;
    ImageView frontImageView, backImageView, sideImageView;
    private static final int front_pic_id = 100;
    private static final int back_pic_id = 101;
    private static final int side_pic_id = 102;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_screen);

        //get rid of action bar when running the app
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        frontCaptureBtn = findViewById(R.id.captureFrontBtn);
        backCaptureBtn = findViewById(R.id.captureBackBtn);
        sideCaptureBtn = findViewById(R.id.captureSideBtn);

        frontImageView = findViewById(R.id.frontPic);
        backImageView = findViewById(R.id.backPic);
        sideImageView = findViewById(R.id.sidePic);

        frontCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(camera_intent, front_pic_id);
            }
        });

        backCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, back_pic_id);
            }
        });

        sideCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, side_pic_id);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == front_pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            frontImageView.setImageBitmap(photo);
        }
        else if(requestCode == back_pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            backImageView.setImageBitmap(photo);
        }
        else if(requestCode == side_pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            sideImageView.setImageBitmap(photo);
        }

    }
}