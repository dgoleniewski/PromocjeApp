package com.e.promocjeapp;

import android.graphics.Bitmap;

public class Discount {
    private String title, description, link, code;
    private double basicPrice, discountPrice;
    private String image;
    private String endOfDiscountDate;
    private String publishDate;
    private String id;

    public Discount() {
    }

    public Discount(String title, String description, String link, String code, double basicPrice, double discountPrice, String endOfDiscountDate, String image) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.code = code;
        this.basicPrice = basicPrice;
        this.discountPrice = discountPrice;
        this.endOfDiscountDate = endOfDiscountDate;
        this.image = image;
    }

    public Discount(String title, String description, String link, String code, double basicPrice, double discountPrice, String endOfDiscountDate, String id, String image) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.code = code;
        this.basicPrice = basicPrice;
        this.discountPrice = discountPrice;
        this.endOfDiscountDate = endOfDiscountDate;
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndOfDiscountDate() {
        return endOfDiscountDate;
    }

    public void setEndOfDiscountDate(String endOfDiscountDate) {
        this.endOfDiscountDate = endOfDiscountDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
