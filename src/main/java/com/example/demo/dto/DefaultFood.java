package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultFood {
    int foodId;
    String foodName;
    double amountPerServings;
    String manufacturer;
    double amountPerCalorie;
    String image;
}
