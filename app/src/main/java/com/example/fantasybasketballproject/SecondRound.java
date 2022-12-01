package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        ImageView image = (ImageView)findViewById(R.id.imageView);
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        ImageView image2 = (ImageView)findViewById(R.id.imageView2);
        ImageView image3 = (ImageView)findViewById(R.id.imageView3);
        ImageView image4 = (ImageView)findViewById(R.id.imageView4);
        ImageView image5 = (ImageView)findViewById(R.id.imageView5);
        ImageView image6 = (ImageView)findViewById(R.id.imageView6);
        ImageView image7 = (ImageView)findViewById(R.id.imageView7);
        ImageView image8 = (ImageView)findViewById(R.id.imageView8);
        ImageView image9 = (ImageView)findViewById(R.id.imageView9);
        ImageView image10 = (ImageView)findViewById(R.id.imageView10);
        ImageView image11 = (ImageView)findViewById(R.id.imageView11);
        ImageView image12 = (ImageView)findViewById(R.id.imageView12);
        ImageView image13 = (ImageView)findViewById(R.id.imageView13);
        ImageView image14 = (ImageView)findViewById(R.id.imageView14);
        ImageView image15 = (ImageView)findViewById(R.id.imageView15);

        Integer[] sixtNums = new Integer[16];
        List<Integer> sixtNumsList = Arrays.asList(sixtNums);
        List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland);

        List<String> imageLinks = new ArrayList<String>();
        Collections.shuffle(imageLinks);

        for(String i: playerList){
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";


            imageLinks.add(createdLink);
        }


      for(int k = 0; k < sixtNumsList.size(); k++)
        for(String i: imageLinks) {
            Picasso.get().load(i).into(image);
            Picasso.get().load(i+1).into(image1);
            Picasso.get().load(i+2).into(image2);
            Picasso.get().load(i+3).into(image3);
            Picasso.get().load(i+4).into(image4);
            Picasso.get().load(i+5).into(image5);
            Picasso.get().load(i+6).into(image6);
            Picasso.get().load(i+7).into(image7);
            Picasso.get().load(i+8).into(image8);
            Picasso.get().load(i+9).into(image9);
            Picasso.get().load(i+10).into(image10);
            Picasso.get().load(i+11).into(image11);
            Picasso.get().load(i+12).into(image12);
            Picasso.get().load(i+13).into(image13);
            Picasso.get().load(i+14).into(image14);
            Picasso.get().load(i+15).into(image15);
        }




    }

    }

