package com.account.marrige;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashBoard extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_bar_dashboard);
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp =null;
                switch (item.getItemId()) {
                    case R.id.Setting:
                        temp = new settingFragment();
                        break;

                    case R.id.Home:
                        temp = new HomeFragment();
                        break;

                    case R.id.View_BioData:
                        temp = new view_biodata_Fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,temp).commit();
                return true;
            }
        });
    }
}