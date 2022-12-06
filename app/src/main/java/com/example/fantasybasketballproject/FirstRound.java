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
    private String Ball = "1630163";
    private String Lillard = "203081";
    private String Irving = "202681";
    private String Garland = "1629636";
    private String Morant = "1629630";
    private String Young = "1629027";
    private String Doncic = "1629029";
    private String Curry = "201939";
    private String Paul = "101108";
    private String Giannis = "203507";
    private String Green = "1630224";
    private String Thompson = "202691";
    private String Beal = "203078";
    private String Lavine = "203897";
    private String Edwards = "1630162";
    private String Brown = "1627759";
    private String Mitchell = "1628378";
    private String Booker = "1626164";

    ImageButton imageButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference playerName;
    DatabaseReference playersRef;

    List<String> playerList = Arrays.asList(Mitchell, Ball, Lillard, Irving, Garland, Morant,
            Young, Doncic, Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown, Booker);
    List<String> draftList;
    int roomNum;
<<<<<<< Updated upstream
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
=======
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);
        arrangePlayers();
        draftList = new ArrayList<>();


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


<<<<<<< Updated upstream
        Integer[] sixtNums = new Integer[16];
        List<Integer> sixtNumsList = asList(sixtNums);
        List<String> imageLinks = new ArrayList<String>(18);
        List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland, Morant, Young, Doncic,
                Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown);
=======
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
>>>>>>> Stashed changes

            Integer[] sixtNums = new Integer[16];
            List<Integer> sixtNumsList = asList(sixtNums);
            List<String> imageLinks = new ArrayList<String>();
            List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland, Morant, Young, Doncic,
                    Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown);


            for (String i : playerList) {
                String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
                String P2 = ".png";

                String createdLink = P1 + i + ".png";


<<<<<<< Updated upstream
            imageLinks.add(createdLink);
        }
=======
                imageLinks.add(createdLink);


            }
>>>>>>> Stashed changes
//        List<ImageView> newImgLinks = Collections.singletonList((ImageView) imageLinks);
            //Collections.shuffle(imageLinks);

<<<<<<< Updated upstream
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
=======

            for (int i = 0; i < imageLinks.size(); i++) {
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
                Picasso.get().load(imageLinks.get(15)).into(image15);
//                Picasso.get().load(imageLinks.get(16)).into(image16);

            }
>>>>>>> Stashed changes

        }


    }
