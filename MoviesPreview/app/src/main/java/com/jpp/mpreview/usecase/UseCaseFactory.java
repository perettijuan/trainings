package com.jpp.mpreview.usecase;

import android.support.annotation.NonNull;

import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.MoviePage;
import com.jpp.mpreview.model.RemoteConfiguration;
import com.jpp.mpreview.datasource.IRemoteDataSource;

/**
 * Factory class used to access to all UseCases in the package.
 * <br>
 * Created by Juan P. Peretti
 */
public class UseCaseFactory {


    /**
     * Creates a new instance of a UseCase that will retrieve the RemoteConfiguration from the server
     *
     * @return - the newly created instance of the UseCase.
     */
    public static UseCase<Void, RemoteConfiguration> getRemoteConfigurationUseCase(@NonNull EventController eventController,
                                                                                   @NonNull EventController.Event event,
                                                                                   @NonNull IRemoteDataSource dataSource) {
        return new RetrieveRemoteConfigurationUseCase(eventController, event, dataSource);
    }


    /**
     * Creates a new instance of a UseCase that will retrieve a list of Movies in the form of
     * a MoviePage.
     */
    public static UseCase<RemoteConfiguration, MoviePage> getMoviesUseCase(@NonNull EventController eventController,
                                                            @NonNull EventController.Event event,
                                                            @NonNull IRemoteDataSource dataSource) {
        return new RetrieveMoviesUseCase(eventController, event, dataSource);
    }

}
