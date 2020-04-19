package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food {
    private int foodId;
    private String foodName;
    private String manufacturer;
    private int amountPerServings;
    private int amountPerCalorie;
}
