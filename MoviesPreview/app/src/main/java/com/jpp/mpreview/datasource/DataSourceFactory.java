package com.jpp.mpreview.datasource;

import com.jpp.mpreview.datasource.parser.GsonParser;

/**
 * Factory class used to get the proper DataSource
 * <br>
 * Created by Juan P. Peretti
 */
public class DataSourceFactory {

    private static final IRemoteDataSource DATA_SOURCE = new TheMovieDBRemoteDataSource(new GsonParser());

    public static IRemoteDataSource getRemoteDataSource() {
        return DATA_SOURCE;
    }

}
