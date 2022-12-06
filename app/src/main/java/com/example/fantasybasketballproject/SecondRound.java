package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondRound extends AppCompatActivity {
    private String Ball = "1630163";
    private String Lillard = "203081";
    private String Irving = "202681";
    private String Garland = "1629636";
    private String Morant = "1629630";
    private String Young = "1629027";
    private String Doncic = "1629029";
    private String Curry = "201939";
    private String Paul = "101108";
    private String Giannis = "203507";
    private String Green = "1630224";
    private String Thompson = "202691";
    private String Beal = "203078";
    private String Lavine = "203897";
    private String Edwards = "1630162";
    private String Brown = "1627759";
    private String Mitchell = "1628378";
    private String Booker = "1626164";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_round);

        Player Ball = new Player(85, "Lamelo Ball", "point guard", "1630163");
        Player Lillard = new Player(92, "Damian Lillard", "point guard", "203081");
        Player Kyrie = new Player(90, "Kyrie Irving", "point guard", "202681");
        Player Garland = new Player(88, "Darius Garland", "point guard", "1629636");
        Player Morant = new Player(90, "Ja Morant", "point guard", "1630163");
        Player Young = new Player(90, "Trae Young", "point guard", "1630163");
        Player Doncic = new Player(90, "Luka Doncic", "point guard", "1630163");
        Player Curry = new Player(90, "Steph Curry", "point guard", "1630163");



    }


    }

