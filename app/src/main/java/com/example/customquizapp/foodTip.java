package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.net.InetSocketAddress;

public class foodTip extends AppCompatActivity {

    RelativeLayout chia, chicSal, bburger, cod, salmon, wrap;
    ImageView back;
    LinearLayout tips;
    RelativeLayout work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tip);
        getSupportActionBar().hide();

        chia = findViewById(R.id.chia);
        salmon = findViewById(R.id.salmon);
        back = findViewById(R.id.back);
        cod = findViewById(R.id.cod);
        chicSal = findViewById(R.id.chicSal);
        bburger = findViewById(R.id.bburger);
        wrap = findViewById(R.id.wrap);
        work = findViewById(R.id.work);
        tips = findViewById(R.id.tips);

        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, ChiaOats.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, HomePage.class);
                startActivity(intent);
            }
        });

        chicSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, ChicSal.class);
                startActivity(intent);
            }
        });

        bburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, burger.class);
                startActivity(intent);
            }
        });

        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, cod.class);
                startActivity(intent);
            }
        });

        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, salmon.class);
                startActivity(intent);
            }
        });

        wrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, wrap.class);
                startActivity(intent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, goodDiet.class);
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodTip.this, WorkOut.class);
                startActivity(intent);
            }
        });
    }
}