package com.jpp.mpreview.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jpp.mpreview.MoviePreviewApplication;
import com.jpp.mpreview.R;
import com.jpp.mpreview.model.Movie;
import com.jpp.mpreview.model.MoviePage;
import com.jpp.mpreview.model.RemoteConfiguration;
import com.jpp.mpreview.mvp.presenter.Presenter;
import com.jpp.mpreview.mvp.presenter.PresenterFactory;
import com.jpp.mpreview.mvp.view.IRetrieveMoviesView;
import com.jpp.mpreview.ui.adapter.MoviesAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;

/**
 * Application's Main Screen. This screen takes care of showing the list of movies.
 * <p/>
 * Created by Juan P. Peretti
 */
public class MainScreen extends AppCompatActivity implements IRetrieveMoviesView {


    /**
     * Creates the Intent that starts the MainScreen.
     *
     * @param context             - the client context that will start the Activity.
     * @param remoteConfiguration - the RemoteConfiguration to use.
     * @return - the newly created intent.
     */
    static Intent mainScreen(Activity context, RemoteConfiguration remoteConfiguration) {
        Intent intent = new Intent(context, MainScreen.class);
        intent.putExtra(REMOTE_CONFIGURATION_KEY, remoteConfiguration);
        return intent;
    }

    private static final String REMOTE_CONFIGURATION_KEY = "remote_config_key";

    @InjectView(R.id.main_screen_root)
    View mainScreenRoot;

    @InjectView(R.id.tb_main_screen)
    Toolbar tbMainScreen;

    @InjectView(R.id.swipe_main_screen)
    SwipeRefreshLayout swipeMainScreen;

    @InjectView(R.id.rv_movies)
    RecyclerView rvMovies;


    private Presenter<RemoteConfiguration> mPresenter;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        ButterKnife.inject(this);

         /*
         * Set the Toolbar as the action bar and then
         * set the ActionBar to enable Home as Up
         * in order to show the navigation menu.
         */
        setSupportActionBar(tbMainScreen);

        mPresenter = PresenterFactory.retrieveMovieListPresenter(MoviePreviewApplication.EVENT_CONTROLLER, this);


        prepareSwipeView();
        prepareListView();
        retrieveMovies();
    }


    /**
     * Fix the problem of the Swipe view not showing the first time.
     * Source: http://stackoverflow.com/questions/26858692/swiperefreshlayout-setrefreshing-not-showing-indicator-initially
     */
    private void prepareSwipeView() {

        swipeMainScreen.setColorSchemeResources(R.color.primary, R.color.accent);
        swipeMainScreen.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveMovies();
            }
        });
    }

    private void prepareListView() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        rvMovies.setItemAnimator(new ScaleInAnimator());
        mAdapter = new MoviesAdapter();
        mAdapter.setViewTouchListener(new IViewClickListener() {
            @Override
            public void onClick(View v, float x, float y, @Nullable View transitionView) {
                int position = rvMovies.getChildAdapterPosition(v);
                Movie movie = mAdapter.getItemInPosition(position);
                showMovieDetails(movie, transitionView);
            }
        });
        rvMovies.setAdapter(mAdapter);
    }

    private void retrieveMovies() {
        RemoteConfiguration configuration = getIntent().getParcelableExtra(REMOTE_CONFIGURATION_KEY);
        mPresenter.start(configuration);
    }


    private void showMovieDetails(Movie movie, View transitionView) {
        Intent intent = MovieDetailScreen.movieDetail(this, movie);
        String transitionName = getString(R.string.transition_movies_item);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, transitionView, transitionName);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

//////////////////////////////////////////// PRESENTER INTERACTIONS ////////////////////////////////////////////////////////////

    @Override
    public void showRetrievingMovies() {
        swipeMainScreen.setRefreshing(true);
    }

    @Override
    public void showErrorRetrievingMovies() {
        swipeMainScreen.setRefreshing(false);
        showErrorView(getString(R.string.error_retrieving_movies));
    }

    @Override
    public void showMovies(MoviePage moviePage) {
        swipeMainScreen.setRefreshing(false);
        mAdapter.setDataToShow(moviePage.getMovies());
    }

    @Override
    public void showNoConnectivity() {
        showErrorView(getString(R.string.no_connectivity_error));
    }


    private void showErrorView(String text) {
        Snackbar snackbar = Snackbar.make(mainScreenRoot, text, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
