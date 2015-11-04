package com.jpp.mpreview;

import android.app.Application;

import com.jpp.mpreview.event.EventController;

/**
 * Application class that handles the entire application state. In this case,
 * is used to ensure singleton instances.
 * <br>
 * Created by Juan P. Peretti
 */
public class MoviePreviewApplication extends Application {


    public static EventController EVENT_CONTROLLER;

    @Override
    public void onCreate() {
        super.onCreate();
        EVENT_CONTROLLER = new EventController();
    }
}
