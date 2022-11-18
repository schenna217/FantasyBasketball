package com.example.fantasybasketballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        Picasso.get().load("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/203507.png")
               .into(imageView);

//        Picasso.with(this)
//                .load("https://media.geeksforgeeks.org/wp-content/cdn-uploads/logo-new-2.svg")
//                .into(imageView);
    }
}
