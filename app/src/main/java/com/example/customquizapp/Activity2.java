package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Activity2 extends AppCompatActivity {

    private Button question_button;
    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().hide();

        question_button = (Button) findViewById(R.id.question_button);
        question_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity();
            }
        });

        logOut = (Button) findViewById(R.id.signOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Activity2.this, LoginActivity.class));
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        startActivity(intent);

    }
}
