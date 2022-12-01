package com.example.fantasybasketballproject;

import static java.util.Arrays.asList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    private String Young = "1629607";
    private String Doncic = "1629029";
    private String Curry = "201939";
    private String Paul = "101108";
    private String Giannis = "203507";
    private String Green = "1630224";
    private String Thompson = "202961";
    private String Beal = "203078";
    private String Lavine = "203897";
    private String Edwards = "1630162";
    private String Brown = "1627759";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    List<String> playerList =  Arrays.asList(Ball, Lillard, Irving, Garland, Morant,
    Young, Doncic, Curry, Paul, Giannis);
    List<String> draftList;
    int roomNum;
    int turnNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);

        arrangePlayers();

        draftList = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            roomNum = Integer.parseInt(value);
        }
    }
    public void updateTurn(View view)
    {
        myRef.child("room " + roomNum).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FirstRound.this, "Fail to get data.",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void draftFunction(View view) {
        int buttonNum = 0;
//        if (view.getId() == R.id.b1)
//        {
//            buttonNum = 0;
//            }
//        if (view.getId() == R.id.b2)
//        {
//
//        }
        if (!playerList.get(buttonNum).equals("Picked")) {
            TextView player = (TextView) findViewById(R.id.textView);
            draftList.add(playerList.get(roomNum));
            System.out.println(draftList);
            playerList.set(roomNum, "Picked");
            System.out.println(playerList);
            updateRoom(view);
            } else {
                Toast.makeText(getApplicationContext(), "That player Has already been picked", Toast.LENGTH_LONG).show();
            }

    }
    public void updateRoom(View view)
    {
        myRef.child("Room " + roomNum).child("Player List").setValue(playerList);

    }
    public void arrangePlayers(){
//        for(int i = 0; i < 15; i++) {
//            String imageId = "R.id.imageView";
//            int castId = Integer.parseInt(imageId);

        ImageView image = (ImageView) findViewById(R.id.imageView);
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
        List<Integer> sixtNumsList = asList(sixtNums);
        List<String> imageLinks = new ArrayList<String>();
        Collections.shuffle(imageLinks);
        List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland, Morant, Young, Doncic,
                Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown);



        for(String i: playerList){
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";


            imageLinks.add(createdLink);


        }
        List<ImageView> newImgLinks = Collections.singletonList((ImageView) imageLinks);




        for(int i = 0; i < newImgLinks.size(); i++) {
                Picasso.get().load(imageLinks.get(i)).into(image);
                Picasso.get().load(imageLinks.get(i+1)).into(image1);
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