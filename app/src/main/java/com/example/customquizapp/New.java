package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

        public class New extends AppCompatActivity {


            EditText edKg,edFeet,edIns;
            CardView cardBtn;
            TextView textView;
            RelativeLayout mmale, mfemale;
            String typeofuser="0";
            ImageView imageView;




            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_new);
                edFeet = findViewById(R.id.edFeet);
                edKg = findViewById(R.id.edKg);
                cardBtn = findViewById(R.id.cardBtn);
                textView = findViewById(R.id.textView);
                edIns = findViewById(R.id.edIns);
                imageView = findViewById(R.id.imageView);

                mmale = findViewById(R.id.male);
                mfemale= findViewById(R.id.female);

                mmale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                        mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                        typeofuser = "Male";
                    }
                });

                mfemale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                        mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                        typeofuser = "Female";
                    }
                });




                cardBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String kg = edKg.getText().toString();
                        String feet = edFeet.getText().toString();
                        String inc = edIns.getText().toString();

                        if (kg.length()>0&&feet.length()>0&&inc.length()>0){

                            float weight = Float.parseFloat(kg);
                            float efeet = Float.parseFloat(feet);
                            float eInc = Float.parseFloat(inc);

                            float height = (float) (efeet*0.3048+ eInc*0.0254);
                            float bmiIndex = weight/(height*height);



                            if (bmiIndex>24){

                                textView.setText("Overweight : "+bmiIndex);
                                imageView.setImageResource(R.drawable.ok);
                                textView.setTextColor(Color.BLACK);

                            }else if (bmiIndex>18){

                                textView.setText("Normal weight : "+bmiIndex);
                                imageView.setImageResource(R.drawable.ok);
                                textView.setTextColor(Color.RED);

                            }else {

                                textView.setText("Underweight : "+bmiIndex);
                                imageView.setImageResource(R.drawable.ok);
                                textView.setTextColor(Color.RED);

                            }





                        }
                    }

                });


            }
        }
