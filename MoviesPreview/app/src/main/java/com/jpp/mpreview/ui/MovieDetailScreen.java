package com.jpp.mpreview.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jpp.mpreview.R;
import com.jpp.mpreview.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Activity/Screen that shows the details of a given movie.
 * Note that this screen does not follow the MVP pattern since the implementation
 * is simple.
 * <p/>
 * Created by Juan P. Peretti
 */
public class MovieDetailScreen extends AppCompatActivity {


    static Intent movieDetail(Activity context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailScreen.class);
        intent.putExtra(MOVIE_KEY, movie);
        return intent;
    }

    private static final String MOVIE_KEY = "movie_key";

    @InjectView(R.id.iv_movie_detail)
    ImageView ivMovieDetail;

    @InjectView(R.id.tb_movie_detail)
    Toolbar tbMovieDetail;

    @InjectView(R.id.movie_detail_collapsing_toolbar)
    CollapsingToolbarLayout movieDetailCollapsingToolbar;

    @InjectView(R.id.txt_movie_detail_title)
    TextView txtMovieDetailTitle;

    @InjectView(R.id.txt_movie_detail_body)
    TextView txtMovieDetailBody;

    @InjectView(R.id.txt_movie_detail_popularity)
    TextView txtMovieDetailPopularity;

    @InjectView(R.id.txt_movie_detail_date)
    TextView txtMovieDetailDate;

    @InjectView(R.id.view_divider)
    View viewDivider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_screen);
        ButterKnife.inject(this);


        // setup the action bar
        setSupportActionBar(tbMovieDetail);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        showMovie();
    }


    private void showMovie() {
        Movie movie = getIntent().getParcelableExtra(MOVIE_KEY);
        if (movie != null) {
            txtMovieDetailTitle.setText(movie.getTitle());
            txtMovieDetailBody.setText(movie.getOverview());
            txtMovieDetailPopularity.setText(getString(R.string.popularity, String.valueOf(movie.getPopularity())));
            txtMovieDetailDate.setText(movie.getReleaseDate());

            // do not show the views until they're ready
            txtMovieDetailTitle.setVisibility(View.INVISIBLE);
            txtMovieDetailBody.setVisibility(View.INVISIBLE);
            txtMovieDetailPopularity.setVisibility(View.INVISIBLE);
            txtMovieDetailDate.setVisibility(View.INVISIBLE);
            viewDivider.setVisibility(View.INVISIBLE);

            Picasso.with(this)
                    .load(movie.getPosterPath())
                    .placeholder(R.drawable.ic_image_place_holder)
                    .error(R.drawable.ic_image_place_holder)
                    .fit()
                    .centerCrop()
                    .into(ivMovieDetail, new Callback() {
                        @Override
                        public void onSuccess() {
                            Bitmap bitmap = ((BitmapDrawable) ivMovieDetail.getDrawable()).getBitmap();
                            generatePalette(bitmap);
                        }

                        @Override
                        public void onError() {
                            //DO nothing
                        }
                    });
        }
    }


    /**
     * Generates the Palette that will be used to show the colors of the elements in the UI.
     *
     * @param bitmap - the Bitmap to get the data from.
     */
    private void generatePalette(Bitmap bitmap) {
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGenerated(Palette palette) {
                // Set the color for the FAB


                // The color for the background of the title and the ActionBar needs be the same
                txtMovieDetailTitle.setBackgroundColor(palette.getVibrantColor(R.color.primary));
                movieDetailCollapsingToolbar.setContentScrimColor(palette.getVibrantColor(R.color.primary));
                txtMovieDetailPopularity.setBackgroundColor(palette.getLightVibrantColor(R.color.accent));
                txtMovieDetailDate.setBackgroundColor(palette.getLightVibrantColor(R.color.accent));

                txtMovieDetailTitle.setVisibility(View.VISIBLE);
                txtMovieDetailBody.setVisibility(View.VISIBLE);
                txtMovieDetailPopularity.setVisibility(View.VISIBLE);
                txtMovieDetailDate.setVisibility(View.VISIBLE);
                viewDivider.setVisibility(View.VISIBLE);

                // Change the color of the status bar (if possible)
                if (isRunningOnLollipopOrLater()) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(palette.getDarkVibrantColor(R.color.primary_dark));
                }
            }
        });
    }


    /**
     * Determinates if the application is running on a Lollipop version device
     *
     * @return - true if it's running o a Lollipop device, false any other case.
     */
    public static boolean isRunningOnLollipopOrLater() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
