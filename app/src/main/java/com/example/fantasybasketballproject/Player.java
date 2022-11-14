package com.example.fantasybasketballproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private int rating;
    private String name;
    private String desc;
    private String docID;

    public Player(int rating, String name, String desc, String docID) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.docID = docID;
    }

    public Player(int rating, String name, String desc) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.docID = "No docID yet.";
    }

    public Player() {
        this.rating = 0;
        this.name = "";
        this.desc = "";
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
        desc = parcel.readString();
        docID = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating);
        dest.writeString(name);
        dest.writeString(desc);
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDocID() {
        return docID;
    }

    public void setdocID(String docID) {
        this.docID = docID;
    }
}
