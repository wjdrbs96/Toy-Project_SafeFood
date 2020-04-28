package com.example.demo.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.ui.Model;
import sun.applet.Main;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class codeSave {
    public static List<JSONArray> codeSaver() throws Exception {
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

    public static List<JSONObject> fileReader(int code) throws Exception {
        List<JSONArray> list = codeSaver();
        List<JSONObject> jsonObjects = new ArrayList<>();
        JSONObject jsonObject2 = (JSONObject)list.get(0).get(code - 1);
        JSONObject jso2 = (JSONObject)list.get(1).get(code - 1);
        jsonObjects.add(jsonObject2);
        jsonObjects.add(jso2);

        return jsonObjects;
    }

    public static String fileReader(String name) throws Exception {
        List<JSONArray> list = codeSaver();

        for (int i = 0; i < 20; ++i) {
            JSONObject jsonObject2 = (JSONObject)list.get(0).get(i - 1);

            if (jsonObject2.get("name").toString().equals(name)) {
                return jsonObject2.get("name").toString();
            }
        }

        return null;
    }


    public static List<JSONArray> findReaders() throws Exception{
        List<JSONArray> jsonObjects = codeSaver();
        return jsonObjects;
    }



}
