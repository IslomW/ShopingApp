package com.sharipov.shoppingapp.model;

import com.google.gson.annotations.SerializedName;

public class SizeOption {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;

    public SizeOption() {
    }

    public SizeOption(int id, String title) {
        this.id = id;
        this.title = title;
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
