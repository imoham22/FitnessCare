package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class triceptip extends AppCompatActivity {

    ImageView workout, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceptip);
        getSupportActionBar().hide();

        workout = findViewById(R.id.workout);
        back = findViewById(R.id.back);

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(triceptip.this, weightOut.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(triceptip.this, tricepTime.class);  // home screen
                startActivity(intent);
            }
        });
    }
}