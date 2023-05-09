package com.example.customquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class plank extends AppCompatActivity {

    Chronometer chronometer;
    LinearLayout tips;
    long pause = 0;
    boolean active = false;
    ImageView back;
    ToggleButton startBtn;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plank);
        getSupportActionBar().hide();

        chronometer = findViewById(R.id.chronometer);
        startBtn = findViewById(R.id.startBtn);
        tips = findViewById(R.id.tips);
        resetBtn = findViewById(R.id.resetBtn);
        back = findViewById(R.id.back);
        startBtn.setText(null);
        startBtn.setTextOn(null);
        startBtn.setTextOff(null);
        startBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean toggle) {
                if(toggle){
                    chronometer.setBase(SystemClock.elapsedRealtime()- pause);
                    chronometer.start();
                    active = true;
                }else{
                    chronometer.stop();
                    pause = SystemClock.elapsedRealtime()- chronometer.getBase();
                    active = false;
                }
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plank.this, planktip.class);
                startActivity(intent);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conditions are set so resetBtn will be viable once startbutton is active
                if(active){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    pause = 0;
                    chronometer.start();
                    active = true;
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plank.this, WorkOut.class);
                startActivity(intent);
            }
        });
    }
}