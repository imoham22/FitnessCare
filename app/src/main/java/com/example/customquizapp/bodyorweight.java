package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class bodyorweight extends AppCompatActivity {

    ImageView back;

    RelativeLayout weight, body, diet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyorweight);
        getSupportActionBar().hide();

        back = findViewById(R.id.back);
        weight = findViewById(R.id.weights);
        diet = findViewById(R.id.diet);
        body = findViewById(R.id.body);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bodyorweight.this, HomePage.class);
                startActivity(intent);
            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bodyorweight.this, foodTip.class);
                startActivity(intent);
            }
        });

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bodyorweight.this, weightOut.class);
                startActivity(intent);
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bodyorweight.this, WorkOut.class);
                startActivity(intent);
            }
        });



    }
}