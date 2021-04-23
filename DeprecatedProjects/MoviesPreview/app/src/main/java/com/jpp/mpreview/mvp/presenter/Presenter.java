package com.jpp.mpreview.mvp.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.event.IEventListener;
import com.jpp.mpreview.model.Error;
import com.jpp.mpreview.mvp.view.IView;

/**
 * Base class for all presenters that are part of the MVP pattern.
 * <br>
 * Created by Juan P. Peretti
 */
public abstract class Presenter<Param> implements IEventListener {

    // The Event to listen for changes
    EventController.Event mEvent;

    // EventController instance to register for event updates
    EventController mEventController;


    /**
     * Class constructor. Default modifier in order to avoid instantiation from outside the
     * package of this class.
     */
    /* Default */Presenter(@NonNull EventController eventController, @NonNull EventController.Event event) {
        mEventController = eventController;
        mEvent = event;
    }


    /**
     * Called when the Presenter needs to start it's execution.
     *
     * @param param - the Parameter that will be used by this presenter on it's execution.
     */
    public void start(@Nullable Param param) {
        subscribe();
        startImpl(param);
    }


    /**
     * This is the method that does the actual work. Every presenter needs to implement it.
     *
     * @param param - the Parameter that will be used by this presenter on it's execution.
     */
    /* Default */
    abstract void startImpl(@Nullable Param param);

    /* Default */
    abstract void handleErrorImpl(Error error);

    /* Default */ void subscribe() {
        mEventController.registerToSingleEvent(mEvent, this);
    }

    /* Default */ void unSubscribe() {
        mEventController.unregisterFromEvent(mEvent, this);
    }


    /**
     * Retrieves the IView instance attached to this presenter.
     *
     * @return - the IView instance.
     */
    protected abstract IView getIView();


    /**
     * Called when a no connectivity error is detected
     */
    protected void handleNoConnectivityError() {
        IView view = getIView();
        view.showNoConnectivity();
    }


    /* Default */ void handleError(Error error) {
        if (error.isNetworkError(getIView().getApplicationContext())) {
            getIView().showNoConnectivity();
        } else {
            handleErrorImpl(error);
        }
    }

}
