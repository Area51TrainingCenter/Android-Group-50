package com.jcodee.clase06.net.response.album;

import com.google.gson.annotations.SerializedName;

public class Album {
    private int userId;
    private int id;
    @SerializedName("title")
    private String title;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
