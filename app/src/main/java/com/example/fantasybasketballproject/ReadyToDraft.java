package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReadyToDraft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_to_draft);
    }
    public void pressOk(View view){
        Intent intent = new Intent(ReadyToDraft.this, FirstRound.class);
        startActivity(intent);
    }
    public void notReadyToDraft(View view) {
        Intent intent = new Intent(ReadyToDraft.this, SignInScreen.class);
        startActivity(intent);
    }

}