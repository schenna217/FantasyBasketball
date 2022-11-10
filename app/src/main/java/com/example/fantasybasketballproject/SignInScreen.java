package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignInScreen extends AppCompatActivity {

    EditText username = findViewById(R.id.username);
    EditText password = findViewById(R.id.password);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);


    }

}