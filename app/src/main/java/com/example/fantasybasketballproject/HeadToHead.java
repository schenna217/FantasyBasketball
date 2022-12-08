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
    private int totalPointsTeamOne, totalPointsTeamTwo;
    ArrayList<String> allGameUpdates = new ArrayList<String>();
    ArrayList<String> offActions = new ArrayList<String>();
    ArrayList<String> defActions = new ArrayList<String>();
    TextView gameUpdates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_to_head);

        offActions.add("passes");
        offActions.add("scores");

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




    public void generatedOutcome () {
        teamOnePossession = tipOff.nextBoolean();

        while (totalPointsTeamOne < 11 && totalPointsTeamTwo < 11) {

            while (teamOnePossession == true) {
                //int randOffPlayer = (int) (Math.random() * rosterTeamOne.size() + 1);
                int randOffAction = (int) (Math.random() * offActions.size() + 1);

                //int randDefPlayer = (int) (Math.random() * rosterTeamTwo.size() + 1);
                int randDefAction = (int) (Math.random() * defActions.size() + 1);

                int offOrDef = (int) (Math.random() * 2 + 1);

                if (offOrDef == 1) {
                    String generatedOffString = "";
                    //generatedOffString += randOffPlayer + " " + offActions.get(randOffAction) + " the ball!";
                    allGameUpdates.add(generatedOffString);
                    if (randOffAction == 1) {
                        totalPointsTeamOne += 1;
                        teamOnePossession = true;
                    }
                } else if (offOrDef == 2) {
                    String generatedDefString = "";
                    //generatedDefString += randDefPlayer + " " + defActions.get(randDefAction) + " the ball!";
                    allGameUpdates.add(generatedDefString);
                    teamOnePossession = false;
                }

            }

            while (teamOnePossession == false) {
                //int randOffPlayer = Math.random() * rosterTeamTwo.size() + 1;
                int randOffAction = (int) (Math.random() * offActions.size() + 1);

                //int randDefPlayer = Math.random() * rosterTeamOne.size() + 1;
                int randDefAction = (int) (Math.random() * defActions.size() + 1);

                int offOrDef = (int) (Math.random() * 2 + 1);

                if (offOrDef == 1) {
                    String generatedOffString = "";
                    //generatedOffString += randOffPlayer + " " + offActions.get(randOffAction) + " the ball!";
                    allGameUpdates.add(generatedOffString);
                    if (randOffAction == 1) {
                        totalPointsTeamOne += 1;
                        teamOnePossession = true;
                    }
                }
                if (offOrDef == 2) {
                    String generatedDefString = "";
                    //generatedDefString += randDefPlayer + " " + defActions.get(randDefAction) + " the ball!";
                    allGameUpdates.add(generatedDefString);
                    teamOnePossession = true;
                }

            }

        }
        String end = "End of Game!\nTeam 1: " + totalPointsTeamOne + "\nTeam2: " + totalPointsTeamTwo;
        allGameUpdates.add(end);
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