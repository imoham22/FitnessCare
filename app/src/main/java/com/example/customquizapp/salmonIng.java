package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class salmonIng extends AppCompatActivity {

    ImageView dietPage, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_ing);
        getSupportActionBar().hide();

        dietPage = findViewById(R.id.dietPage);
        back = findViewById(R.id.back);

        dietPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salmonIng.this, foodTip.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salmonIng.this, salmon.class);  // home screen
                startActivity(intent);
            }
        });
    }
}