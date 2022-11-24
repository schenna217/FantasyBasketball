package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }
    public void switchToHome(View view) {
        Intent intent = new Intent(this, ActivePlayerHome.class);
        startActivity(intent);
    }
    public void switchToRoster(View view) {
        Intent intent = new Intent(this, Roster.class);
        startActivity(intent);
    }
}