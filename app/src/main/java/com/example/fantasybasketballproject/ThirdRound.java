package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class ThirdRound extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10;
    ImageView imageView11, imageView12, imageView13, imageView14, imageView15, imageView16;

    ArrayList<Player> playerList = new ArrayList<Player>();
    Player Embiid = new Player(95, "Joel Embiid", "center", "203954", "");
    Player Gobert = new Player(90, "Rudy Gobert", "center", "203497", "");
    Player Jokic = new Player(95, "Nikola Jokic", "center", "203999", "");
    Player Horford = new Player(85, "Al Horford", "center", "201143", "");
    Player Ayton = new Player(85, "Deandre Ayton", "center", "1629028", "");
    Player Allen = new Player(85, "Jarrett Allen", "center", "1628386", "");
    Player Holmgren = new Player(80, "Chet Holmgren", "center", "1631096", "");
    Player Drummond = new Player(80, "Andre Drummond", "center", "203083", "");

    Player Peter = new Player(95, "Peter Griffin", "center", R.drawable.petergriffin);
    Player Baratheon = new Player(90, "Baratheon", "center", R.drawable.baratheon);
    Player Default = new Player(90, "Default Skin", "center", R.drawable.defaultskin);
    Player Moe = new Player(85, "Moe Szyslak", "center", R.drawable.moesimpsons);
    Player Pitbull = new Player(80, "Pitbull", "center", R.drawable.pitbull);
    Player Shrek = new Player(80, "Shrek", "center", R.drawable.shrek);
    Player Heisenburg = new Player(85, "Heisenburg", "center", R.drawable.walterwhite);
    Player Waluigi = new Player(90, "Waluigi", "center", R.drawable.waluigi);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_round);
        playerList.add(Embiid);
        playerList.add(Gobert);
        playerList.add(Jokic);
        playerList.add(Horford);
        playerList.add(Ayton);
        playerList.add(Allen);
        playerList.add(Holmgren);
        playerList.add(Drummond);
        playerList.add(Peter);
        playerList.add(Baratheon);
        playerList.add(Default);
        playerList.add(Moe);
        playerList.add(Pitbull);
        playerList.add(Shrek);
        playerList.add(Heisenburg);
        playerList.add(Waluigi);
    }
}