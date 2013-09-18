package com.casehacks.swipe_android.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
    public static <T> ArrayList<T> get(String path, TypeToken<?> token) {
        ArrayList<T> results = null;

        try {
            URL url = new URL(host + path);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            results = gson.fromJson(read(reader), token.getType());

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace(); //swallow
        }

        return results;
    }

    /**
     * This is a post method for custom urls that allows for posting entities to any url.  Upon
     * receiving s successful response this method will reconstruct the entity as it now exists on
     * the server.
     * 
     * @param path The url extension to post to.
     * @param data The entity which will be posted.
     * @return The entity as it exists after going through the server.
     */
    @SuppressWarnings("unchecked")
	public static <T> T post(String path, T data) {
        T result = null;
        try {
            URL url = new URL(host + path);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write(gson.toJson(data).getBytes());
            os.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            result = (T)gson.fromJson(reader.readLine(), data.getClass());

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace(); //swallow
        }

        return result;
    }

    private static String read(BufferedReader reader) throws IOException {
        String output = "";
        String line = reader.readLine();

        while(line != null && line != "") {
            output = output + line;
            line = reader.readLine();
        }

        return output;
    }
}
