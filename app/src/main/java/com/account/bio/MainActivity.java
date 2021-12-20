package com.account.bio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.documentfile.provider.DocumentFile;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
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

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

       // DownloadDocFiles();
        //Common.copyFile(getApplicationContext());
        copyFile();
        try {
            Common.docToPDF(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        //Toast.makeText(MainActivity.this, "Started", Toast.LENGTH_SHORT).show();
       /* InputStream XmlFileInputStream = getResources().openRawResource(R.raw.docfile); // getting XML
        //getResources().
        AssetManager am = getApplicationContext().getAssets();
        try {
            InputStream is = am.open("Locked CV.docx");
         //   am.
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
     void copyFile() {
        File dir = new File(Environment.getExternalStorageDirectory(), "BioAppFiles");
        String path = Environment.getExternalStorageDirectory()+"/BioAppFiles/";
        File file = new File(dir,"Locked CV.docx");
        if (!file.exists()) {
            dir.mkdirs();
        }
         Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
        AssetManager assetManager = getApplicationContext().getAssets();
        try {
            InputStream in = assetManager.open("Locked CV.docx");
            OutputStream out = new FileOutputStream(path+"Locked CV.docx");
            byte[] buffer = new byte[1024];
            int read = in.read(buffer);
            while (read != -1) {
                out.write(buffer, 0, read);
                read = in.read(buffer);
            }
            out.close();
            Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), dashBoard.class));
            finish();

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "copyFile Exception", Toast.LENGTH_SHORT).show();
            e.getMessage();
        }
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
                    document.close();
                    //Toast.makeText(MainActivity.this, "new ", Toast.LENGTH_SHORT).show();
                    out.close();
                    System.out.println("createdocument.docx written Successully");
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