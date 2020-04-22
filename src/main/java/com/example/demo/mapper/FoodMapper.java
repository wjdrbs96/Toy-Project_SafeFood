package com.example.demo.mapper;

import com.example.demo.dto.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    void insertFood(Food food);
    List<Food> allView();
}
