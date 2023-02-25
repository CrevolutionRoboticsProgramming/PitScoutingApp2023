package com.example.pitscouting2023_legacysupport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PictureScreen extends AppCompatActivity {
    Button frontCaptureBtn, backCaptureBtn, sideCaptureBtn, frontSaveBtn, backSaveBtn, sideSaveBtn;
    ImageView frontImageView, backImageView, sideImageView;
    private static final int front_pic_id = 100;
    private static final int back_pic_id = 101;
    private static final int side_pic_id = 102;
    Bitmap frontImageBitmap, backImageBitmap, sideImageBitmap;

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
        frontSaveBtn = findViewById(R.id.saveFrontPicBtn);
        backSaveBtn = findViewById(R.id.saveBackPicBtn);
        sideSaveBtn = findViewById(R.id.saveSidePicBtn);

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

        frontSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to change file name so it saves the team # and what robot view it is
                String frontImageFileName = "teamnumber" + "FrontView";
                File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File frontImageFile = new File(storageDir, frontImageFileName + ".jpg");

                try (OutputStream outputStream = new FileOutputStream(frontImageFile)) {
                    frontImageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        backSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to change file name so it saves the team # and what robot view it is
                String backImageFileName = "teamnumber" + "BackView";
                File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File backImageFile = new File(storageDir, backImageFileName + ".jpg");

                try (OutputStream outputStream = new FileOutputStream(backImageFile)) {
                    backImageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        sideSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to change file name so it saves the team # and what robot view it is
                String sideImageFileName = "teamnumber" + "SideView";
                File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File sideImageFile = new File(storageDir, sideImageFileName + ".jpg");

                try (OutputStream outputStream = new FileOutputStream(sideImageFile)) {
                    sideImageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == front_pic_id) {
            // BitMap is data structure of image file which store the image in memory
            frontImageBitmap = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            frontImageView.setImageBitmap(frontImageBitmap);
        } else if (requestCode == back_pic_id) {
            backImageBitmap = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            backImageView.setImageBitmap(backImageBitmap);
        } else if (requestCode == side_pic_id) {
            sideImageBitmap = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            sideImageView.setImageBitmap(sideImageBitmap);
        }

    }
}