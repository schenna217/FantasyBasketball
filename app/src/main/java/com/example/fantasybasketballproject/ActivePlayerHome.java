package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivePlayerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_player_home);
    }

    public void switchScreens(View view) {
        Intent intent = new Intent(this, FirstRound.class);
        startActivity(intent);
    }

    public void switchScreensRoster(View view) {
        Intent intent = new Intent(this, Roster.class);
        startActivity(intent);
    }

    public void switchScreensBack(View view) {
        Intent intent = new Intent(this, SignInScreen.class);
        startActivity(intent);
    }
}