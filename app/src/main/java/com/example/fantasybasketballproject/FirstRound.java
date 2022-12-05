package com.example.fantasybasketballproject;

import static java.util.Arrays.asList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
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

    GridView gridView;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference playerName;
    DatabaseReference playersRef;

    List<String> playerList =  Arrays.asList(Mitchell, Ball, Lillard, Irving, Garland, Morant,
    Young, Doncic, Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown, Booker);
    List<String> draftList;
    int roomNum;
    int turnNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);
        arrangePlayers();
        gridView = findViewById(R.id.gridLayout)


        draftList = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            roomNum = Integer.parseInt(value);
        }


    }
    public void updateTurn()
    {
        myRef.child("room " + roomNum).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //show list of rooms
                playerList.clear();
                Iterable<DataSnapshot> players = snapshot.getChildren();
                for(DataSnapshot snapshot1 : players){
                    playerList.add(snapshot1.getKey());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(FirstRound.this,
                            android.R.layout.simple_list_item_1, playerList);
                    listView.setAdapter(adapter);
                }
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
//           }
//        if (view.getId() == R.id.b2)
//       {
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

        Integer[] sixtNums = new Integer[16];
        List<Integer> sixtNumsList = asList(sixtNums);
        List<String> imageLinks = new ArrayList<String>();
        List<String> playerList = Arrays.asList(Ball, Lillard, Irving, Garland, Morant, Young, Doncic,
                Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown);



        for(String i: playerList){
            String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
            String P2 = ".png";

            String createdLink = P1 + i + ".png";


            imageLinks.add(createdLink);


        }
//        List<ImageView> newImgLinks = Collections.singletonList((ImageView) imageLinks);
        Collections.shuffle(imageLinks);



       // for(int i = 0; i < imageLinks.size(); i++) {
                Picasso.get().load(imageLinks.get(1)).into(image1);
                // set another attribute of Player class to save the
        // imageView id from first_round.xml (image1, image2, etc.)
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

           // }

    }





}