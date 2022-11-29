package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import kotlin.jvm.internal.CollectionToArray;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ImageView imageView = findViewById(R.id.imageView);
//
//        Picasso.get().load("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/203507.png")
//                .into(imageView);
//    }
//
//    String lebron = "123456";
//    String curry = "234567";
//    String giannis = "345678";
//
//    ArrayList<String> playerNumbers = new ArrayList<String>();
//
//    ArrayList<Integer> test = new ArrayList<>();
//
//    String list[] = {"one", "two"};
    ////////////////////////////////////////

    private int A = 1630163;
    private int Lillard = 203081;
    private int Irving = 202681;
    private int Garland = 1629636;
    private int Morant = 1629630;
    private int Young = 1629607;
    private int Doncic = 1629029;
    private int Curry = 201939;
    private int Paul = 101108;
    private int Giannis = 203507;

    List<String> playerList =  Arrays.asList("Beal","Booker", "Murray");
    List<String> draftList;

    List<Integer> test = Arrays.asList(A, Lillard, Irving);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_round);

        ArrayList<String> playerList = new ArrayList<String>();
        String P1 = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/";
        String P2 = ".png";
        draftList = new ArrayList<>();

    }
}
