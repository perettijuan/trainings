package com.jpp.mpreview.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.*;
import com.jpp.mpreview.model.Error;
import com.jpp.mpreview.mvp.view.IRetrieveMoviesView;
import com.jpp.mpreview.mvp.view.IView;
import com.jpp.mpreview.usecase.UseCase;

/**
 * Presenter that takes care of retrieving the Movies from the server and
 * presenting it to the proper view.
 * <br>
 * Created by Juan P. Peretti
 */
/* Package */ class RetrieveMoviesPresenter extends Presenter<RemoteConfiguration> {


    // The IView client
    private IRetrieveMoviesView mView;

    // The use case to execute
    private UseCase<RemoteConfiguration, MoviePage> mUseCase;

    /**
     * Class constructor. Default modifier in order to avoid instantiation from outside the
     * package of this class.
     *
     * @param eventController
     * @param event
     */
    RetrieveMoviesPresenter(@NonNull EventController eventController,
                            @NonNull EventController.Event event,
                            @NonNull IRetrieveMoviesView view,
                            @NonNull UseCase<RemoteConfiguration, MoviePage> useCase) {
        super(eventController, event);
        mView = view;
        mUseCase = useCase;
    }

    @Override
    void startImpl(@Nullable RemoteConfiguration remoteConfiguration) {
        mView.showRetrievingMovies();
        mUseCase.execute(remoteConfiguration);
    }

    @Override
    void handleErrorImpl(com.jpp.mpreview.model.Error error) {
        mView.showErrorRetrievingMovies();
    }

    @Override
    protected IView getIView() {
        return mView;
    }

    @Override
    public boolean handleEvent(@NonNull EventController.Event event, @NonNull Bundle data) {
        boolean handled = false;
        if (mEvent.equals(event)) {
            // un-subscribe from the event controller
            unSubscribe();
            // handle the result properly
            handled = true;
            if (data.containsKey(UseCase.KEY_DATA_VALUE)) {
                MoviePage movies = data.getParcelable(UseCase.KEY_DATA_VALUE);
                mView.showMovies(movies);
            } else {
                Error error = (Error) data.getSerializable(UseCase.KEY_ERROR_VALUE);
                handleError(error);
            }
        }
        return handled;
    }
}
