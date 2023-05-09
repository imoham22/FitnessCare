package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity  {

    CardView workOuts, dietPlans, bmiCal, question, stepCount, accountInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();


        workOuts = findViewById(R.id.workOuts);
        dietPlans = findViewById(R.id.dietPlans);
        bmiCal = findViewById(R.id.bmiCal);
        question = findViewById(R.id.question);
        stepCount = findViewById(R.id.stepCount);
        accountInfo = findViewById(R.id.accountInfo);


        bmiCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBMI();
            }

            private void openBMI() {
                Intent intent = new Intent(HomePage.this, BMIactivity.class);
                startActivity(intent);
            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuestion();
            }

            private void openQuestion() {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);

            }
        });

        workOuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWork();
            }

            private void openWork() {
                Intent intent = new Intent(HomePage.this, bodyorweight.class);
                startActivity(intent);

            }
        });

        dietPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiet();
            }

            private void openDiet() {
                Intent intent = new Intent(HomePage.this, foodTip.class);
                startActivity(intent);
            }
        });

        accountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAccount();
            }

            private void openAccount() {
                Intent intent = new Intent(HomePage.this, UserProfile.class);
                startActivity(intent);

            }
        });

        stepCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStep();
            }

            private void openStep() {
                Intent intent = new Intent(HomePage.this, StepCounter.class);
                startActivity(intent);

            }
        });
    }
}
