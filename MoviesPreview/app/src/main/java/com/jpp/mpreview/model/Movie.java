package com.jpp.mpreview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * An abstraction that represents a Movie.
 * <br>
 * Created by Juan P. Peretti
 */
public class Movie implements Parcelable {

    //Thumbnail, name, category (drama, comedy, etc), popularity (score), and year

    private static final String GENRE_SEPARATOR = "|";

    @Expose
    @SerializedName("genre_ids")
    private int[] mGenreIds;

    @Expose
    @SerializedName("id")
    private long mId;

    @Expose
    @SerializedName("title")
    private String mTitle;

    @Expose
    @SerializedName("popularity")
    private float mPopularity;

    @Expose
    @SerializedName("release_date")
    private String mReleaseDate;

    @Expose
    @SerializedName("poster_path")
    private String mPosterPath;

    @Expose
    @SerializedName("overview")
    private String mOverview;

    @Expose
    @SerializedName("vote_average")
    private float mVoteAverage;

    @Expose
    @SerializedName("vote_count")
    private long mVoteCount;

    private String mGenres;

    public Movie() {

    }

    private Movie(Parcel in) {
        mGenreIds = in.createIntArray();
        mId = in.readLong();
        mTitle = in.readString();
        mPopularity = in.readFloat();
        mReleaseDate = in.readString();
        mPosterPath = in.readString();
        mOverview = in.readString();
        mVoteAverage = in.readFloat();
        mVoteCount = in.readLong();
        mGenres = in.readString();
    }


    public int[] getGenreIds() {
        return mGenreIds;
    }

    public long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public float getPopularity() {
        return mPopularity;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public long getVoteCount() {
        return mVoteCount;
    }

    public void setGenresToShow(GenresPage genres) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mGenreIds.length; i++) {
            int genreId = mGenreIds[i];
            Genre genre = genres.getGenreById(genreId);
            sb.append(genre.getName());
            if (i != mGenreIds.length) {
                sb.append(GENRE_SEPARATOR);
            }
        }
        mGenres = sb.toString();
    }

    public String getGenresLegend() {
        return mGenres;
    }

    /**
     * Configs the Movie with the proper data from the RemoteConfiguration
     *
     * @param configuration - the RemoteConfiguration to use.
     */
    public void config(RemoteConfiguration configuration) {
        ImagesConfiguration imagesConfig = configuration.getImagesConfiguration();
        mPosterPath = imagesConfig.getPosterImageBaseUrl() + imagesConfig.getDefaultPosterSize() + mPosterPath;
    }


    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(getGenreIds());
        dest.writeLong(getId());
        dest.writeString(getTitle());
        dest.writeFloat(getPopularity());
        dest.writeString(getReleaseDate());
        dest.writeString(getPosterPath());
        dest.writeString(getOverview());
        dest.writeFloat(getVoteAverage());
        dest.writeLong(getVoteCount());
        dest.writeString(mGenres);
    }
}
