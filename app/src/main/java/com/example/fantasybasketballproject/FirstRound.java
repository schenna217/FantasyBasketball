package com.example.fantasybasketballproject;

import static java.util.Arrays.asList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

public class FirstRound extends AppCompatActivity {
    
    ArrayList<String> playerssList = new ArrayList<String>(); // Create Playerlist
    playerssList.add(Ball);
    // add data below
    playerssList
    Player Ball = new Player(85, "Lamelo Ball", "point guard", "1630163", imageLinks.get(0));
    Player Lillard = new Player(95, "Damian Lillard", "point guard", "203081");
    Player Irving = new Player(90, "Kyrie Irving", "point guard", "202681");
    Player Garland = new Player(85, "Darius Garland", "point guard", "1629636");
    Player Morant = new Player(85, "Ja Morant", "point guard", "1630163");
    Player Young = new Player(90, "Trae Young", "point guard", "1629027");
    Player Doncic = new Player(95, "Luka Doncic", "point guard", "1629029");
    Player Curry = new Player(90, "Steph Curry", "point guard", "201939");
    Player Paul = new Player(85, "Chris Paul", "point guard", "101108");
    Player Thompson = new Player(85, "Jalen Green", "shooting guard", "202691");
    Player Green = new Player(85, "Jalen Green", "shooting guard", "1630224");
    Player Akoumpo = new Player(95, "Giannis Antetokounmpo", "power forward", "203507");
    Player Beal = new Player(90, "Bradley Beal", "shooting guard", "203078");
    Player Lavine = new Player(90, "Zach Lavine", "shooting guard", "203897");
    Player Edwards = new Player(85, "Anthony Edwards", "shooting guard", "1630162");
    Player Brown = new Player(90, "Jaylen Brown", "shooting guard", "1627759");
    Player Mitchell = new Player(90, "Donovan Mitchell", "shooting guard", "1628378");
    Player Booker = new Player(90, "Devin Booker", "shooting guard", "1626164");
    // get method

    ImageButton imageButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference playerName;
    DatabaseReference playersRef;

    List<String> imageLinks = new ArrayList<String>(18);
    List<String> playerList = Arrays.asList(Mitchell, Ball, Lillard, Irving, Garland, Morant,
            Young, Doncic, Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown, Booker);
    List<String> draftList;
    int roomNum;
    int turnNum;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);
        arrangePlayers();
        draftList = new ArrayList<>();


    }
    public ArrayList<Player> getPlayerArrayList() {
        return playerssList;
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

    public



        List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland, Morant, Young, Doncic,
                Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown);

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



           createLinks();

            //Collections.shuffle(imageLinks);


            Log.i("KOVOUR", imageLinks.toString());

            Picasso.get().load(imageLinks.get(1)).into(image1);
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
            Log.i("KOVOUR", "loaded14");
            Picasso.get().load(imageLinks.get(15)).into(image15);
            Log.i("KOVOUR", "loaded15");
            Picasso.get().load(imageLinks.get(16)).into(image16);

            }
            public void createLinks(){
                for (String i : playerList) {
                    String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
                    String P2 = ".png";

                    String createdLink = P1 + i + ".png";

                    imageLinks.add(createdLink);
            }




    }






            }






