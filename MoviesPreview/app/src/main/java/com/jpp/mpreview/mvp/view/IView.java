package com.jpp.mpreview.mvp.view;


import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Interface that defines the signature that all the interested in implement the MVP pattern
 * from the View side needs to implement.
 * <br>
 * Created by Juan P. Peretti
 */
public interface IView {

    /**
     * Retrieves the Context that is relative to the entire application.
     *
     * @return - the application's Context
     */
    @NonNull
    Context getApplicationContext();


    /**
     * Shows the no connectivity view.
     */
    void showNoConnectivity();
}

