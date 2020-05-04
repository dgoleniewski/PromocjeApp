package com.e.promocjeapp;

import android.graphics.Bitmap;

import java.util.Calendar;

public class Discount {
    private String title, description, link, code;
    private int points = 0;
    private double basicPrice, discountPrice;
    private Bitmap image;
    private Calendar endOfDiscountDate, publishDate;

    public Calendar getEndOfDiscountDate() {
        return endOfDiscountDate;
    }

    public void setEndOfDiscountDate(Calendar endOfDiscountDate) {
        this.endOfDiscountDate = endOfDiscountDate;
    }

    public Calendar getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Calendar publishDate) {
        this.publishDate = publishDate;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
