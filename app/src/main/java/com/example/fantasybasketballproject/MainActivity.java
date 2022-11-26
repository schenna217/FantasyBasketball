package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import kotlin.jvm.internal.CollectionToArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

//<<<<<<< Updated upstream
        Picasso.get().load("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/203507.png")
               .into(imageView);
//=======
//        Picasso.get().load("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629630.png")
//                .into(imageView);
//>>>>>>> Stashed changes

//        Picasso.with(this)
//                .load("https://media.geeksforgeeks.org/wp-content/cdn-uploads/logo-new-2.svg")
//                .into(imageView);
    }

    String lebron = "123456";
    String curry = "234567";
    String giannis = "345678";


    ArrayList<String> playerNumbers = new ArrayList<String>();

    public String getLebron() {
        return lebron;
    }

    public void setLebron(String lebron) {
        this.lebron = lebron;
    }

    public String getCurry() {
        return curry;
    }

    public void setCurry(String curry) {
        this.curry = curry;
    }

    public String getGiannis() {
        return giannis;
    }

    public void setGiannis(String giannis) {
        this.giannis = giannis;
    }

    public ArrayList<String> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(ArrayList<String> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }


}
