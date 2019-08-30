package br.com.miniquiz.common;

import com.google.gson.Gson;

/**
 * Created by Felipe Gomes on 28/08/19.
 */
public class CommonJsonParser {
    public static <T> T jsonToObject(String stringToParse, Class<T> type) {
        return new Gson().fromJson(stringToParse, type);
    }

    public static <T> String objectToJson(T objectToParse) {
        Gson gson = new Gson();
        return gson.toJson(objectToParse);
    }

}