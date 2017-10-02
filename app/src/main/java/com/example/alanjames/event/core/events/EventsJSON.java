package com.example.alanjames.event.core.events;

import android.util.Log;

import com.example.alanjames.event.core.bo.EventsBO;
import com.example.alanjames.event.core.pojo.EventsPOJO;
import com.example.alanjames.event.core.utils.ConnHttp;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class EventsJSON {

    // API Fake
    private static final String URL = "https://api.myjson.com/bins/1dcojh";
    private ConnHttp conn;

    public List<EventsPOJO> getEvents() {

        StringBuilder response = conn.makeRequest(URL);
        Log.w("\n\n>>> RESPONSE: " + response, "<<<\n\n");
        System.out.println(response);
        Gson gson = new Gson();

        List<EventsPOJO> lEvents = (List<EventsPOJO>) gson.fromJson(new String(response), EventsPOJO.class);
/**
        for (int i = 0; i < lEvents.size(); i++) {
            System.out.println(lEvents.get(i).getId());
        }
*/
        return lEvents;
    }
}
