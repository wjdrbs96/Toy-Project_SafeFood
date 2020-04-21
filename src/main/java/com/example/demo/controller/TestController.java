package com.example.demo.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

@RestController
public class TestController {

    @GetMapping("test/json")
    public String Test() throws IOException, ParseException {

        String foodInfoUrl = "C:/JSON/foodInfo.json";
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(foodInfoUrl));

        JSONObject jsonObject1 = (JSONObject)jsonObject.get("foods");
        JSONArray jsonArray = (JSONArray)jsonObject1.get("food");

        JSONObject jsonObject2 = (JSONObject)jsonArray.get(0);
        System.out.println(jsonObject2.toString());

        return "d";
    }
}
