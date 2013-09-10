package com.jpp.effective.generics;

import java.util.HashMap;
import java.util.Map;

public class TypeFaceHeterogeneousMap {


    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException();
        }
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

}