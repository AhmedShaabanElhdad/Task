package com.example.taskapp.network;

public class Data{

    String brand, constructionYear,imageUrl;
    int id;
    boolean isUsed;


    public Data(String brand, String constructionYear, String imageUrl, int id, boolean isUsed) {
        this.brand = brand;
        this.constructionYear = constructionYear;
        this.imageUrl = imageUrl;
        this.id = id;
        this.isUsed = isUsed;
    }

    public String getBrand() {
        return brand;
    }

    public String getConstructionYear() {
        return constructionYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public boolean isUsed() {
        return isUsed;
    }
}