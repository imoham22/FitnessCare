package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class weightOut extends AppCompatActivity {

    RelativeLayout bicep, shoulder, tricep, chestp, chestf;
    ImageView back, home;



    // https://www.pinterest.pt/spotebi/exercise-gifs/
    // https://www.spotebi.com/exercise-guide/split-squat-press/
    // https://www.spotebi.com/exercise-guide/deadlift-upright-row/













    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_out);
        getSupportActionBar().hide();

        chestf = findViewById(R.id.chestf);
        chestp = findViewById(R.id.chestp);
        shoulder = findViewById(R.id.shoulder);
        bicep = findViewById(R.id.bicep);
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        tricep = findViewById(R.id.tricep);


        bicep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, BicepTime.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, bodyorweight.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, HomePage.class);
                startActivity(intent);
            }
        });

        tricep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, tricepTime.class);
                startActivity(intent);  //loads previous activity.
            }
        });

        chestp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, chestTime.class);
                startActivity(intent);  //loads previous activity.
            }
        });

        chestf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, chestflyTime.class);
                startActivity(intent);  //loads previous activity.
            }
        });

        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(weightOut.this, ShoulderTime.class);
                startActivity(intent);  //loads previous activity.
            }
        });

    }
}