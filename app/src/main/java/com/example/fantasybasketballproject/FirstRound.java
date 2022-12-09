package com.example.fantasybasketballproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FirstRound extends AppCompatActivity {
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

    ArrayList<Player> playerList = new ArrayList<Player>();
    List<String> imageLinks = new ArrayList<String>();


    String roomName = "";
    String role = "";
    String message = "";

    DatabaseReference messageRef;


    FirebaseDatabase database = FirebaseDatabase.getInstance();

    // you are using firebase not firestore.  The code is different
    DatabaseReference playerName = database.getReference();  // this is never instantiated.  This is why its crashing
    DatabaseReference turnsRef;

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public List<String> getDistinctIDs() {
        return distinctIDs;
    }

    List<String> draftList1;
    List<String> draftList2;
    List<String> players;
    int roomNum;
    String userName = "";
    String userName2 = "";
    List<ImageView> imageList;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);
        draftList1 = new ArrayList<>();
        draftList2 = new ArrayList<>();
        players = new ArrayList<>();
        for (int i = 0;i<16;i++)
        {
            players.add("-1");
        }
        imageList = new ArrayList<>();
        createLinks();
        Player Ball = new Player(85, "Lamelo Ball", "point guard", "1630163", imageLinks.get(0));
        Player Lillard = new Player(95, "Damian Lillard", "point guard", "203081", imageLinks.get(1));
        Player Irving = new Player(90, "Kyrie Irving", "point guard", "202681", imageLinks.get(2));
        Player Garland = new Player(85, "Darius Garland", "point guard", "1629636", imageLinks.get(3));
        Player Morant = new Player(85, "Ja Morant", "point guard", "1630163", imageLinks.get(4));
        Player Young = new Player(90, "Trae Young", "point guard", "1629027", imageLinks.get(5));
        Player Doncic = new Player(95, "Luka Doncic", "point guard", "1629029", imageLinks.get(6));
        Player Curry = new Player(90, "Steph Curry", "point guard", "201939", imageLinks.get(7));
        Player Thompson = new Player(85, "Klay Thompson", "shooting guard", "202691", imageLinks.get(8));
        Player Green = new Player(85, "Jalen Green", "shooting guard", "1630224", imageLinks.get(9));
        Player Beal = new Player(90, "Bradley Beal", "shooting guard", "203078", imageLinks.get(10));
        Player Lavine = new Player(90, "Zach Lavine", "shooting guard", "203897", imageLinks.get(11));
        Player Edwards = new Player(85, "Anthony Edwards", "shooting guard", "1630162", imageLinks.get(12));
        Player Brown = new Player(90, "Jaylen Brown", "shooting guard", "1627759", imageLinks.get(13));
        Player Mitchell = new Player(90, "Donovan Mitchell", "shooting guard", "1628378", imageLinks.get(14));
        Player Booker = new Player(95, "Devin Booker", "shooting guard", "1626164", imageLinks.get(15));
        playerList.add(Ball);
        playerList.add(Lillard);
        playerList.add(Irving);
        playerList.add(Garland);
        playerList.add(Morant);
        playerList.add(Young);
        playerList.add(Doncic);
        playerList.add(Curry);
        playerList.add(Thompson);
        playerList.add(Green);
        playerList.add(Beal);
        playerList.add(Lavine);
        playerList.add(Edwards);
        playerList.add(Brown);
        playerList.add(Mitchell);
        playerList.add(Booker);
        arrangePlayers();
        Intent myIntent = getIntent();
        roomNum = myIntent.getIntExtra("roomNum",0);
        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        userName = preferences.getString("username", "");

        playerName.child("room" + roomNum).child("PlayerList").setValue(players);
        playerName.child("room" + roomNum).child("users").setValue(userName);


        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            roomName = extras.getString("roomName");
            if(roomName.equals(userName)){
                role = "host";
            }
            else{
                role = "guest";
            }
        }


        invisibleListener();
        lookForPlayers();
//        addRoomEventListener();
    }
