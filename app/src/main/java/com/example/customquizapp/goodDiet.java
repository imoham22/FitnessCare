package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class goodDiet extends AppCompatActivity {

    ImageView muscle, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_diet);
        getSupportActionBar().hide();

        muscle = findViewById(R.id.muscle);
        back = findViewById(R.id.back);

        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ingr = new Intent(goodDiet.this, MuscleGrowth.class);
                startActivity(ingr);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(goodDiet.this, foodTip.class);  // home screen
                startActivity(intent);
            }
        });
    }
}