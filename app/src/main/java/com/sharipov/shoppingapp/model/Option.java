package com.sharipov.shoppingapp.model;

import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("id")
    private int id;
    @SerializedName("color_option")
    private String colorOption;
    @SerializedName("size_option")
    private String sizeOption;

    public Option() {
    }

    public Option(int id, String colorOption, String sizeOption) {
        this.id = id;
        this.colorOption = colorOption;
        this.sizeOption = sizeOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorOption() {
        return colorOption;
    }

    public void setColorOption(String colorOption) {
        this.colorOption = colorOption;
    }

    public String getSizeOption() {
        return sizeOption;
    }

    public void setSizeOption(String sizeOption) {
        this.sizeOption = sizeOption;
    }
}
