package com.example.alanjames.event.core.events;

import android.util.Log;

import com.example.alanjames.event.core.utils.ConnHttp;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsJSON {

    // API Fake
    private static final String URL = "https://api.myjson.com/bins/tbsxf";
    private ConnHttp conn = new ConnHttp();

    public ArrayList<HashMap<String,Object>> getEvents() {

        Gson gson = new Gson();
        StringBuilder response = conn.makeRequest(URL);

        JsonParser jsonParser = new JsonParser();
        JsonElement json = jsonParser.parse(response.toString());
        JsonElement jElements = json.getAsJsonObject().getAsJsonArray("events");

        ArrayList<HashMap<String,Object>> lEvents = new ArrayList<>();

        for (int i = 0; i < jElements.getAsJsonArray().size(); i++) {
            String element = json.getAsJsonObject().getAsJsonArray("events").get(i).toString();
            HashMap<String, Object> jsonMap = gson.fromJson(element, HashMap.class);
            lEvents.add(jsonMap);
        }

        Log.d("Events", lEvents.toString());
        return lEvents;
    }
}
