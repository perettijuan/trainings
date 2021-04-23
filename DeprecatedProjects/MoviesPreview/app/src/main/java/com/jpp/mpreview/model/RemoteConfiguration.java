package com.jpp.mpreview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Abstraction that represents the initial configuration of the remote system. This class
 * contains data related to URLs associated with the movies and some other particular settings
 * of the remote data source.
 * <br>
 * Created by Juan P. Peretti
 */

public class RemoteConfiguration implements Parcelable {

    @Expose
    @SerializedName("images")
    private ImagesConfiguration mImagesConfiguration;


    public RemoteConfiguration() {

    }

    private RemoteConfiguration(Parcel in) {
        mImagesConfiguration = in.readParcelable(ImagesConfiguration.class.getClassLoader());
    }


    /* Default */ ImagesConfiguration getImagesConfiguration() {
        return mImagesConfiguration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mImagesConfiguration, flags);
    }

    public static final Creator<RemoteConfiguration> CREATOR = new Creator<RemoteConfiguration>() {
        @Override
        public RemoteConfiguration createFromParcel(Parcel in) {
            return new RemoteConfiguration(in);
        }

        @Override
        public RemoteConfiguration[] newArray(int size) {
            return new RemoteConfiguration[size];
        }
    };
}
