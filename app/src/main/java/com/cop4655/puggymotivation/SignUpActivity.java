package com.cop4655.puggymotivation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class SignUpActivity extends AppCompatActivity {

    static final String TAG = "LoginActivityDebug";
    EditText username, password, confirmPassword;
    Button loginButton, signUpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if(ParseUser.getCurrentUser() != null){
            goToMainActivity();
        }
        username = findViewById(R.id.signUpUsername);
        password = findViewById(R.id.signUpPassword);
        confirmPassword = findViewById(R.id.signUpConfirmPassword);


        signUpButton = findViewById(R.id.buttonSignUp);
        signUpButton.setOnClickListener(view -> {
            if(password.getText().toString().equals(confirmPassword.getText().toString()))
                signUpUser(username.getText().toString(), password.getText().toString());
            else
                Toast.makeText(this, "Passwords do not Match", Toast.LENGTH_SHORT).show();
        });


    }

    private void signUpUser(String username, String password){
        Log.i(TAG, "Attempting to Sign up with Username: " + username + " Password: " + password);
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(e -> {
            if (e != null) {
                Log.e(TAG, "Error Signing Up User", e);
                return;
            }
            goToMainActivity();
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finishAffinity();
    }
}
