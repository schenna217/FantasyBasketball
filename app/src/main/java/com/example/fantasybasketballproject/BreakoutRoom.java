package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakoutRoom extends AppCompatActivity {

    Button button;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference roomRef;
    DatabaseReference playersRef;
    String roomName ="";
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
    public void createRoom()
    {
        roomRef.child("room" + roomNum).setValue(playerList);
        Intent intent = new Intent(BreakoutRoom.this, FirstRound.class);
        startActivity(intent);

    }

    public void setRoom(View v) {
        switch (v.getId()) {
            case R.id.button10:
                roomNum = 4;
                break;
            case R.id.button4:
                roomNum = 1;
                break;
            case R.id.button8:
                roomNum = 2;
                break;
            case R.id.button9:
                roomNum = 3;
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
        createRoom();
    }

}