package com.example.alanjames.event.core.pojo;

import java.util.Date;

public class EventsPOJO {

    private int id;
    private Date start_at;
    private String title;
    private String vanue;
    private double lat;
    private double lng;
    private String theme_Color;
    private String thumbnail_url;

    public void setVanue(String vanue) {
        this.vanue = vanue;
    }

    public void setThemeColor(String theme_Color) {
        this.theme_Color = theme_Color;
    }

    public void setThumbImg(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(Date start_at) {
        this.start_at = start_at;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public int getId() {
        return id;
    }

    public Date getStart() {
        return start_at;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return thumbnail_url;
    }

    public String getVanue() {
        return vanue;
    }

    public String getThemeColor() {
        return theme_Color;
    }

    public String getThumbImg() {
        return thumbnail_url;
    }
}
