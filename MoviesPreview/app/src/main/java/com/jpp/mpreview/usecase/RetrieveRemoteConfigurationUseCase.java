package com.jpp.mpreview.usecase;

import android.support.annotation.Nullable;

import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.*;
import com.jpp.mpreview.model.Error;
import com.jpp.mpreview.datasource.IRemoteDataSource;

/**
 * UseCase that will perform the request to retrieve the RemoteConfiguration from the server
 * <br>
 * Created by Juan P. Peretti
 */
/* Package */ class RetrieveRemoteConfigurationUseCase extends UseCase<Void, RemoteConfiguration> {

    /**
     * Class constructor.
     *
     * @param eventController      - the EventController used to communicate date with the UI thread.
     * @param event      - the event used to notify any interested client.
     * @param dataSource - the data source to use in the execution.
     */
    public RetrieveRemoteConfigurationUseCase(EventController eventController, EventController.Event event, IRemoteDataSource dataSource) {
        super(eventController, event, dataSource);
    }

    @Override
    RemoteConfiguration executeImpl(@Nullable Void aVoid) throws Exception {
        RemoteConfiguration config = mDataSource.getSystemConfiguration();
        if (config == null) {
            mCurrentError = Error.REMOTE_CONFIG_NOT_RETRIEVED;
        }
        return config;
    }
}
