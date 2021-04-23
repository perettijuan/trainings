package com.jpp.mpreview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jperett on 4/11/15.
 */
public class MoviePage implements Parcelable {


    @Expose
    @SerializedName("results")
    private ArrayList<Movie> mResults;


    public MoviePage() {

    }

    private MoviePage(Parcel in) {
        in.readTypedList(mResults, Movie.CREATOR);
    }


    public List<Movie> getMovies() {
        return mResults;
    }

    /**
     * Sorts the list of movies using the given comparator.
     *
     * @param comparator - the comparator to use in the sorting process.
     */
    public void sortWith(@NonNull Comparator<Movie> comparator) {
        Collections.sort(mResults, comparator);
    }

    public static final Creator<MoviePage> CREATOR = new Creator<MoviePage>() {
        @Override
        public MoviePage createFromParcel(Parcel in) {
            return new MoviePage(in);
        }

        @Override
        public MoviePage[] newArray(int size) {
            return new MoviePage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mResults);
    }
}
