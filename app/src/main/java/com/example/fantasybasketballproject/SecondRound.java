package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SecondRound extends AppCompatActivity {
    private String Ball = "1630163";
    private String Lillard = "203081";
    private String Irving = "202681";
    private String Garland = "1629636";
    private String Morant = "1629630";
    private String Young = "1629607";
    private String Doncic = "1629029";
    private String Curry = "201939";
    private String Paul = "101108";
    private String Giannis = "203507";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_round);
        List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland);

        List<String> imageLinks = new ArrayList<String>();

        for(String i: playerList){
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";


            imageLinks.add(createdLink);
        }


      for(int k = 1; k < 17; k++)
        for(String i: imageLinks) {
            Picasso.get().load(i).into(imageView + "k" );
        }



    }
    public void arrangePlayers(){
        Integer[] sixtNums = new Integer[16];
        List<Integer> sixtNumsList = Arrays.asList(sixtNums);
        Collections.shuffle(sixtNumsList);
    }

}