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

    public List<String> getPlayerList{
        return playerList;
    }

}


