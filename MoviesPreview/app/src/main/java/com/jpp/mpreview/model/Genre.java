package com.jpp.mpreview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * An abstraction that represents a Genre for movies.
 * <br>
 * Created by Juan P. Peretti
 */
public class Genre implements Parcelable {


    @Expose
    @SerializedName("id")
    private int mId;

    @Expose
    @SerializedName("name")
    private String mName;

    public Genre() {

    }

    private Genre(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
    }


    int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };
}
