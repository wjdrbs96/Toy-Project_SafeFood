package com.example.demo.controller;

import com.example.demo.dto.Food;
import com.example.demo.mapper.FoodMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    @Autowired FoodMapper foodMapper;

    @GetMapping("food/detail")
    public String foodDetail(Model model,
                             @RequestParam("code") int code) throws Exception{

        String foodInfoUrl = "C:/JSON/foodInfo.json";
        String foodNutUrl = "C:/JSON/foodNutritionInfo.json";

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(foodInfoUrl));
        JSONObject jso = (JSONObject)parser.parse(new FileReader(foodNutUrl));

        JSONObject jsonObject1 = (JSONObject)jsonObject.get("foods");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("food");
        JSONObject jso1 = (JSONObject)jso.get("items");
        JSONArray jsa1 = (JSONArray)jso1.get("item");


        JSONObject jsonObject2 = (JSONObject)jsonArray.get(code);
        JSONObject jso2 = (JSONObject)jsa1.get(code);
        Food food = new Food(jsonObject2.get("name"), jsonObject2.get("maker"), jso2.get("SERVING_WT"), jso2.get("NUTR_CONT2"), jsonObject2.get("material"));
        model.addAttribute("foodId", jsonObject2.get("code"));
        model.addAttribute("image", jsonObject2.get("image"));
        model.addAttribute("food", food);

        return "food/foodDetail";
    }

    @GetMapping("food/list")
    public String foodList(Model model) throws Exception {
        String foodInfoUrl = "C:/JSON/foodInfo.json";
        String foodNutUrl = "C:/JSON/foodNutritionInfo.json";

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(foodInfoUrl));
        JSONObject jso = (JSONObject)parser.parse(new FileReader(foodNutUrl));

        JSONObject jsonObject1 = (JSONObject)jsonObject.get("foods");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("food");
        JSONObject jso1 = (JSONObject)jso.get("items");
        JSONArray jsa1 = (JSONArray)jso1.get("item");

        List<Food> list = new ArrayList<>();

        for (int i = 0; i < 9; ++i) {
            JSONObject jsonObject2 = (JSONObject)jsonArray.get(i);
            JSONObject jso2 = (JSONObject)jsa1.get(i);
            Food food = new Food(jsonObject2.get("code"), jsonObject2.get("image"), jsonObject2.get("name"), jsonObject2.get("maker"), jso2.get("SERVING_WT"), jso2.get("NUTR_CONT2"));
            list.add(food);
        }

        model.addAttribute("lists", list);

        return "food/list";
    }

    @GetMapping("food/add")
    public String foodAdd(Model model,
                          @RequestParam("foodId") int foodId) throws Exception {
        String foodInfoUrl = "C:/JSON/foodInfo.json";
        String foodNutUrl = "C:/JSON/foodNutritionInfo.json";

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(foodInfoUrl));
        JSONObject jso = (JSONObject) parser.parse(new FileReader(foodNutUrl));

        JSONObject jsonObject1 = (JSONObject) jsonObject.get("foods");
        JSONArray jsonArray = (JSONArray) jsonObject1.get("food");
        JSONObject jso1 = (JSONObject) jso.get("items");
        JSONArray jsa1 = (JSONArray) jso1.get("item");


        JSONObject jsonObject2 = (JSONObject) jsonArray.get(foodId);
        JSONObject jso2 = (JSONObject) jsa1.get(foodId);
        Food food = new Food(jsonObject2.get("name"), jsonObject2.get("image"), jsonObject2.get("maker"), jso2.get("SERVING_WT"), jso2.get("NUTR_CONT2"), jsonObject2.get("material"));
        foodMapper.insertFood(food);

        List<Food> orderList = foodMapper.allView();
        model.addAttribute("orderList", orderList);

        return "order/orderList";
    }
}
