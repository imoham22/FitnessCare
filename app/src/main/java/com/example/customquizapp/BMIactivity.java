package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIactivity extends AppCompatActivity {


    EditText weight,feet,inch;
    CardView calButton;
    TextView calculate, dontworry, textView, recommend, graphbtn;
    LinearLayout mmale, mfemale;
    String typeofuser="0";
    ImageView back, imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().hide();

        calculate = findViewById(R.id.calculate);
        dontworry = findViewById(R.id.dontworry);
        calButton = findViewById(R.id.calButton);
        textView = findViewById(R.id.textView);
        recommend = findViewById(R.id.recommend);
        graphbtn = findViewById(R.id.graphbtn);
        feet = findViewById(R.id.feet);
        weight = findViewById(R.id.weight);
        inch = findViewById(R.id.inch);
        imageView = findViewById(R.id.imageView);
        back = findViewById(R.id.back);

        mmale = findViewById(R.id.male);
        mfemale= findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser = "Male";
            }
        });


        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser = "Female";
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMIactivity.this, HomePage.class);
                startActivity(intent);
            }
        });

        graphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMIactivity.this, chart.class);
                startActivity(intent);
            }
        });

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kg = weight.getText().toString();
                String ft = feet.getText().toString();
                String inc = inch.getText().toString();

                if (kg.length()>0&&ft.length()>0&&inc.length()>0){

                    float kilo = Float.parseFloat(kg);
                    float foot = Float.parseFloat(ft);
                    float in = Float.parseFloat(inc);

                    float height = (float) (foot*0.3048+ in*0.0254);
                    float bmiResult = kilo/(height*height);



                    if (bmiResult>28){

                        textView.setText("OBESE : "+bmiResult);
                        imageView.setImageResource(R.drawable.warning);
                        textView.setTextColor(Color.RED);
                        recommend.setText("We recommend you look at this");
                        dontworry.setText("But Don't worry, We have a solution!");
                        calculate.setText("Visit");
                        calculate.setTextColor(Color.RED);

                        calculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(BMIactivity.this, WorkOut.class);
                                startActivity(intent);
                            }
                        });

                    }else if (bmiResult>24){

                        textView.setText("Overweight : "+bmiResult);
                        imageView.setImageResource(R.drawable.ok);
                        textView.setTextColor(Color.RED);
                        recommend.setText("We recommend you look at this");
                        dontworry.setText("But Don't worry, We have a solution!");
                        calculate.setText("Visit");
                        calculate.setTextColor(Color.RED);

                        calculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(BMIactivity.this, WorkOut.class);
                                startActivity(intent);
                            }
                        });

                    } else if (bmiResult>18){

                        textView.setText("Normal : "+bmiResult);
                        imageView.setImageResource(R.drawable.ok);
                        textView.setTextColor(Color.GREEN);

                    }else {

                        textView.setText("Underweight : "+bmiResult);
                        imageView.setImageResource(R.drawable.warning);
                        textView.setTextColor(Color.RED);
                        recommend.setText("We recommend you look at this");
                        dontworry.setText("But Don't worry, We have a solution!");
                        calculate.setText("Visit");
                        calculate.setTextColor(Color.RED);

                        calculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(BMIactivity.this, goodDiet.class);
                                startActivity(intent);
                            }
                        });

                    }
                }
            }

        });


    }
}
