package com.jpp.mpreview.datasource.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Wrapper class around the GSON library
 * <br>
 * Created by Juan P. Peretti
 */
public class GsonParser implements JsonParser {

    private static Gson GSON;

    public GsonParser() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        GSON = builder.create();
    }


    @Override
    public <T> T fromJson(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

}
