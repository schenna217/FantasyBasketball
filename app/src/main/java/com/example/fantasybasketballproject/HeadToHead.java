package com.example.fantasybasketballproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class HeadToHead extends AppCompatActivity {

    private Random tipOff, playerScores, playerSteals, playerShoots;
    //If true, Team 1 has possession, else Team 2 has possession
    private boolean teamOnePossession;
    private int totalPointsTeamOne, totalPointsTeamTwo, totalAssists, totalRebounds;
    private double playerPasses, playerRebounds;
    ArrayList<String> offActions = new ArrayList<String>();
    ArrayList<String> defActions = new ArrayList<String>();
    TextView gameUpdates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_to_head);

        offActions.add("passes");
        offActions.add("shoots");

        defActions.add("steals");
        defActions.add("blocks");

        gameUpdates = findViewById(R.id.gameUpdates);

        String test = "Miheer";
        // set value to the given TextView
//        gameUpdates.setText(generatedOutcome);

        // to perform the movement action
        // Moves the cursor or scrolls to the
        // top or bottom of the document
        gameUpdates.setMovementMethod(new ScrollingMovementMethod());

    }




    public String generatedOutcome () {
        teamOnePossession = tipOff.nextBoolean();

        while(totalPointsTeamOne < 11 && totalPointsTeamTwo < 11) {

//            if(teamOnePossession) {
//                int randOffPlayer = Math.random()*draftNumsTeamOne.size()+1;
//                int randOffAction = (int) (Math.random()*offActions.size()+1);
//                //play=  arrraylist(randint)
//                //act =  arraylistAction(rand2)
//                //play.act()
//
//                int randDefPlayer = Math.random()*draftNumsTeamTwo.size()+1;
//                int randDefAction = (int) (Math.random()*offActions.size()+1);
//                // str avtion
//
//                String str = "" +rosterList(randOffPlayer) + actionlIst(randOffAction);
//                // if(
//
//                return str;
//
//            }


//            if(!teamOnePossession) {
//
//            }
        }
    return "poop";
    }

    public boolean getTeamOnePossession() {
        return teamOnePossession;
    }

    public void setTeamOnePossession(boolean teamOnePossession) {
        this.teamOnePossession = teamOnePossession;
    }

    public Random getTipOff() {
        return tipOff;
    }

    public void setTipOff(Random tipOff) {
        this.tipOff = tipOff;
    }

    public Random getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(Random playerScores) {
        this.playerScores = playerScores;
    }

    public Random getPlayerSteals() {
        return playerSteals;
    }

    public void setPlayerSteals(Random playerSteals) {
        this.playerSteals = playerSteals;
    }

    public Random getPlayerShoots() {
        return playerShoots;
    }

    public void setPlayerShoots(Random playerShoots) {
        this.playerShoots = playerShoots;
    }

    public int getTotalPointsTeamOne() {
        return totalPointsTeamOne;
    }

    public void setTotalPointsTeamOne(int totalPointsTeamOne) {
        this.totalPointsTeamOne = totalPointsTeamOne;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public int getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(int totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public double getPlayerPasses() {
        return playerPasses;
    }

    public void setPlayerPasses(double playerPasses) {
        this.playerPasses = playerPasses;
    }

    public double getPlayerRebounds() {
        return playerRebounds;
    }

    public void setPlayerRebounds(double playerRebounds) {
        this.playerRebounds = playerRebounds;
    }

    public boolean isTeamOnePossession() {
        return teamOnePossession;
    }

    public int getTotalPointsTeamTwo() {
        return totalPointsTeamTwo;
    }

    public void setTotalPointsTeamTwo(int totalPointsTeamTwo) {
        this.totalPointsTeamTwo = totalPointsTeamTwo;
    }
}