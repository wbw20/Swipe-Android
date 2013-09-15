package com.casehacks.swipe_android.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RestCall {

    private final static String host = "http://209.20.92.28:8080";
    private static Gson gson = new Gson();

    /**
     * Get a json array and reflectively cast it.
     * 
     *       List<Buy> buys = get("buy", Buy.class);
     * 
     * The above example gets a list of all spots.
     * 
     * @param path The url of the server resource.
     * @param type The class to cast the response to.
     * 
     * @return A list of the requested server entities.
     */
    public static <T> ArrayList<T> get(String path, Class<T> clazz) {
        ArrayList<T> results = null;
        TypeToken<ArrayList<T>> type = new TypeToken<ArrayList<T>>(){};

        try {
            URL url = new URL(host + path);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            results = gson.fromJson(reader.readLine(), type.getType());

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace(); //swallow
        }

        return results;
    }
}
