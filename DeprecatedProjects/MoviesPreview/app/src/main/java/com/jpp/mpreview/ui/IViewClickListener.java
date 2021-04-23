package com.jpp.mpreview.ui;

import android.support.annotation.Nullable;
import android.view.View;

/**
 * Interface defined to handle clicks on views.
 * <br>
 * Created by Juan P. Peretti
 */
public interface IViewClickListener {

    /**
     * Called when the click is detected on the view that is passed as parameter
     *
     * @param v              - the View on which the touch is detected.
     * @param x              - the x coordinate of the touch event.
     * @param y              - the y coordinate of the touch event.
     * @param transitionView - the View that is starting the transition.
     */
    void onClick(View v, float x, float y, @Nullable View transitionView);
}
