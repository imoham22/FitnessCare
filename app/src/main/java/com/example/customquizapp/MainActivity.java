package com.example.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB;
    Button nextBtn;
    ImageView back;

    private Button home_button;

    int score = 0;
    int totalQuestion = Answer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        nextBtn = findViewById(R.id.next_button);
        back = findViewById(R.id.back);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Question : " + totalQuestion);

        loadNewQuestion();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);


        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.next_button) {

            if (selectedAnswer.equals(Answer.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }


    }

    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView.setText(Answer.question[currentQuestionIndex]);
        ansA.setText(Answer.choices[currentQuestionIndex][0]);
        ansB.setText(Answer.choices[currentQuestionIndex][1]);

    }
    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.6) {
            passStatus = "Passed ";

        } else {
            passStatus = "Failed";
        }


        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef.child(userID).child("score").setValue(score);


        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("You Scored " + score + " out of " + totalQuestion + "!")
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }


    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}
