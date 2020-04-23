package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Food {
    private int foodId;
    private Object image;
    private String foodName;
    private String manufacturer;
    private double amountPerServings;
    private double amountPerCalorie;
    private String material;

    public Food() {

    }

    public Food(int foodId, Object image, String foodName, String manufacturer, double amountPerServings, double amountPerCalorie) {
        this.foodId = foodId;
        this.image = image;
        this.foodName = foodName;
        this.manufacturer = manufacturer;
        this.amountPerServings = amountPerServings;
        this.amountPerCalorie = amountPerCalorie;
    }


    public Food(String foodName, String manufacturer, double amountPerServings, double amountPerCalorie, String material) {
        this.foodName = foodName;
        this.manufacturer = manufacturer;
        this.amountPerServings = amountPerServings;
        this.amountPerCalorie = amountPerCalorie;
        this.material = material;
    }

    public Food(int foodId, String foodName, String manufacturer, double amountPerServings, double amountPerCalorie, String material) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.manufacturer = manufacturer;
        this.amountPerServings = amountPerServings;
        this.amountPerCalorie = amountPerCalorie;
        this.material = material;
    }
}
