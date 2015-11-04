package com.jpp.mpreview.mvp.presenter;

import android.support.annotation.NonNull;

import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.RemoteConfiguration;
import com.jpp.mpreview.mvp.view.IRetrieveRemoteConfigurationView;
import com.jpp.mpreview.rest.DataSourceFactory;
import com.jpp.mpreview.rest.IRemoteDataSource;
import com.jpp.mpreview.usecase.UseCase;
import com.jpp.mpreview.usecase.UseCaseFactory;

/**
 * Factory class used to access all the Presenters in the package.
 * <p/>
 * Created by Juan P. Peretti
 */
public class PresenterFactory {


    /**
     * Creates and retrieves the UseCase that will retrieve the remote conefiguration from the server.
     *
     * @param eventController - the EventController to subscribe to events.
     * @param view            - the client IView.
     * @return - the newly created instance.
     */
    public static Presenter<Void> retrieveRemoteConfigurationPresenter(@NonNull EventController eventController,
                                                                       @NonNull IRetrieveRemoteConfigurationView view) {
        EventController.Event event = EventController.Event.RETRIEVE_REMOTE_CONFIGURATION;
        IRemoteDataSource dataSource = DataSourceFactory.getRemoteDataSource();
        UseCase<Void, RemoteConfiguration> useCase = UseCaseFactory.getRemoteConfigurationUseCase(eventController, event, dataSource);
        return new RetrieveRemoteConfigurationPresenter(eventController, event, view, useCase);
    }

}
