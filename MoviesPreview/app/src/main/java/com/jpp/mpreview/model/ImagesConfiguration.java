package com.jpp.mpreview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * An abstraction that contains the data related to the images configuration f
 * rom the remote datasource.
 * <br>
 * Created by Juan P. Peretti
 */
public class ImagesConfiguration implements Parcelable {

    @Expose
    @SerializedName("base_url")
    private String mBaseUrl;

    @Expose
    @SerializedName("poster_sizes")
    String[] mPosterSizes;

    public ImagesConfiguration() {

    }

    private ImagesConfiguration(Parcel in) {
        mBaseUrl = in.readString();
        mPosterSizes = in.createStringArray();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mBaseUrl);
        dest.writeStringArray(mPosterSizes);
    }

    public static final Creator<ImagesConfiguration> CREATOR = new Creator<ImagesConfiguration>() {
        @Override
        public ImagesConfiguration createFromParcel(Parcel in) {
            return new ImagesConfiguration(in);
        }

        @Override
        public ImagesConfiguration[] newArray(int size) {
            return new ImagesConfiguration[size];
        }
    };
}
