package com.example.customquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView register, forgotPassword;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        register = (TextView)  findViewById(R.id.register);
        register.setOnClickListener(this);

        signIn = (Button)  findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editTextEmail = (EditText)  findViewById(R.id.email);
        editTextEmail.setOnClickListener(this);

        editTextPassword = (EditText)  findViewById(R.id.password);
        editTextPassword.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setOnClickListener(this);

        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;


            case R.id.signIn:
                userLogin();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(this,forgotPassword.class));
                break;
        }
    }

    private void userLogin() { // set login conditions
        String email = editTextEmail.getText().toString().trim();   // Return the string value that equates to editTextEmail. Any information about stylized text will be removed.
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {  // .isEmpty - if it's left blank this will happen until user adds information
            editTextEmail.setError("please enter a valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) { // emails have a distinctive pattern, this is an identifier.
            editTextEmail.setError("Please provide a valid email address");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {  // passsword cannot be lesser than 6
            editTextPassword.setError("Min password length should be 6 characters");
            editTextPassword.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()) {
                        //redirect to user profile
                        startActivity(new Intent(LoginActivity.this, homeSplash.class));  // FitnessCareApp@gmail.com / - Fitness123
                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this, "Not Verified, Check your email", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Failed to login user, try again!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



