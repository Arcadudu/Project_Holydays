package com.example.acropol;

public class Restaurant {
    private String name;
    private String description;
    private int imageResourceId;

    public Restaurant(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static Restaurant[] restaurants = {
            new Restaurant("Акрополь на набережной", "г. Новороссийск, ул. Мира 25", )

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString(){
        return name;
    }
}
