package com.sharipov.shoppingapp.model;

import com.google.gson.annotations.SerializedName;

public class Classification {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("is_active")
    private boolean isActive;


    public Classification() {
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
