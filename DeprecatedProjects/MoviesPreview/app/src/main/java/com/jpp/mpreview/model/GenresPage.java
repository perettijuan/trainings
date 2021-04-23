package com.jpp.mpreview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * An abstraction that represents the list of Genres for movies.
 * <br>
 * Created by Juan P. Peretti
 */
public class GenresPage implements Parcelable {


    @Expose
    @SerializedName("genres")
    private ArrayList<Genre> mGenres;

    private Map<Integer, Genre> mGenresPrepared;

    public GenresPage() {

    }


    /**
     * Format the data in the Genre list in order to avoid
     * traverse the entire list each time that a Genre is requested.
     */
    public void formatData() {
        mGenresPrepared = new HashMap<>();
        for (Genre genre : mGenres) {
            mGenresPrepared.put(genre.getId(), genre);
        }
    }


    /**
     * Retrieve a Genre by it's id.
     */
    public Genre getGenreById(int id) {
        if (mGenresPrepared == null) {
            formatData();
        }
        return mGenresPrepared.get(id);
    }


    private GenresPage(Parcel in) {
        in.readTypedList(mGenres, Genre.CREATOR);
    }


    public static final Creator<GenresPage> CREATOR = new Creator<GenresPage>() {
        @Override
        public GenresPage createFromParcel(Parcel in) {
            return new GenresPage(in);
        }

        @Override
        public GenresPage[] newArray(int size) {
            return new GenresPage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mGenres);
    }
}
