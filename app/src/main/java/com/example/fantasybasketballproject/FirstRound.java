package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstRound extends AppCompatActivity {
    private int A = 1630163;
    private int Lillard = 203081;
    private int Irving = 202681;
    private int Garland = 1629636;
    private int Morant = 1629630;
    private int Young = 1629607;
    private int Doncic = 1629029;
    private int Curry = 201939;
    private int Paul = 101108;
    private int Giannis = 203507;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    int roomNum = 0;
    List<String> playerList =  Arrays.asList("Beal","Booker", "Murray");
    List<String> draftList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);

        ArrayList<String> playerList = new ArrayList<String>();
        String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
        String P2 = ".png";
        draftList = new ArrayList<>();

    }
    public void arrangePlayers(){

    }
    public void draftFunction(View view) {

        if (roomNum >= 0 && roomNum < playerList.size()) {
            if (!playerList.get(roomNum).equals("Picked")) {
                TextView player = (TextView) findViewById(R.id.textView);
                draftList.add(playerList.get(roomNum));
                System.out.println(draftList);
                playerList.set(roomNum, "Picked");
                System.out.println(playerList);
                updateRoom(view);
            } else {
                Toast.makeText(getApplicationContext(), "That player Has already been picked", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please Select a Value within the List", Toast.LENGTH_LONG).show();
        }
    }
    public void updateRoom(View view)
    {
        myRef.child("Room " + roomNum).child("Player List").setValue(playerList);

    }





}