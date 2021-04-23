package com.jpp.mpreview.datasource;

import android.support.annotation.Nullable;

import com.jpp.mpreview.model.GenresPage;
import com.jpp.mpreview.model.MoviePage;
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


    /**
     * Retrieves the list of movies from the remote data source.
     *
     * @return - the retrieved Movies in a MoviePage, null if some error is detected.
     */
    @Nullable
    MoviePage getMovies();


    /**
     * Retrieves the list of genres for movies from the remote data source.
     *
     * @return - the retrieved GenresPage from the server or null if an error is detected.
     */
    @Nullable
    GenresPage getGenres();
}
