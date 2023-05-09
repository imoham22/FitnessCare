package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class chestflytip extends AppCompatActivity {

    ImageView workout, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestflytip);
        getSupportActionBar().hide();

        workout = findViewById(R.id.workout);
        back = findViewById(R.id.back);

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chestflytip.this, weightOut.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chestflytip.this, chestflyTime.class);  // home screen
                startActivity(intent);
            }
        });
    }
}