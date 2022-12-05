package com.example.fantasybasketballproject;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class Player implements Parcelable {
    private int rating;
    private String name;
    private String position;
    private String docID;
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

    List<String> playerList =  Arrays.asList(Mitchell, Ball, Lillard, Irving, Garland, Morant,
            Young, Doncic, Curry, Paul, Giannis, Green, Thompson, Beal, Lavine, Edwards, Brown, Booker);

    public Player(int rating, String name, String position, String docID) {
        this.rating = rating;
        this.name = name;
        this.position = position;
        this.docID = docID;
    }

    public Player(int rating, String name, String position) {
        this.rating = rating;
        this.name = name;
        this.position = position;
        this.docID = "No docID yet.";
    }

    public Player() {
        this.rating = 0;
        this.name = "";
        this.position = "";
        this.docID = "";
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
        docID = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating);
        dest.writeString(name);
        dest.writeString(position);
        dest.writeString(docID);
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

}


