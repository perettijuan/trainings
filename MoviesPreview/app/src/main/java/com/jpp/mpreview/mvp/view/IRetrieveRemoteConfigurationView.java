package com.jpp.mpreview.mvp.view;

import android.support.annotation.NonNull;

import com.jpp.mpreview.model.RemoteConfiguration;

/**
 * Interface that defines the signature that any interested view in retrieving
 * the remote configuration must implement.
 * <br>
 * Created by Juan P. Peretti
 */
public interface IRetrieveRemoteConfigurationView extends IView {


    /**
     * Called when the view needs to show the loading status.
     */
    void showRetrievingRemoteConfiguration();


    /**
     * Called when the remote configuration is retrieved.
     *
     * @param remoteConfiguration - the RemoteConfiguration instance retrieved.
     */
    void showRemoteConfigurationRetrieved(@NonNull RemoteConfiguration remoteConfiguration);


    /**
     * Called when an error is detected while retrieving the remote configuration.
     */
    void showErrorWhileRetrievingRemoteConfiguration();

}
