package com.jpp.mpreview.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.jpp.mpreview.MoviePreviewApplication;
import com.jpp.mpreview.R;
import com.jpp.mpreview.event.EventController;
import com.jpp.mpreview.model.RemoteConfiguration;
import com.jpp.mpreview.mvp.presenter.Presenter;
import com.jpp.mpreview.mvp.presenter.PresenterFactory;
import com.jpp.mpreview.mvp.view.IRetrieveRemoteConfigurationView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Application's Splash Screen. This is the entry point in the application.
 * <p/>
 * Created by Juan P. Peretti
 */
public class SplashScreen extends AppCompatActivity implements IRetrieveRemoteConfigurationView {


    @InjectView(R.id.splash_root)
    View splashRoot;


    @InjectView(R.id.pg_loading_splash)
    ProgressBar pgLoadingSplash;


    private Presenter<Void> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        ButterKnife.inject(this);

        EventController eventController = MoviePreviewApplication.EVENT_CONTROLLER;
        mPresenter = PresenterFactory.retrieveRemoteConfigurationPresenter(eventController, this);
        mPresenter.start(null);
    }

//////////////////////////////////////////// PRESENTER INTERACTIONS ////////////////////////////////////////////////////////////

    @Override
    public void showRetrievingRemoteConfiguration() {
        pgLoadingSplash.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRemoteConfigurationRetrieved(@NonNull RemoteConfiguration remoteConfiguration) {
        showErrorView("DONE");
    }

    @Override
    public void showErrorWhileRetrievingRemoteConfiguration() {
        showErrorView(getString(R.string.remote_configuration_error));
    }

    @Override
    public void showNoConnectivity() {
        showErrorView(getString(R.string.no_connectivity_error));
    }


    private void showErrorView(String text) {
        Snackbar snackbar = Snackbar.make(splashRoot, text, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
