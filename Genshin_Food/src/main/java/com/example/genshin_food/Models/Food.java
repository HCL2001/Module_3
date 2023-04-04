package com.example.genshin_food.Models;

public class Food {


    private int idFood;
    private String nameFood;
    private String descriptionFood;
    private String imgFood;

    private String countryFood;
    private int priceFood;

    public String getCountryFood() {
        return countryFood;
    }

    public void setCountryFood(String countryFood) {
        this.countryFood = countryFood;
    }

    public Food(int idFood, String nameFood, String descriptionFood, int priceFood, String countryFood, String imgFood) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.descriptionFood = descriptionFood;
        this.priceFood = priceFood;
        this.countryFood = countryFood;
        this.imgFood = imgFood;
    }

    public Food() {
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getDescriptionFood() {
        return descriptionFood;
    }

    public void setDescriptionFood(String descriptionFood) {
        this.descriptionFood = descriptionFood;
    }

    public String getImgFood() {
        return imgFood;
    }

    public void setImgFood(String imgFood) {
        this.imgFood = imgFood;
    }

    public int getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(int priceFood) {
        this.priceFood = priceFood;
    }
}
