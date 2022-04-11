package com.cop4655.puggymotivation;

import android.content.Intent;
import android.os.Bundle;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    static final String TAG = "LoginActivityDebug";
    EditText username, password;
    Button loginButton, signUpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser() != null){
            goToMainActivity();
        }
        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            logInUser(username.getText().toString(), password.getText().toString());
        });
        signUpButton = findViewById(R.id.buttonStartSignUp);
        signUpButton.setOnClickListener(view -> {
            Log.i(TAG, "Start Sign Up Flow ...");
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);

//            signUpUser(username.getText().toString(), password.getText().toString());
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

    private void logInUser(String username, String password){

        Log.i(TAG, "Attempting to Login with Username: " + username + " Password: " + password);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with Login", e);
                    Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT);
                    return;
                }
                goToMainActivity();

            }
        });


    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
