package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakoutRoom extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    int roomNum = 0;
    int room1users = 0;
    int room2users = 0;
    int room3users = 0;
    int room4users = 0;
    List<String> playerList =  Arrays.asList("Beal","Booker", "Murray");
    List<String> draftList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakout_room);
        draftList = new ArrayList<>();
    }


    public void joinRoom(View view)
    {
        myRef.child("Room" + roomNum).child("User List").push().setValue("Hello");
        Intent i = new Intent(BreakoutRoom.this, FirstRound.class);
        i.putExtra("key",roomNum);
        startActivity(i);
    }
    public void createRoom(View view)
    {
        myRef.child("Room " + roomNum).child("Player List").setValue(playerList);
        joinRoom(view);
    }
    public void room1(View view)
    {
        roomNum = 1;
        createRoom(view);
        Intent intent = new Intent(BreakoutRoom.this, FirstRound.class);
        startActivity(intent);
    }
    public void room2(View view)
    {
        roomNum = 2;
        createRoom(view);
        Intent intent = new Intent(BreakoutRoom.this, FirstRound.class);
        startActivity(intent);
    }
    public void room3(View view)
    {
        roomNum = 3;
        createRoom(view);
        Intent intent = new Intent(BreakoutRoom.this, FirstRound.class);
        startActivity(intent);
    }
    public void room4(View view)
    {
        roomNum = 4;
        createRoom(view);
        Intent intent = new Intent(BreakoutRoom.this, FirstRound.class);
        startActivity(intent);
    }

}