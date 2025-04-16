package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Main {

    static Map<String, String> env = System.getenv();
    static String myAPIKEY = env.get("EBIRD_API_KEY");

    public static void main(String[] args) throws IOException {

        /*for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }*/

        Gson gson = new Gson();

    }



        public static String getHotSpotInfo(String locationID) throws IOException{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://api.ebird.org/v2/ref/hotspot/info/L2619655")
                    .method("GET",null) //cannot have body even though API doc says to
                    .addHeader("X-eBirdApiToken", myAPIKEY)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                assert response.body() != null;


                return response.body().string();

            }

    }


}