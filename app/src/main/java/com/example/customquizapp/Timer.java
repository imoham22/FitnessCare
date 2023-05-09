package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    TextView timer;
    Button startButton;
    String timevalue;
    private boolean timePass;
    private CountDownTimer countDownTimer;
    private long timeRemaining;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        startButton = findViewById(R.id.startButton);
        timer = findViewById(R.id.time);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timePass) {

                    stoptimer();

                }

                else {
                    startTimer();

                }
            }
        });


    }

    private void stoptimer() {

        countDownTimer.cancel();
        timePass= false;
        startButton.setText("START");
    }

    private void startTimer() {
        final CharSequence tvalue = timer.getText();
            String t1 = tvalue.toString();
            String t2 = t1.substring(0,2);
            String t3 = t1.substring(3,5);



            final int number = Integer.valueOf(t2) * 60+ Integer.valueOf(t3);
            timeRemaining = number * 1000;

            countDownTimer = new CountDownTimer(timeRemaining, 1000) {
                @Override
                public void onTick(long timeEnd) {

                    timeRemaining = timeEnd;
                    updateTimer();

                }

                @Override
                public void onFinish() {

                    int newvalue = Integer.valueOf(timevalue)+1;
                    if (newvalue<= 7) {
                        Intent intent = new Intent(Timer.this, Timer.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);                     //TEST IF I DON'T NEED THIS COZ IDK
                        intent.putExtra("value", String.valueOf(newvalue));
                        startActivity(intent);
                    }

                    else {

                        newvalue = 1;
                        Intent intent = new Intent(Timer.this, Timer.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value", String.valueOf(newvalue));
                        startActivity(intent);
                    }


                }
            }.start();
            startButton.setText("PAUSE");
            timePass = true;

    }

    private void updateTimer() {   // ITS A VARIABLE CHANGE IT

        int minutes = (int) timeRemaining/60000;
        int seconds = (int) timeRemaining%60000 / 1000;

        String timeLeftText = "";
        if(minutes<10) {
            timeLeftText = "0";
            timeLeftText = timeLeftText+minutes+":";
            if(seconds<10)
                timeLeftText+="0";
            timeLeftText+=seconds;
            timer.setText(timeLeftText);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

            }
        }

