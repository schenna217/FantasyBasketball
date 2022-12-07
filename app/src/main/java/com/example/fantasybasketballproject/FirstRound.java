package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class FirstRound extends AppCompatActivity {
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
    private String Anthony = "1630162";
    private String Jaylen = "1627759";
    private String Donovan = "1628378";
    private String Devin = "1626164";


    public List<String> distinctIDs = Arrays.asList(Lamelo, Damian, Kyrie, Darius, Ja, Trae, Luka, Steph, Chris
            , Giannis, Jalen, Klay, Bradley, Zach, Anthony, Jaylen, Donovan, Devin);

    ArrayList<Player> playerList = new ArrayList<Player>();
    List<String> imageLinks = new ArrayList<String>(18);



    // add data below


    // get method

    ImageButton imageButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference playerName;
    DatabaseReference playersRef;

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public List<String> getDistinctIDs() {
        return distinctIDs;
    }

    List<String> draftList;
    int roomNum;
    int turnNum;

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10;
    ImageView imageView11, imageView12, imageView13, imageView14, imageView15, imageView16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);
        draftList = new ArrayList<>();
        createLinks();
        Player Ball = new Player(85, "Lamelo Ball", "point guard", "1630163", imageLinks.get(0));
        Player Lillard = new Player(95, "Damian Lillard", "point guard", "203081", imageLinks.get(1));
        Player Irving = new Player(90, "Kyrie Irving", "point guard", "202681", imageLinks.get(2));
        Player Garland = new Player(85, "Darius Garland", "point guard", "1629636", imageLinks.get(3));
        Player Morant = new Player(85, "Ja Morant", "point guard", "1630163", imageLinks.get(4));
        Player Young = new Player(90, "Trae Young", "point guard", "1629027", imageLinks.get(5));
        Player Doncic = new Player(95, "Luka Doncic", "point guard", "1629029", imageLinks.get(6));
        Player Curry = new Player(90, "Steph Curry", "point guard", "201939", imageLinks.get(7));
        Player Paul = new Player(85, "Chris Paul", "point guard", "101108", imageLinks.get(8));
        Player Thompson = new Player(85, "Jalen Green", "shooting guard", "202691", imageLinks.get(9));
        Player Green = new Player(85, "Jalen Green", "shooting guard", "1630224", imageLinks.get(10));
        Player Akoumpo = new Player(95, "Giannis Antetokounmpo", "power forward", "203507", imageLinks.get(11));
        Player Beal = new Player(90, "Bradley Beal", "shooting guard", "203078", imageLinks.get(12));
        Player Lavine = new Player(90, "Zach Lavine", "shooting guard", "203897", imageLinks.get(13));
        Player Edwards = new Player(85, "Anthony Edwards", "shooting guard", "1630162", imageLinks.get(14));
        Player Brown = new Player(90, "Jaylen Brown", "shooting guard", "1627759", imageLinks.get(15));
        Player Mitchell = new Player(90, "Donovan Mitchell", "shooting guard", "1628378", imageLinks.get(16));
        Player Booker = new Player(95, "Devin Booker", "shooting guard", "1626164", imageLinks.get(17));
        arrangePlayers();
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                imageButton = findViewById(R.id.imageButton);
                break;
            case R.id.imageButton2:
                imageButton = findViewById(R.id.imageButton2);
                break;
            case R.id.imageButton3:
                imageButton = findViewById(R.id.imageButton3);
                break;
        }
        Log.d("Button Num", "button");
    }
        public void arrangePlayers() {

            ImageView image1 = findViewById(R.id.imageView1);
            ImageView image2 = findViewById(R.id.imageView2);
            ImageView image3 = findViewById(R.id.imageView3);
            ImageView image4 = findViewById(R.id.imageView4);
            ImageView image5 = findViewById(R.id.imageView5);
            ImageView image6 = findViewById(R.id.imageView6);
            ImageView image7 = findViewById(R.id.imageView7);
            ImageView image8 = findViewById(R.id.imageView8);
            ImageView image9 = findViewById(R.id.imageView9);
            ImageView image10 = findViewById(R.id.imageView10);
            ImageView image11 = findViewById(R.id.imageView11);
            ImageView image12 = findViewById(R.id.imageView12);
            ImageView image13 = findViewById(R.id.imageView13);
            ImageView image14 = findViewById(R.id.imageView14);
            ImageView image15 = findViewById(R.id.imageView15);
            ImageView image16 = findViewById(R.id.imageView16);



            Collections.shuffle(imageLinks);


            Log.i("KOVOUR", imageLinks.toString());
            for(Player i : playerList) {

                Picasso.get().load(i.getImageLink()).into(image1);
                Picasso.get().load(imageLinks.get(2)).into(image2);
                Picasso.get().load(imageLinks.get(3)).into(image3);
                Picasso.get().load(imageLinks.get(4)).into(image4);
                Picasso.get().load(imageLinks.get(5)).into(image5);
                Picasso.get().load(imageLinks.get(6)).into(image6);
                Picasso.get().load(imageLinks.get(7)).into(image7);
                Picasso.get().load(imageLinks.get(8)).into(image8);
                Picasso.get().load(imageLinks.get(9)).into(image9);
                Picasso.get().load(imageLinks.get(10)).into(image10);
                Picasso.get().load(imageLinks.get(11)).into(image11);
                Picasso.get().load(imageLinks.get(12)).into(image12);
                Picasso.get().load(imageLinks.get(13)).into(image13);
                Picasso.get().load(imageLinks.get(14)).into(image14);
                Picasso.get().load(imageLinks.get(15)).into(image15);
                Picasso.get().load(imageLinks.get(16)).into(image16);

            }



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






