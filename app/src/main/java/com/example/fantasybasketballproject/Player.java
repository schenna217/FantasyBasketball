package com.example.fantasybasketballproject;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements Parcelable {
    private int rating;
    private String name;
    private String position;
    private String imageViewID;
    private String imageID;
    private String Lamelo = "1630163";
    private String Damian = "203081";
    private String Kyrie = "202681";
    private String Darius = "1629636";
    private String Ja = "1629630";
    private String Trae = "1629027";
    private String Luka = "1629029";
    private String Steph = "201939";
    private String Chris = "101108";
    private String Giannis = "203507";
    private String Jalen = "1630224";
    private String Klay = "202691";
    private String Bradley = "203078";
    private String Zach = "203897";
    private String Anthony = "1630162";
    private String Jaylen = "1627759";
    private String Donovan = "1628378";
    private String Devin = "1626164";

    private List<String> playerList =  Arrays.asList(Donovan, Lamelo, Damian, Kyrie, Darius, Ja, Steph, Trae, Luka
    , Chris, Giannis, Jalen, Klay, Bradley, Zach, Anthony, Jaylen, Devin);

    Player Ball = new Player(85, "Lamelo Ball", "point guard", "1630163");
    Player Lillard = new Player(95, "Damian Lillard", "point guard", "203081");
    Player Irving = new Player(90, "Kyrie Irving", "point guard", "202681");
    Player Garland = new Player(85, "Darius Garland", "point guard", "1629636");
    Player Morant = new Player(85, "Ja Morant", "point guard", "1630163");
    Player Young = new Player(90, "Trae Young", "point guard", "1629027");
    Player Doncic = new Player(95, "Luka Doncic", "point guard", "1629029");
    Player Curry = new Player(90, "Steph Curry", "point guard", "201939");
    Player Paul = new Player(85, "Chris Paul", "point guard", "101108");
    Player Thompson = new Player(85, "Jalen Green", "shooting guard", "202691");
    Player Green = new Player(85, "Jalen Green", "shooting guard", "1630224");
    Player Akoumpo = new Player(95, "Giannis Antetokounmpo", "power forward", "203507");
    Player Beal = new Player(90, "Bradley Beal", "shooting guard", "203078");
    Player Lavine = new Player(90, "Zach Lavine", "shooting guard", "203897");
    Player Edwards = new Player(85, "Anthony Edwards", "shooting guard", "1630162");
    Player Brown = new Player(90, "Jaylen Brown", "shooting guard", "1627759");
    Player Mitchell = new Player(90, "Donovan Mitchell", "shooting guard", "1628378");
    Player Booker = new Player(90, "Devin Booker", "shooting guard", "1626164");





    public Player(int rating, String name, String position, String imageID) {
        this.rating = rating;
        this.name = name;
        this.position = position;
        this.imageID = imageID;
        this.imageViewID = "";
    }




    public String toString() {
        return this.name;
    }

    // this code is needed for the Player class to work with Parcelable
    public static final Parcelable.Creator<Player> CREATOR = new
            Parcelable.Creator<Player>() {

                @Override
                public Player createFromParcel(Parcel parcel) {
//                    Player dataToSend = new Player();
//                    Intent i = new Intent(this, FirstRound.class);
//                    i.putExtra("myDataKey", dataToSend); // using the (String name, Parcelable value) overload!
//                    startActivity(i);
                    return new Player(parcel);
                }

                @Override
                public Player[] newArray(int size) {
                    return new Player[0];
                }
            };

    public Player(Parcel parcel) {
        rating = parcel.readInt();
        name = parcel.readString();
        position = parcel.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating);
        dest.writeString(name);
        dest.writeString(position);
    }


 

    @Override
    public int describeContents() {
        return 0;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public String getDocID() {
        return docID;
    }

    public void setdocID(String docID) {
        this.docID = docID;
    }

    public List<String> getPlayerList(){
        return playerList;
    }

}


