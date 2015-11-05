package com.jpp.mpreview.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jpp.mpreview.R;
import com.jpp.mpreview.model.Movie;
import com.jpp.mpreview.ui.IViewClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * RecyclerView Adapter that takes care of inflating and matching data between
 * Movies and items in the list.
 * <br>
 * Created by Juan P. Peretti
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {


    private List<Movie> mData;

    private IViewClickListener mTouchListenerInstance;

    public void setDataToShow(List<Movie> data) {
        mData = data;
        notifyDataSetChanged();
    }

    /**
     * Set a IViewClickListener to listen for events on the items.
     *
     * @param touchListener - the IViewClickListener that will handle the click.
     */
    public void setViewTouchListener(@NonNull IViewClickListener touchListener) {
        mTouchListenerInstance = touchListener;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(v, mTouchListenerInstance);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int i) {
        if(mData != null) {
            Movie movie = mData.get(i);
            movieViewHolder.bindMovieData(movie);
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mData != null) {
            count = mData.size();
        }
        return count;
    }


    /**
     * Inner class to respect the RecyclerView Adapter ViewHolder pattern
     */
    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {

        private final ImageView ivMoviePoster;
        private final TextView txtMovieTitle;
        private final TextView txtMovieDate;
        private final TextView txtMovieGenres;
        private final TextView txtMoviePopularity;
        private final IViewClickListener mListener;

        public MovieViewHolder(View itemView, IViewClickListener listener) {
            super(itemView);
            ivMoviePoster = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
            txtMovieTitle = (TextView) itemView.findViewById(R.id.txt_movie_title);
            txtMovieDate = (TextView) itemView.findViewById(R.id.txt_movie_date);
            txtMovieGenres = (TextView) itemView.findViewById(R.id.txt_movie_genre);
            txtMoviePopularity = (TextView) itemView.findViewById(R.id.txt_movie_popularity);
            mListener = listener;
            itemView.setOnTouchListener(this);
        }

        void bindMovieData(Movie movie) {
            showMoviePoster(movie);
            txtMovieTitle.setText(movie.getTitle());
            txtMovieDate.setText(movie.getReleaseDate());
            txtMovieGenres.setText(movie.getGenresLegend());
            txtMoviePopularity.setText(txtMoviePopularity.getContext().getString(R.string.popularity, String.valueOf(movie.getPopularity())));
        }

        private void showMoviePoster(Movie movie) {
            Picasso.with(itemView.getContext())
                    .load(movie.getPosterPath())
                    .placeholder(R.drawable.ic_image_place_holder)
                    .error(R.drawable.ic_image_place_holder)
                    .fit()
                    .centerCrop()
                    .into(ivMoviePoster);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                this.mListener.onClick(v, event.getX(), event.getY(), ivMoviePoster);
            }
            return true;
        }
    }

}
