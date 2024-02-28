package com.sharipov.shoppingapp.model;

import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("image")
    private String imege;
    @SerializedName("is_active")
    private String isActive;


    public Banner() {
    }

    public Banner(String imege, String isActive) {
        this.imege = imege;
        this.isActive = isActive;
    }


    public String getImege() {
        return imege;
    }

    public void setImege(String imege) {
        this.imege = imege;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
