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
    private String Draymond = "203110";
    private String Pascal = "1627783";
    private String Paolo = "1631094";
    private String Anthony2 = "203076";
    private String Evan = "1630596";
    private String Karl = "1626157";
    private String Zion = "1629627";
    private String Giannis = "203507";
    private String Kawhi = "202695";
    private String LeBron = "2544";
    private String Jayson = "1628639";
    private String Demar = "201942";
    private String Khris = "203114";
    private String Brandon = "1627742";
    private String Mikal = "1628969";
    private String Andrew = "203952";
    public List<String> distinctIDs = Arrays.asList(Draymond, Pascal, Paolo, Anthony2, Evan, Karl, Zion, Giannis, Kawhi, LeBron,
            Jayson, Demar, Khris, Brandon, Mikal, Andrew);

    ArrayList<Player> playerList = new ArrayList<Player>();
    List<String> imageLinks = new ArrayList<String>();
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
        createLinks();
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
        arrangePlayers();
    }
    public void arrangePlayers() {

        ImageView image1 = findViewById(R.id.imageView17);
        ImageView image2 = findViewById(R.id.imageView18);
        ImageView image3 = findViewById(R.id.imageView19);
        ImageView image4 = findViewById(R.id.imageView20);
        ImageView image5 = findViewById(R.id.imageView21);
        ImageView image6 = findViewById(R.id.imageView22);
        ImageView image7 = findViewById(R.id.imageView23);
        ImageView image8 = findViewById(R.id.imageView24);
        ImageView image9 = findViewById(R.id.imageView25);
        ImageView image10 = findViewById(R.id.imageView26);
        ImageView image11 = findViewById(R.id.imageView27);
        ImageView image12 = findViewById(R.id.imageView28);
        ImageView image13 = findViewById(R.id.imageView29);
        ImageView image14 = findViewById(R.id.imageView30);
        ImageView image15 = findViewById(R.id.imageView31);
        ImageView image16 = findViewById(R.id.imageView32);

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
        Picasso.get().load(imageLinks.get(8)).into(image9);
        Picasso.get().load(imageLinks.get(9)).into(image10);
        Picasso.get().load(imageLinks.get(10)).into(image11);
        Picasso.get().load(imageLinks.get(11)).into(image12);
        Picasso.get().load(imageLinks.get(12)).into(image13);
        Picasso.get().load(imageLinks.get(13)).into(image14);
        Picasso.get().load(imageLinks.get(14)).into(image15);
        Picasso.get().load(imageLinks.get(15)).into(image16);

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

