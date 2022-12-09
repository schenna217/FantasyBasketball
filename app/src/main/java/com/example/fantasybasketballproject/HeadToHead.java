package com.example.fantasybasketballproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class HeadToHead extends AppCompatActivity {

    private String Lamelo = "1630163";
    private String Damian = "203081";
    private String Kyrie = "202681";
    private String Darius = "1629636";
    private String Ja = "1629630";
    private String Trae = "1629027";
    private String Luka = "1629029";
    private String Steph = "201939";
    private String Chris = "101108";
    private String Giannis = "203507";
    private String Jalen = "1630224";
    private String Klay = "202691";
    private String Bradley = "203078";
    private String Zach = "203897";
    private String Anthony1 = "1630162";
    private String Jaylen = "1627759";
    private String Donovan = "1628378";
    private String Devin = "1626164";



    public List<String> distinctIDs = Arrays.asList(Lamelo, Damian, Kyrie, Darius, Ja, Trae, Luka, Steph, Chris
            , Giannis, Jalen, Klay, Bradley, Zach, Anthony1, Jaylen, Donovan, Devin);

    ArrayList<String> imageLinks = new ArrayList<>();


    private Random tipOff, playerScores, playerSteals, playerShoots;
    //If true, Team 1 has possession, else Team 2 has possession
    private boolean teamOnePossession;
    private int totalPointsTeamOne, totalPointsTeamTwo;
    Intent getRosters = getIntent();
    List<String> rosterTeamOne = new ArrayList<>();
    List<String> rosterTeamTwo = new ArrayList<>();
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
        createLinks();

        rosterTeamOne.add(imageLinks.get(3));
        rosterTeamOne.add(imageLinks.get(5));
        rosterTeamOne.add(imageLinks.get(7));
        rosterTeamOne.add(imageLinks.get(1));
        rosterTeamOne.add(imageLinks.get(9));

        rosterTeamTwo.add(imageLinks.get(2));
        rosterTeamTwo.add(imageLinks.get(4));
        rosterTeamTwo.add(imageLinks.get(6));
        rosterTeamTwo.add(imageLinks.get(0));
        rosterTeamTwo.add(imageLinks.get(8));

        gameUpdates = findViewById(R.id.gameUpdates);

        gameUpdates.setMovementMethod(new ScrollingMovementMethod());
        generatedOutcome();
        gameUpdates.append(displayGameUpdates());

    }

    public String displayGameUpdates() {
        String formattedGameUpdates = "";
        for (int i = 0; i < allGameUpdates.size(); i++) {
            formattedGameUpdates += allGameUpdates.get(i) + "\n";
        }
        return formattedGameUpdates;
    }

    public void generatedOutcome () {
        teamOnePossession = tipOff.nextBoolean();

        while (totalPointsTeamOne < 11 && totalPointsTeamTwo < 11) {

            while (teamOnePossession == true) {
                int randOffPlayer = (int) (Math.random() * rosterTeamOne.size() + 1);
                int randOffAction = (int) (Math.random() * offActions.size() + 1);

                int randDefPlayer = (int) (Math.random() * rosterTeamTwo.size() + 1);
                int randDefAction = (int) (Math.random() * defActions.size() + 1);

                int offOrDef = (int) (Math.random() * 2 + 1);

                if (offOrDef == 1) {
                    String generatedOffString = "";
                    generatedOffString += randOffPlayer + " " + offActions.get(randOffAction) + " the ball!";
                    allGameUpdates.add(generatedOffString);
                    if (randOffAction == 1) {
                        totalPointsTeamOne += 1;
                        teamOnePossession = true;
                    }
                } else if (offOrDef == 2) {
                    String generatedDefString = "";
                    generatedDefString += randDefPlayer + " " + defActions.get(randDefAction) + " the ball!";
                    allGameUpdates.add(generatedDefString);
                    teamOnePossession = false;
                }

            }

            while (teamOnePossession == false) {
                int randOffPlayer = (int)(Math.random() * rosterTeamTwo.size() + 1);
                int randOffAction = (int) (Math.random() * offActions.size() + 1);

                int randDefPlayer = (int)(Math.random() * rosterTeamOne.size() + 1);
                int randDefAction = (int) (Math.random() * defActions.size() + 1);

                int offOrDef = (int) (Math.random() * 2 + 1);

                if (offOrDef == 1) {
                    String generatedOffString = "";
                    generatedOffString += randOffPlayer + " " + offActions.get(randOffAction) + " the ball!";
                    allGameUpdates.add(generatedOffString);
                    if (randOffAction == 1) {
                        totalPointsTeamOne += 1;
                        teamOnePossession = true;
                    }
                }
                if (offOrDef == 2) {
                    String generatedDefString = "";
                    generatedDefString += randDefPlayer + " " + defActions.get(randDefAction) + " the ball!";
                    allGameUpdates.add(generatedDefString);
                    teamOnePossession = true;
                }

            }

        }
        String end = "End of Game!\nTeam 1: " + totalPointsTeamOne + "\nTeam2: " + totalPointsTeamTwo;
        allGameUpdates.add(end);
    }

    public void createLinks(){
        for (String i : distinctIDs) {
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";

            imageLinks.add(createdLink);
        }

    }

    public boolean getTeamOnePossession() {return teamOnePossession;}
    public void setTeamOnePossession(boolean teamOnePossession) {this.teamOnePossession = teamOnePossession;}

    public Random getTipOff() {return tipOff;}
    public void setTipOff(Random tipOff) {this.tipOff = tipOff;}

    public Random getPlayerScores() {return playerScores;}
    public void setPlayerScores(Random playerScores) {this.playerScores = playerScores;}

    public Random getPlayerSteals() {return playerSteals;}
    public void setPlayerSteals(Random playerSteals) {this.playerSteals = playerSteals;}

    public Random getPlayerShoots() {return playerShoots;}
    public void setPlayerShoots(Random playerShoots) {this.playerShoots = playerShoots;}

    public int getTotalPointsTeamOne() {return totalPointsTeamOne;}
    public void setTotalPointsTeamOne(int totalPointsTeamOne) {this.totalPointsTeamOne = totalPointsTeamOne;}

    public boolean isTeamOnePossession() {return teamOnePossession;}

    public int getTotalPointsTeamTwo() {return totalPointsTeamTwo;}
    public void setTotalPointsTeamTwo(int totalPointsTeamTwo) {this.totalPointsTeamTwo = totalPointsTeamTwo;}
}