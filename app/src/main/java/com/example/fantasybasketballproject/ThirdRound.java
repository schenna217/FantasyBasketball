package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdRound extends AppCompatActivity {

    private String Joel = "203954";
    private String Rudy = "1627783";
    private String Nikola = "1631094";
    private String Al = "203076";
    private String DeAndre = "1630596";
    private String Jarrett = "1626157";
    private String Chet = "1629627";
    private String Andre = "203507";


    List<String> distinctIDs = Arrays.asList(Joel, Rudy, Nikola, Al, DeAndre,Jarrett,
            Chet, Andre);
    List<String> imageLinks = new ArrayList<String>();
    ArrayList<Player> playerList = new ArrayList<Player>();
    Player Embiid = new Player(95, "Joel Embiid", "center", "203954", "");
    Player Gobert = new Player(90, "Rudy Gobert", "center", "203497", "");
    Player Jokic = new Player(95, "Nikola Jokic", "center", "203999", "");
    Player Horford = new Player(85, "Al Horford", "center", "201143", "");
    Player Ayton = new Player(85, "Deandre Ayton", "center", "1629028", "");
    Player Allen = new Player(85, "Jarrett Allen", "center", "1628386", "");
    Player Holmgren = new Player(80, "Chet Holmgren", "center", "1631096", "");
    Player Drummond = new Player(80, "Andre Drummond", "center", "203083", "");

    Player Peter = new Player(95, "Peter Griffin", "center", R.drawable.petergriffin);
    Player Baratheon = new Player(90, "Baratheon", "center", R.drawable.baratheon);
    Player Default = new Player(90, "Default Skin", "center", R.drawable.defaultskin);
    Player Moe = new Player(85, "Moe Szyslak", "center", R.drawable.moesimpsons);
    Player Pitbull = new Player(80, "Pitbull", "center", R.drawable.pitbull);
    Player Shrek = new Player(80, "Shrek", "center", R.drawable.shrek);
    Player Heisenburg = new Player(85, "Heisenburg", "center", R.drawable.walterwhite);
    Player Waluigi = new Player(90, "Waluigi", "center", R.drawable.waluigi);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_round);
        playerList.add(Embiid);
        playerList.add(Gobert);
        playerList.add(Jokic);
        playerList.add(Horford);
        playerList.add(Ayton);
        playerList.add(Allen);
        playerList.add(Holmgren);
        playerList.add(Drummond);
        playerList.add(Peter);
        playerList.add(Baratheon);
        playerList.add(Default);
        playerList.add(Moe);
        playerList.add(Pitbull);
        playerList.add(Shrek);
        playerList.add(Heisenburg);
        playerList.add(Waluigi);
    }
    public void arrangePlayers() {

        ImageView image1 = findViewById(R.id.imageView33);
        ImageView image2 = findViewById(R.id.imageView34);
        ImageView image3 = findViewById(R.id.imageView35);
        ImageView image4 = findViewById(R.id.imageView36);
        ImageView image5 = findViewById(R.id.imageView37);
        ImageView image6 = findViewById(R.id.imageView38);
        ImageView image7 = findViewById(R.id.imageView39);
        ImageView image8 = findViewById(R.id.imageView40);
        ImageView image9 = (ImageView)findViewById(R.id.imageView41);
        image9.setImageDrawable(getResources().getDrawable(R.drawable.baratheon));
        ImageView image10 = (ImageView)findViewById(R.id.imageView42);
        image10.setImageDrawable(getResources().getDrawable(R.drawable.defaultskin));
        ImageView image11 = (ImageView)findViewById(R.id.imageView43);
        image11.setImageDrawable(getResources().getDrawable(R.drawable.petergriffin));
        ImageView image12 = (ImageView)findViewById(R.id.imageView44);
        image12.setImageDrawable(getResources().getDrawable(R.drawable.pitbull));
        ImageView image13 = (ImageView)findViewById(R.id.imageView45);
        image13.setImageDrawable(getResources().getDrawable(R.drawable.moesimpsons));
        ImageView image14 = (ImageView)findViewById(R.id.imageView46);
        image14.setImageDrawable(getResources().getDrawable(R.drawable.shrek));
        ImageView image15 = (ImageView)findViewById(R.id.imageView47);
        image15.setImageDrawable(getResources().getDrawable(R.drawable.walterwhite));
        ImageView image16 = (ImageView)findViewById(R.id.imageView48);
        image16.setImageDrawable(getResources().getDrawable(R.drawable.waluigi));



        // Collections.shuffle(imageLinks);
//        Log.i("KOVOUR", imageLinks.toString());
        Picasso.get().load(imageLinks.get(0)).into(image1);
        Picasso.get().load(imageLinks.get(1)).into(image2);
        Picasso.get().load(imageLinks.get(2)).into(image3);
        Picasso.get().load(imageLinks.get(3)).into(image4);
        Picasso.get().load(imageLinks.get(4)).into(image5);
        Picasso.get().load(imageLinks.get(5)).into(image6);
        Picasso.get().load(imageLinks.get(6)).into(image7);
        Picasso.get().load(imageLinks.get(7)).into(image8);


    }
    public void createLinks() {
        for (String i : distinctIDs) {
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";

            imageLinks.add(createdLink);
        }

    }
}