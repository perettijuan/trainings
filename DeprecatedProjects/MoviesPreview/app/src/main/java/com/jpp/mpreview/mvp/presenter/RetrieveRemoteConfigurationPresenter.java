package com.jpp.mpreview.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.Error;
import com.jpp.mpreview.model.RemoteConfiguration;
import com.jpp.mpreview.mvp.view.IRetrieveRemoteConfigurationView;
import com.jpp.mpreview.mvp.view.IView;
import com.jpp.mpreview.usecase.UseCase;

/**
 * Presenter that takes care of retrieving the RemoteConfiguration from the server each
 * time that the application starts.
 * <br>
 * Created by Juan P. Peretti
 */
/* Package */ class RetrieveRemoteConfigurationPresenter extends Presenter<Void> {

    // The view client instance
    private IRetrieveRemoteConfigurationView mView;

    // The use case to execute
    private UseCase<Void, RemoteConfiguration> mUseCase;

    /**
     * Class constructor. Default modifier in order to avoid instantiation from outside the
     * package of this class.
     */
    RetrieveRemoteConfigurationPresenter(@NonNull EventController eventController,
                                         @NonNull EventController.Event event,
                                         @NonNull IRetrieveRemoteConfigurationView view,
                                         @NonNull UseCase<Void, RemoteConfiguration> useCase) {
        super(eventController, event);
        mView = view;
        mUseCase = useCase;
    }

    @Override
    void startImpl(@Nullable Void aVoid) {
        mView.showRetrievingRemoteConfiguration();
        mUseCase.execute(null);
    }

    @Override
    void handleErrorImpl(Error error) {
        mView.showErrorWhileRetrievingRemoteConfiguration();
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
                RemoteConfiguration config = data.getParcelable(UseCase.KEY_DATA_VALUE);
                mView.showRemoteConfigurationRetrieved(config);
            } else {
                Error error = (Error) data.getSerializable(UseCase.KEY_ERROR_VALUE);
                handleError(error);
            }
        }
        return handled;
    }
}
