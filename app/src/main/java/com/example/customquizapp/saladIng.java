package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class saladIng extends AppCompatActivity {

    ImageView dietPage, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_ing);
        getSupportActionBar().hide();

        dietPage = findViewById(R.id.dietPage);
        back = findViewById(R.id.back);

        dietPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(saladIng.this, foodTip.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(saladIng.this, ChicSal.class);  // home screen
                startActivity(intent);
            }
        });
    }
}