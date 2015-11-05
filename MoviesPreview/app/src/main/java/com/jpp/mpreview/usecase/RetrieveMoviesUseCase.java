package com.jpp.mpreview.usecase;

import android.support.annotation.Nullable;

import com.jpp.mpreview.datasource.IRemoteDataSource;
import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.*;
import com.jpp.mpreview.model.Error;

import java.util.Comparator;

/**
 * UseCase that will perform the request to retrieve the movie list from the server
 * <br>
 * Created by Juan P. Peretti
 */
/* Package */ class RetrieveMoviesUseCase extends UseCase<RemoteConfiguration, MoviePage> {


    /**
     * Class constructor.
     *
     * @param eventController - the EventController used to communicate date with the UI thread.
     * @param event           - the event used to notify any interested client.
     * @param dataSource      - the data source to use in the execution.
     */
    public RetrieveMoviesUseCase(EventController eventController, EventController.Event event, IRemoteDataSource dataSource) {
        super(eventController, event, dataSource);
    }

    @Override
    MoviePage executeImpl(@Nullable RemoteConfiguration remoteConfiguration) throws Exception {
        if (remoteConfiguration == null) {
            throw new IllegalArgumentException("The Remote Configuration can not be null at this point");
        }
        MoviePage movies = mDataSource.getMovies();
        // retrieve the genres to prepare each movie
        GenresPage genres = mDataSource.getGenres();
        if (movies != null && genres != null) {
            movies.sortWith(new MovieComparator());
            for (Movie movie : movies.getMovies()) {
                movie.config(remoteConfiguration);
                movie.setGenresToShow(genres);
            }
        } else {
            mCurrentError = Error.MOVIES_NOT_RETRIEVED;
        }
        return movies;
    }


    private static class MovieComparator implements Comparator<Movie> {

        @Override
        public int compare(Movie left, Movie right) {
            if (left.getPopularity() > right.getPopularity()) {
                return -1;
            } else if (left.getPopularity() < right.getPopularity()) {
                return 1;
            }
            return 0;
        }
    }

}
