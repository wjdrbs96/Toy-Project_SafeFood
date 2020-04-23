package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Food {
    private Object foodId;
    private Object image;
    private Object foodName;
    private Object manufacturer;
    private Object amountPerServings;
    private Object amountPerCalorie;
    private Object material;

    public Food() {

    }

    public Food(Object foodId, Object image, Object foodName, Object manufacturer, Object amountPerServings, Object amountPerCalorie) {
        this.foodId = foodId;
        this.image = image;
        this.foodName = foodName;
        this.manufacturer = manufacturer;
        this.amountPerServings = amountPerServings;
        this.amountPerCalorie = amountPerCalorie;
    }


    public Food(Object foodName, Object manufacturer, Object amountPerServings, Object amountPerCalorie, Object material) {
        this.foodName = foodName;
        this.manufacturer = manufacturer;
        this.amountPerServings = amountPerServings;
        this.amountPerCalorie = amountPerCalorie;
        this.material = material;
    }
}
