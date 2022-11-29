package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    List<String> playerList =  Arrays.asList("Beal","Booker", "Murray");
    List<String> draftList;
    int roomNum;
    int turnNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);

        ArrayList<String> playerList = new ArrayList<String>();
        String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
        String P2 = ".png";
        draftList = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            roomNum = Integer.parseInt(value);
        }
    }
    public void updateTurn(View view)
    {

    }
    public void arrangePlayers(){
    }
    public void draftFunction(View view) {
        int buttonNum = 0;
        if (view.getId() == R.id.b1)
        {
            buttonNum = 0;
            }
        if (view.getId() == R.id.b2)
        {

        }
        if (!playerList.get(buttonNum).equals("Picked")) {
            TextView player = (TextView) findViewById(R.id.textView);
            draftList.add(playerList.get(roomNum));
            System.out.println(draftList);
            playerList.set(roomNum, "Picked");
            System.out.println(playerList);
            updateRoom(view);
            } else {
                Toast.makeText(getApplicationContext(), "That player Has already been picked", Toast.LENGTH_LONG).show();
            }

    }
    public void updateRoom(View view)
    {
        myRef.child("Room " + roomNum).child("Player List").setValue(playerList);

    }





}