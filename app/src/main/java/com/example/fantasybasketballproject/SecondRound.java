package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class SecondRound extends AppCompatActivity {
    private int Ball = 1630163;
    private int Lillard = 203081;
    private int Irving = 202681;
    private int Garland = 1629636;
    private int Morant = 1629630;
    private int Young = 1629607;
    private int Doncic = 1629029;
    private int Curry = 201939;
    private int Paul = 101108;
    private int Giannis = 203507;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_round);
        ArrayList<Integer> playerList = new ArrayList<Integer>();
        String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
        String P2 = ".png";
        playerList.add(Ball);
        playerList.add(Lillard);
        playerList.add(Irving);
        playerList.add(Garland);
        playerList.add(Morant);
        playerList.add(Young);
        playerList.add(Doncic);
        playerList.add(Curry);
        playerList.add(Giannis);
    }
//    public void arrangePlayers(){
//       int[] randPlayers = new int[];
//       randPlayers =
//
//    }
}