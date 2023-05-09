package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class burger extends AppCompatActivity {

    ImageView ingredients, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);
        getSupportActionBar().hide();

        //https://www.bbcgoodfood.com/recipes/ultimate-makeover-burgers reference

        ingredients = findViewById(R.id.ingredients);
        back = findViewById(R.id.back);

        ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ingr = new Intent(burger.this, burgerIng.class);
                startActivity(ingr);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(burger.this, foodTip.class);  // home screen
                startActivity(intent);
            }
        });
    }
}