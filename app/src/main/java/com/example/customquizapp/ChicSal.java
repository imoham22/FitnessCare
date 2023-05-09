package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChicSal extends AppCompatActivity {

    ImageView ingredients, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chic_sal);
        getSupportActionBar().hide();

        //https://www.bbcgoodfood.com/recipes/asian-chicken-salad reference

        ingredients = findViewById(R.id.ingredients);
        back = findViewById(R.id.back);

        ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ingr = new Intent(ChicSal.this, saladIng.class);
                startActivity(ingr);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChicSal.this, foodTip.class);  // home screen
                startActivity(intent);
            }
        });
    }
}