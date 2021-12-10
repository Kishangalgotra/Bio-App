package com.account.bio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.documentfile.provider.DocumentFile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import CommonFiles.Common;
import CommonFiles.Globaldata;
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
        //Toast.makeText(MainActivity.this, "Started", Toast.LENGTH_SHORT).show();
    }

    private void  DownloadDocFiles(){
        StorageReference islandRef = FirebaseStorage.getInstance().getReference().child("docfile.docx");
        File myDir = new File(Environment.getExternalStorageDirectory(), "BioAppFiles");
        String out = "DOCONE.docx";
        if (!myDir.exists()) {
            myDir.mkdirs();
            Toast.makeText(getApplicationContext(), "Directory Created", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(getApplicationContext(), "Directory Already Created ", Toast.LENGTH_SHORT).show();
        }
        Globaldata.docObject= new File(myDir, out);//File.createTempFile("docfile", "docx");

        islandRef.getFile(Globaldata.docObject).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                try {
                    XWPFDocument document = new XWPFDocument();
                    FileOutputStream out = new FileOutputStream( Globaldata.docObject);
                    document.write(out);
                    //Toast.makeText(MainActivity.this, "new ", Toast.LENGTH_SHORT).show();
                    out.close();
                    System.out.println("createdocument.docx written successully");
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "vhvgv ", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MainActivity.this, "Got it", Toast.LENGTH_SHORT).show();
                /*startActivity(new Intent(getApplicationContext(), dashBoard.class));
                finish();*/

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