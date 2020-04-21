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

}
