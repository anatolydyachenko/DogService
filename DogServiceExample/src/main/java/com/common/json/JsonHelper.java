package com.common.json;

import com.common.app.Dog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JsonHelper {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String mapToJson(Map<Integer, Dog> map) {
        if (map == null) // todo remove null check
            map = Collections.emptyMap();
        return gson.toJson(map);
    }

    public static String mapToJson(Dog dog) {
        return gson.toJson(dog);
    }
}