package com.jpp.mpreview.usecase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.jpp.mpreview.Logger;
import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.Error;
import com.jpp.mpreview.datasource.IRemoteDataSource;

/**
 * Definition of use case that is used to perform any use case in the application.
 * There will be at least one UseCase per feature in the application.
 * <br>
 * Created by Juan P. Peretti
 */
public abstract class UseCase<Param, Result extends Parcelable> {


    public static final String KEY_DATA_VALUE = "key_data_value";
    public static final String KEY_ERROR_VALUE = "key_error_value";

    // EventController instance to post the results
    EventController mEventController;

    // Remote data source to query for data
    IRemoteDataSource mDataSource;

    // The error instance starts in none
    Error mCurrentError = Error.NONE;

    // The Event to notify
    EventController.Event mEvent;

    /**
     * Class constructor.
     *
     * @param eventController      - the EventController used to communicate date with the UI thread.
     * @param event      - the event used to notify any interested client.
     * @param dataSource - the data source to use in the execution.
     */
    public UseCase(EventController eventController, EventController.Event event, IRemoteDataSource dataSource) {
        mEventController = eventController;
        mEvent = event;
        mDataSource = dataSource;
    }

    /**
     * Called when the UseCase is executed in a background thread.
     * <br>
     *
     * @param param - the Bundle data that contains any possible data to be used in the UseCase execution.
     */
    public void execute(final Param param) {
        new AsyncWorker().execute(param);
    }


    /**
     * AsyncTask that executes the request in a background thread and communicates
     * the result to the calling thread.
     */
    private class AsyncWorker extends AsyncTask<Param, Void, Result> {
        @Override
        protected Result doInBackground(Param... bundles) {
            Param param = bundles[0];
            Result result;
            try {
                result = executeImpl(param);
            } catch (Exception e) {
                Logger.logException(e);
                result = null;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Result l) {
            if (l != null) {
                postEvent(l);
            } else {
                if (mCurrentError == null) {
                    mCurrentError = Error.GENERIC;
                }
                postError();
            }
        }
    }


    void postEvent(@Nullable Parcelable data) {
        if (mEventController != null) {
            Bundle dataContainer = new Bundle();
            if (data != null) {
                dataContainer.putParcelable(KEY_DATA_VALUE, data);
            }
            mEventController.notifyEvent(mEvent, dataContainer);
        }
    }


    void postError() {
        if (mEventController != null) {
            Bundle dataContainer = new Bundle();
            dataContainer.putSerializable(KEY_ERROR_VALUE, mCurrentError);
            mEventController.notifyEvent(mEvent, dataContainer);
        }
    }

    /**
     * Method that performs the actual logic contained in the UseCase.
     *
     * @param param - the Bundle data that contains any possible data to be used in the UseCase execution.
     */
    abstract Result executeImpl(@Nullable Param param) throws Exception;
}