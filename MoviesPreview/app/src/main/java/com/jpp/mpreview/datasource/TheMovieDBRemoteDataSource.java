package com.jpp.mpreview.datasource;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jpp.mpreview.Logger;
import com.jpp.mpreview.model.GenresPage;
import com.jpp.mpreview.model.MoviePage;
import com.jpp.mpreview.model.RemoteConfiguration;
import com.jpp.mpreview.datasource.parser.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * An IRemoteDataSource implementation to retrieve the data from The MovieDB API source.
 * <br>
 * Created by Juan P. Peretti
 */

/* default */ class TheMovieDBRemoteDataSource implements IRemoteDataSource {

    private static final String TAG = "DATA_SOURCE";


    // The Api Key provided by the TMDB API
    private static final String API_KEY = "eddf6980a6d7dadd72386f55f94ab571";
    //Timeout to read from server
    private static final int READ_TIMEOUT = 100000;
    //Connect timeout
    private static final int CONNECT_TIMEOUT = 100000;
    //Buffer size use for reading response data
    private static final int BUFFER_SIZE = 8096;
    //Code for OK responses
    private static final int RESPONSE_CODE_OK = 200;

    // Helper attrs
    private static final String QUESTION_MARK = "?";
    private static final String EQUALS = "=";
    private static final String AMPERSAND = "&";

    // URL paths
    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String CONFIGURATION_URL = BASE_URL + "configuration";
    private static final String MOVIE = BASE_URL + "movie/";
    private static final String TOP_RATED = MOVIE + "top_rated";
    private static final String GENRE_MOVIE_LIST = BASE_URL + "genre/movie/list";


    // A JsonParser
    private final JsonParser PARSER;


    /**
     * Class constructor.
     *
     * @param parser - The JsonParser instance to use.
     */
    TheMovieDBRemoteDataSource(@NonNull JsonParser parser) {
        PARSER = parser;
    }


    /**
     * Enumeration used to wrap all the possible
     * verbs for HTTP request used in the data source.
     */
    enum RequestTypes {

        GET("GET");


        private String requestName;

        RequestTypes(String name) {
            requestName = name;
        }

        public String getType() {
            return requestName;
        }

    }


    @Nullable
    @Override
    public RemoteConfiguration getSystemConfiguration() {
        RemoteConfiguration remoteConfiguration = null;
        String rawResponse = executeHttpRequest(CONFIGURATION_URL, RequestTypes.GET, getBasicQueryStringParams());
        if (rawResponse != null) {
            remoteConfiguration = PARSER.fromJson(rawResponse, RemoteConfiguration.class);
        }
        return remoteConfiguration;
    }

    @Nullable
    @Override
    public MoviePage getMovies() {
        MoviePage movies = null;
        String rawResponse = executeHttpRequest(TOP_RATED, RequestTypes.GET, getBasicQueryStringParams());
        if (rawResponse != null) {
            movies = PARSER.fromJson(rawResponse, MoviePage.class);
        }
        return movies;
    }

    @Nullable
    @Override
    public GenresPage getGenres() {
        GenresPage genres = null;
        String rawResponse = executeHttpRequest(GENRE_MOVIE_LIST, RequestTypes.GET, getBasicQueryStringParams());
        if (rawResponse != null) {
            genres = PARSER.fromJson(rawResponse, GenresPage.class);
        }
        return genres;
    }

    /**
     * Executes an HTTP request to the server in order to retrieve a value from it. Note that if an error
     * is detected or if the result code is invalid, then a null value is returned. This is just because
     * we do not handle specific error codes at this point.
     *
     * @param urlAsString - the URL as a String value to be executed.
     * @param reqType     - the RequestTypes verb to execute
     * @param params      - additional parameters needed.
     * @return - the raw value returned by the server. Null if an error is detected.
     */
    private static String executeHttpRequest(String urlAsString, RequestTypes reqType, Map<String, String> params) {
        InputStream input = null;
        String resultAsString = null;
        try {

            // Prepare the URL
            StringBuilder sb = new StringBuilder();
            sb.append(urlAsString);

            // Add the query string, if needed
            appendParams(sb, params);

            //Open the connection
            String parsedUrl = sb.toString();
            URL url = new URL(parsedUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECT_TIMEOUT);


            // set the request type
            connection.setRequestMethod(reqType.getType());

            Logger.log(TAG, "#Connect:" + reqType.getType() + " -to URL: " + parsedUrl);

            // Connect to the end-point
            connection.connect();

            int responseCode = connection.getResponseCode();

            // Response valid
            if (responseCode == RESPONSE_CODE_OK) {
                input = connection.getInputStream();
                if (input != null) {
                    resultAsString = readContents(input);
                    Logger.log(TAG, "#Response body: " + resultAsString);
                }
            }

        } catch (Exception e) {
            Logger.logException(e);
            resultAsString = null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    Logger.logException(e);
                    resultAsString = null;
                }
            }
        }
        return resultAsString;
    }


    /**
     * Appends parameters to the URL passed in the StringBuilder
     */
    private static void appendParams(StringBuilder sb, Map<String, String> params) {
        if (params != null) {
            Iterator it = params.entrySet().iterator();
            boolean isFirstParam = true;
            while (it.hasNext()) {

                if (isFirstParam) {
                    sb.append(QUESTION_MARK);
                    isFirstParam = false;
                } else {
                    sb.append(AMPERSAND);
                }

                Map.Entry<String, String> pairs = (Map.Entry) it.next();
                String encoded;
                String raw = pairs.getValue();
                try {
                    encoded = URLEncoder.encode(raw, "utf-8");
                } catch (Exception e) {
                    encoded = raw;
                }
                sb.append(pairs.getKey() + EQUALS + encoded);
                it.remove();
            }
        }
    }


    /**
     * Reads the contents of an InputStream into a String.
     */
    private static String readContents(InputStream is) throws IOException {
        String processedResponse = null;
        StringBuilder contents = new StringBuilder();
        byte[] buffer = new byte[BUFFER_SIZE];
        if (is != null) {
            contents.delete(0, contents.length());
            int readBytes;
            while ((readBytes = is.read(buffer, 0, BUFFER_SIZE)) > 0) {
                contents.append(new String(buffer, 0, readBytes));
            }
            processedResponse = contents.toString();
        }
        return processedResponse;
    }


    /**
     * Creates a Map that contains the basic parameters used in the query string of the request.
     *
     * @return - a Map containing the basic query string parameters.
     */
    private Map<String, String> getBasicQueryStringParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("Accept", "application/json");
        params.put("api_key", API_KEY);
        return params;
    }

}
