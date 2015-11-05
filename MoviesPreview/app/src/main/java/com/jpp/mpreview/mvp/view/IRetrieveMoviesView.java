package com.jpp.mpreview.mvp.view;

import com.jpp.mpreview.model.MoviePage;

/**
 * Interface that defines the signature that any interested view in retrieving
 * and showing the list of movies must implement.
 * <br>
 * Created by Juan P. Peretti
 */
public interface IRetrieveMoviesView extends IView {


    /**
     * Called when the application is retrieving the movie list.
     */
    void showRetrievingMovies();

    /**
     * Called when an error is detected in the process.
     */
    void showErrorRetrievingMovies();


    /**
     * Called when the movie list is ready to be shown.
     *
     * @param moviePage - the MoviePage that contains the movie list.
     */
    void showMovies(MoviePage moviePage);
}
