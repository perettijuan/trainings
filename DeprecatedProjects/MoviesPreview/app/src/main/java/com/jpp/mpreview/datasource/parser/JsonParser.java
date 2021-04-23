package com.jpp.mpreview.datasource.parser;

/**
 * Interface that defines the signature that any JSON parser must follow.
 * <br>
 * Created by Juan P. Peretti
 */
public interface JsonParser {


    /**
     * Creates an object instance of type T from a JSON string value.
     *
     * @param json     - the JSON formatted string value.
     * @param classOfT - the type of the object type to return.
     * @return - the parsed object.
     */
    <T> T fromJson(String json, Class<T> classOfT);

}