//    private void addRoomEventListener(){
//        messageRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                //message recieved
//                if(role.equals("host")){
//                    if(snapshot.getValue(String.class).contains("guest:")){
//                        .setEnabled(true);
//                        Toast.makeText(MainActivity3.this, ""+
//                                snapshot.getValue(String.class).replace("guest:",""), Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else{
//                    if(snapshot.getValue(String.class).contains("host:")){
//                        button.setEnabled(true);
//                        Toast.makeText(MainActivity3.this, ""+
//                                snapshot.getValue(String.class).replace("host:",""), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                messageRef.setValue(message);
//            }
//        });
//    }

    public void updateRoom(View view) {

        ImageView image1 = findViewById(view.getId());
//        image1.setVisibility(View.INVISIBLE);
        String str = image1.getResources().getResourceEntryName(view.getId());
        str = str.replace("imageView", "");
//        Log.d(TAG,str);
        players.set(Integer.parseInt(str)-1,userName);
//        Log.d(TAG,players.toString());
        playerName.setValue(players);
        finishRound();
//        Log.d("1",draftList1.toString());
//        Log.d("2",draftList2.toString());
//        playerName = database.getReference().child("room" + roomNum);
//        draftList.add(playerList.get(Integer.parseInt(str)).getName());
//        playerName.child(userName + "s List").setValue(draftList);
//        Log.d(TAG,view.getId());


    }

    public void finishRound()
    {
        playerName = database.getReference("room"+roomNum).child("PlayerList");
        playerName.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    draftList1.clear();
                    draftList2.clear();
                    for(DataSnapshot dss: snapshot.getChildren())
                    {
                        String index = dss.getKey();
                        String owner = dss.getValue(String.class);
                        if(owner.equals(userName))
                        {
                            draftList1.add(playerList.get(Integer.parseInt(index)).getName());
                        }
                        else if(owner.equals(userName2))
                        {
                            draftList2.add(playerList.get(Integer.parseInt(index)).getName());
                        }
//                        if(draftList1.size() == 2 && draftList2.size()== 2)
//                        {
                            Intent intent = new Intent(FirstRound.this, SecondRound.class);
                            intent.putStringArrayListExtra("draftList1", (ArrayList<String>) draftList1);
                            intent.putStringArrayListExtra("draftList2", (ArrayList<String>) draftList2);
                            startActivity(intent);
//                        }
                    }
                    Log.d(TAG,draftList1.toString());
                    Log.d(TAG,draftList2.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error nothing
            }
        });
    }

    private void lookForPlayers(){
        turnsRef = database.getReference("room"+roomNum).child("users");
        turnsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    for(DataSnapshot dss: snapshot.getChildren())
                    {
                        String user = dss.getValue(String.class);
                        if(!user.equals(userName))
                        {
                            userName2 = user;
                            break;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addPlayersEventListener(){
        playerName = database.getReference("room"+roomNum).child("PlayerList");
        playerName.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    players.clear();
                    for(DataSnapshot dss: snapshot.getChildren())
                    {
                        String playerValue = dss.getValue(String.class);
                        players.add(playerValue);
//                        Log.d("from firebase",players.toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error nothing
            }
        });
    }


    private void invisibleListener(){
        playerName = database.getReference("room"+roomNum).child("PlayerList");
        playerName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> playerName = snapshot.getChildren();
                for(DataSnapshot snapshot1 : playerName){
                    String index = snapshot1.getKey();
//                    Log.d(TAG,index);
                    String owner = snapshot1.getValue(String.class);
                    if(!owner.equals("-1"))
                    {
                        //String imgView = "R.id.imageView" + index;
                        ImageView image1 = imageList.get(Integer.parseInt(index));
                        image1.setVisibility(View.INVISIBLE);
                    }
                    addPlayersEventListener();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    public void arrangePlayers() {
//        ImageView image1 = findViewById(R.id.imageView1);
//        ImageView image2 = findViewById(R.id.imageView2);
//        ImageView image3 = findViewById(R.id.imageView3);
//        ImageView image4 = findViewById(R.id.imageView4);
//        ImageView image5 = findViewById(R.id.imageView5);
//        ImageView image6 = findViewById(R.id.imageView6);
//        ImageView image7 = findViewById(R.id.imageView7);
//        ImageView image8 = findViewById(R.id.imageView8);
//        ImageView image9 = findViewById(R.id.imageView9);
//        ImageView image10 = findViewById(R.id.imageView10);
//        ImageView image11 = findViewById(R.id.imageView11);
//        ImageView image12 = findViewById(R.id.imageView12);
//        ImageView image13 = findViewById(R.id.imageView13);
//        ImageView image14 = findViewById(R.id.imageView14);
//        ImageView image15 = findViewById(R.id.imageView15);
//        ImageView image16 = findViewById(R.id.imageView16);

//        String getFromFirebase = playerName.child("room" + roomNum).child("PlayerList").get();

        ImageView image1 = findViewById(R.id.imageView1);
        imageList.add(findViewById(R.id.imageView1));
        imageList.add(findViewById(R.id.imageView2));

        imageList.add(findViewById(R.id.imageView3));

        imageList.add(findViewById(R.id.imageView4));

        imageList.add(findViewById(R.id.imageView5));

        imageList.add(findViewById(R.id.imageView6));

        imageList.add(findViewById(R.id.imageView7));

        imageList.add(findViewById(R.id.imageView8));

        imageList.add(findViewById(R.id.imageView9));

        imageList.add(findViewById(R.id.imageView10));

        imageList.add(findViewById(R.id.imageView11));
        imageList.add(findViewById(R.id.imageView12));
        imageList.add(findViewById(R.id.imageView13));
        imageList.add(findViewById(R.id.imageView14));
        imageList.add(findViewById(R.id.imageView15));
        imageList.add(findViewById(R.id.imageView16));


//        ImageView image2 = findViewById(R.id.imageView2);
//        ImageView image3 = findViewById(R.id.imageView3);
//        ImageView image4 = findViewById(R.id.imageView4);
//        ImageView image5 = findViewById(R.id.imageView5);
//        ImageView image6 = findViewById(R.id.imageView6);
//        ImageView image7 = findViewById(R.id.imageView7);
//        ImageView image8 = findViewById(R.id.imageView8);
//        ImageView image9 = findViewById(R.id.imageView9);
//        ImageView image10 = findViewById(R.id.imageView10);
//        ImageView image11 = findViewById(R.id.imageView11);
//        ImageView image12 = findViewById(R.id.imageView12);
//        ImageView image13 = findViewById(R.id.imageView13);
//        ImageView image14 = findViewById(R.id.imageView14);
//        ImageView image15 = findViewById(R.id.imageView15);
//        ImageView image16 = findViewById(R.id.imageView16);

            Picasso.get().load(imageLinks.get(0)).into(imageList.get(0));
            Picasso.get().load(imageLinks.get(1)).into(imageList.get(1));
            Picasso.get().load(imageLinks.get(2)).into(imageList.get(2));
            Picasso.get().load(imageLinks.get(3)).into(imageList.get(3));
            Picasso.get().load(imageLinks.get(4)).into(imageList.get(4));
            Picasso.get().load(imageLinks.get(5)).into(imageList.get(5));
            Picasso.get().load(imageLinks.get(6)).into(imageList.get(6));
            Picasso.get().load(imageLinks.get(7)).into(imageList.get(7));
            Picasso.get().load(imageLinks.get(8)).into(imageList.get(8));
            Picasso.get().load(imageLinks.get(9)).into(imageList.get(9));
            Picasso.get().load(imageLinks.get(10)).into(imageList.get(10));
            Picasso.get().load(imageLinks.get(11)).into(imageList.get(11));
            Picasso.get().load(imageLinks.get(12)).into(imageList.get(12));
            Picasso.get().load(imageLinks.get(13)).into(imageList.get(13));
            Picasso.get().load(imageLinks.get(14)).into(imageList.get(14));
            Picasso.get().load(imageLinks.get(15)).into(imageList.get(15));


    }
    public void createLinks(){
        for (String i : distinctIDs) {
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";

            imageLinks.add(createdLink);
        }

    }

}






