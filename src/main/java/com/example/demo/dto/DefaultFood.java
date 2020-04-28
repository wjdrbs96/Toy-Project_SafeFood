package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultFood {
    int foodId;
    String name;
    double amountPerServings;
    String manufacturer;
    double amountPerCalorie;
    String image;
}
