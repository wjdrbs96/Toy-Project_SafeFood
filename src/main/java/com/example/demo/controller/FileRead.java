package com.example.demo.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileRead {

    public static List<JSONObject> fileReader(int code) throws Exception {
        List<JSONObject> list = new ArrayList<>();

        String foodInfoUrl = "C:/JSON/foodInfo.json";
        String foodNutUrl = "C:/JSON/foodNutritionInfo.json";

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(foodInfoUrl));
        JSONObject jso = (JSONObject)parser.parse(new FileReader(foodNutUrl));

        JSONObject jsonObject1 = (JSONObject)jsonObject.get("foods");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("food");
        JSONObject jso1 = (JSONObject)jso.get("items");
        JSONArray jsa1 = (JSONArray)jso1.get("item");

        JSONObject jsonObject2 = (JSONObject)jsonArray.get(code - 1);
        JSONObject jso2 = (JSONObject)jsa1.get(code - 1);
        list.add(jsonObject2);
        list.add(jso2);

        return list;
    }

    public static List<JSONArray> findReaders() throws Exception{
        List<JSONArray> list = new ArrayList<>();

        String foodInfoUrl = "C:/JSON/foodInfo.json";
        String foodNutUrl = "C:/JSON/foodNutritionInfo.json";

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(foodInfoUrl));
        JSONObject jso = (JSONObject)parser.parse(new FileReader(foodNutUrl));

        JSONObject jsonObject1 = (JSONObject)jsonObject.get("foods");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("food");
        JSONObject jso1 = (JSONObject)jso.get("items");
        JSONArray jsa1 = (JSONArray)jso1.get("item");
        list.add(jsonArray);
        list.add(jsa1);
        return list;
    }

}