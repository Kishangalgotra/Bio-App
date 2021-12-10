package com.account.bio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import DashBoard.dashBoard;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressbar;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        imageview = findViewById(R.id.imageView);
        imageview.setImageResource(R.drawable.screen_saver);
       /* CountDownTimer obj = new CountDownTimer(1000,3) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };
        obj.start();*/

        DownloadDocFiles();
        Toast.makeText(MainActivity.this, "Started", Toast.LENGTH_SHORT).show();
    }

    private void  DownloadDocFiles(){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference islandRef = storageRef.child("DocFiles/docfile.docx");

        File localFile = null;
        try {
            localFile= File.createTempFile("docfile", "docx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        islandRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(MainActivity.this, "Got it", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), dashBoard.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.i("Exception in doc fetch", exception.toString());
            }
        });
    }

}