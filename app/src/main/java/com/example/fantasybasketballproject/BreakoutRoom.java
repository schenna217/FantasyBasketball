package com.example.fantasybasketballproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakoutRoom extends AppCompatActivity {
    ListView listView;
    Button button;

    List<String> roomsList;

    String playerName = "";
    String roomName = "";

    FirebaseDatabase database;
    DatabaseReference roomRef;
    DatabaseReference roomsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakout_room);

        database = FirebaseDatabase.getInstance();

        //get the player name and assign his room name to the player name
        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        playerName = preferences.getString("username", "");
        roomName = playerName;

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        //all existing available rooms
        roomsList = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create room and add yourself as player1
                button.setText("CREATING ROOM");
                button.setEnabled(false);
                roomName = playerName;
                roomRef = database.getReference("rooms/" + roomName + "/player1");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //join an existing room and add yourself as player2
                roomName = roomsList.get(position);
                roomRef = database.getReference("rooms/" + roomName + "/player2");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });
        //show if room is available
        addRoomsEventListener();
    }
    private void addRoomEventListener() {
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //join the room
                button.setText("CREATE ROOM");
                button.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), FirstRound.class);
                intent.putExtra("roomName", roomName);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error
                button.setText("CREATE ROOM");
                button.setEnabled(true);
                Toast.makeText(BreakoutRoom.this, "Error!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addRoomsEventListener(){
        roomsRef = database.getReference("rooms");
        roomsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //show list of rooms
                roomsList.clear();
                Iterable<DataSnapshot> rooms = snapshot.getChildren();
                for(DataSnapshot snapshot1 : rooms){
                    roomsList.add(snapshot1.getKey());

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(BreakoutRoom.this,
                            android.R.layout.simple_list_item_1, roomsList);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error nothing
            }
        });
    }
//    Button button;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference playersRef;
//    String roomName ="";
//    int roomNum = 0;
//    int room1users = 0;
//    int room2users = 0;
//    int room3users = 0;
//    int room4users = 0;
//    List<String> draftList;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_breakout_room);
//        draftList = new ArrayList<>();
//
//    }
//    public void createRoom()
//    {
//        Intent intent = new Intent(BreakoutRoom.this, FirstRound.class);
//        intent.putExtra("roomNum", roomNum);
//        startActivity(intent);
//    }
//
//    public void setRoom(View v) {
//        switch (v.getId()) {
//            case R.id.button10:
//                roomNum = 4;
//                createRoom();
//                break;
//            case R.id.button4:
//                roomNum = 1;
//                createRoom();
//                break;
//            case R.id.button8:
//                roomNum = 2;
//                createRoom();
//                break;
//            case R.id.button9:
//                roomNum = 3;
//                createRoom();
//                break;
//            default:
//                throw new RuntimeException("Unknow button ID");
//
//
//
//        }
//    }

}