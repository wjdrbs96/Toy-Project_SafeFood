package com.example.demo.controller;

import com.example.demo.dto.Food;
import org.json.simple.JSONObject;

import java.util.List;

public class CodeSearch {

    public static Food foodCodeSearch(int code) throws Exception {
        List<JSONObject> list = codeSave.fileReader(code);
        String wt = list.get(1).get("SERVING_WT").toString();
        double serving_wt = Double.parseDouble(wt);
        String nut = list.get(1).get("NUTR_CONT2").toString();
        double nutrition = Double.parseDouble(nut);
        Food food = new Food(list.get(0).get("name").toString(), list.get(0).get("maker").toString(), serving_wt, nutrition, list.get(0).get("material").toString());
        return food;
    }
}
