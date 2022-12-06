package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class HeadToHead extends AppCompatActivity {

    private Random tipOff, playerScores, playerSteals, playerShoots;
    //If true, Team 1 has possession, else Team 2 has possession
    private boolean teamOnePossession;
    private int totalPoints, totalAssists, totalRebounds;
    private double playerPasses, playerRebounds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_to_head);

    }

    public String generatedOutcome () {
        teamOnePossession = tipOff.nextBoolean();

        if(teamOnePossession) {

        }
        return "done";
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

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
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
}