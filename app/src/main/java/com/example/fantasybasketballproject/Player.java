package com.example.fantasybasketballproject;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Player implements Parcelable {
    private int rating;
    private String name;
    private String position;
    private String docID;

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


