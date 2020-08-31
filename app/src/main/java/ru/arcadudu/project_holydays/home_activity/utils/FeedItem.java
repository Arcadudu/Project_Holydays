package ru.arcadudu.project_holydays.home_activity.utils;

public class FeedItem {

    private int image;
    private String sale, oldPrice, newPrice, description;

    public FeedItem(int image, String sale, String oldPrice, String newPrice, String description) {
        this.image = image;
        this.sale = sale;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
