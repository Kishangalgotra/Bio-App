package com.account.bio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.File;
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
        CountDownTimer obj = new CountDownTimer(1000,3) {
            @Override
            public void onTick(long millisUntilFinished) {
                getClass().getResourceAsStream("ff.doc");
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), dashBoard.class));
                finish();
            }
        };
        obj.start();
    }
}