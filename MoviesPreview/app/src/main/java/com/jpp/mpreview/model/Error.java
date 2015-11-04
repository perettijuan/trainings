package com.jpp.mpreview.model;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;

/**
 * Class that is used to specify an error in the common framework.
 * <br>
 * Created by Juan P. Peretti
 */
public enum Error {

    NONE,
    GENERIC,
    REMOTE_CONFIG_NOT_RETRIEVED;

    /**
     * Verifies if the error is a network related error.
     *
     * @param context - the application's context.
     * @return - true if it is a network related error, false any other case.
     */
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    public boolean isNetworkError(@NonNull Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo == null;
    }
}