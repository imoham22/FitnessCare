package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WorkOut extends AppCompatActivity {

    RelativeLayout pushUps, sitUps, squat, wallCrunch, plank;
    ImageView back, home;



    // https://www.pinterest.pt/spotebi/exercise-gifs/
    // https://www.spotebi.com/exercise-guide/split-squat-press/
    // https://www.spotebi.com/exercise-guide/deadlift-upright-row/













    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);
        getSupportActionBar().hide();

        pushUps = findViewById(R.id.pushUps);
        home = findViewById(R.id.home);
        pushUps = findViewById(R.id.pushUps);
        sitUps = findViewById(R.id.sitUps);
        back = findViewById(R.id.back);
        plank = findViewById(R.id.plank);
        wallCrunch = findViewById(R.id.wallCrunch);
        squat = findViewById(R.id.squat);


        pushUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkOut.this, pushUpTimer.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkOut.this, bodyorweight.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkOut.this, HomePage.class);
                startActivity(intent);
            }
        });

        sitUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(WorkOut.this, sitUps.class);
                startActivity(intent);  //loads previous activity.
            }
        });

        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkOut.this, plank.class);
                startActivity(intent);  //loads previous activity.
            }
        });

        wallCrunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkOut.this, wallCrunch.class);
                startActivity(intent);  //loads previous activity.
            }
        });

        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkOut.this, squat.class);
                startActivity(intent);  //loads previous activity.
            }
        });

    }
}