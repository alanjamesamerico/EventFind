package com.example.alanjames.event.core.utils;

import android.util.Log;

import com.example.alanjames.event.core.bo.EventsBO;
import com.example.alanjames.event.core.pojo.EventsPOJO;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConnHttp {

    final StringBuilder result = new StringBuilder();
    private List<EventsPOJO> lEvents = new ArrayList<EventsPOJO>();
    private Gson gson = new Gson();

    public StringBuilder makeRequest(String urlRquest){
        HttpURLConnection urlConnection = null;
        try {

            URL url = new URL("https://api.myjson.com/bins/1dcojh");
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
                Log.w("\n\n>>> Current: " + current, "<<<\n\n");

                //EventsPOJO event = gson.fromJson(String.valueOf(current), EventsPOJO.class);
               // lEvents.add(event);

                result.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace(); //If you want further info on failure...
            }
        }
        return result;
    }
}
