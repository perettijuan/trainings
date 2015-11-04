package com.jpp.mpreview.rest;

import android.support.annotation.Nullable;

import com.jpp.mpreview.model.RemoteConfiguration;

/**
 * Interface that defines the signature of a remote source that is used to retrieve
 * data.
 * <br>
 * Created by Juan P. Peretti
 */
public interface IRemoteDataSource {


    /**
     * Retrieves the system remote configuration from the remote data source.
     *
     * @return - the retrieved RemoteConfiguration, null if some error is detected.
     */
    @Nullable
    RemoteConfiguration getSystemConfiguration();

}
