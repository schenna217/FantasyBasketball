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

    ArrayList<Player> playerList = new ArrayList<Player>();
    Player Green = new Player(85, "Draymond Green", "power forward", "203110", "");
    Player Siakam = new Player(90, "Pascal Siakam", "power forward", "1627783", "");
    Player Banchero = new Player(85, "Paolo Banchero", "power forward", "1631094", "");
    Player Davis = new Player(90, "Anthony Davis", "power forward", "203076", "");
    Player Mobley = new Player(85, "Evan Mobley", "power forward", "1630596", "");
    Player Towns = new Player(90, "Karl-Anthony Towns", "power forward", "1626157", "");
    Player Williamson = new Player(90, "Zion Williamson", "power forward", "1629627", "");
    Player Akoumpo = new Player(95, "Giannis Antetokounmpo", "power forward", "203507", "");
    Player Leonard = new Player(90, "Kawhi Leonard", "small forward", "202695", "");
    Player James = new Player(95, "Lebron James", "small forward", "2544", "");
    Player Tatum = new Player(95, "Jayson Tatum", "small forward", "1628639", "");
    Player Derozan = new Player(90, "Demar Derozan", "small forward", "201942", "");
    Player Middleton = new Player(90, "Khris Middleton", "small forward", "203114", "");
    Player Ingram = new Player(85, "Brandon Ingram", "small forward", "1627742", "");
    Player Bridges = new Player(85, "Mikal Bridges", "small forward", "1628969", "");
    Player Wiggins = new Player(85, "Andrew Wiggins", "small forward", "203952", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_round);
        playerList.add(Green);
        playerList.add(Siakam);
        playerList.add(Banchero);
        playerList.add(Davis);
        playerList.add(Mobley);
        playerList.add(Towns);
        playerList.add(Williamson);
        playerList.add(Akoumpo);
        playerList.add(Leonard);
        playerList.add(James);
        playerList.add(Tatum);
        playerList.add(Derozan);
        playerList.add(Middleton);
        playerList.add(Ingram);
        playerList.add(Bridges);
        playerList.add(Wiggins);
    }


    }

