package com.sharipov.shoppingapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Product implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("price_current")
    private String currentPrice;
    @SerializedName("price_original")
    private String orginalPrice;
    @SerializedName("made_in")
    private String madeIn;
    @SerializedName("brand")
    private String brand;
    @SerializedName("image")
    private Image image;
//    @SerializedName("image")
//    private String imageUrl;

    public Product() {
    }

    public Product(String id, String title, String description, String currentPrice, String orginalPrice, String madeIn, String brand, Image image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.currentPrice = currentPrice;
        this.orginalPrice = orginalPrice;
        this.madeIn = madeIn;
        this.brand = brand;
        this.image = image;
    }

    //    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }



    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }
    public String getPriceCurrentAsString(){
        DecimalFormat format = new DecimalFormat("###,###,###W");
        String price = format.format(currentPrice);
        return price;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getOrginalPrice() {
        return orginalPrice;
    }
    public String getOrginalPriceAsString(){
        DecimalFormat format = new DecimalFormat("###,###,###W");
        String price = format.format(orginalPrice);
        return price;
    }

    public void setOrginalPrice(String orginalPrice) {
        this.orginalPrice = orginalPrice;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
