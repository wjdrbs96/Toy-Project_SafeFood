package com.example.demo.controller;

import com.example.demo.dto.DefaultFood;
import com.example.demo.dto.Food;
import com.example.demo.mapper.FoodMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    @Autowired FoodMapper foodMapper;

    @GetMapping("food/detail")
    public String foodDetail(Model model,
                             @RequestParam("code") int code) throws Exception{

        List<JSONObject> list = codeSave.fileReader(code);
        String wt = list.get(1).get("SERVING_WT").toString();
        double serving_wt = Double.parseDouble(wt);
        String nut = list.get(1).get("NUTR_CONT2").toString();
        double nutrition = Double.parseDouble(nut);
        Food food = new Food(list.get(0).get("name").toString(), list.get(0).get("maker").toString(), serving_wt, nutrition, list.get(0).get("material").toString());
        model.addAttribute("foodId", list.get(0).get("code"));
        model.addAttribute("image", list.get(0).get("image"));
        model.addAttribute("food", food);

        return "food/foodDetail";
    }

    @GetMapping("food/list")
    public String foodList(Model model) throws Exception {
        List<JSONArray> array = codeSave.findReaders();

        List<Food> list = new ArrayList<>();

        for (int i = 0; i < 18; ++i) {
            JSONObject jsonObject2 = (JSONObject)array.get(0).get(i);
            JSONObject jso2 = (JSONObject)array.get(1).get(i);
            String wt = jso2.get("SERVING_WT").toString();
            double serving_wt = Double.parseDouble(wt);
            String nut = jso2.get("NUTR_CONT2").toString();
            double nutrition = Double.parseDouble(nut);
            String code = jsonObject2.get("code").toString();
            int foodId = Integer.parseInt(code);
            Food food = new Food(foodId, jsonObject2.get("image"), jsonObject2.get("name").toString(), jsonObject2.get("maker").toString(), serving_wt, nutrition);
            list.add(food);
        }

        model.addAttribute("lists", list);

        return "food/list";
    }

    @GetMapping("food/add")
    public String foodAdd(Model model,
                          @RequestParam("foodId") int foodId,
                          @RequestParam("number") int number) throws Exception {

        List<JSONArray> array = FileRead.findReaders();

        JSONObject jsonObject2 = (JSONObject) array.get(0).get(foodId - 1);
        JSONObject jso2 = (JSONObject) array.get(1).get(foodId - 1);
        String wt = jso2.get("SERVING_WT").toString();
        double serving_wt = Double.parseDouble(wt);
        String nut = jso2.get("NUTR_CONT2").toString();
        double nutrition = Double.parseDouble(nut);
        String code = jsonObject2.get("code").toString();
        int codeId = Integer.parseInt(code);
        Food food = new Food(codeId, jsonObject2.get("name").toString(), jsonObject2.get("maker").toString(), serving_wt, nutrition, jsonObject2.get("material").toString(), number);
        foodMapper.insertFood(food);
        List<Food> orderList = foodMapper.allView();
        model.addAttribute("orderList", orderList);

        return "order/orderList";
    }

    @GetMapping("eat/list")
    public String eatList(Model model) {
        List<Food> orderList = foodMapper.allView();
        model.addAttribute("orderList", orderList);
        return "order/orderList";
    }

    @GetMapping("eat/delete")
    public String eatListDelete(Model model,
                                @RequestParam("foodId") int foodId) {

        foodMapper.eatDelete(foodId);
        List<Food> orderList = foodMapper.allView();
        model.addAttribute("orderList", orderList);
        return "order/orderList";
    }

    @GetMapping("food/search")
    public String foodSearch(@RequestParam("sb") String select,
                             @RequestParam("st") String keyword,
                             Model model) {


        if (select.equals("all")) {

        }

        else if (select.equals("code")) {
            int foodId = Integer.parseInt(keyword);
            DefaultFood defaultFood = foodMapper.findByFoodId(foodId);
            model.addAttribute("food", defaultFood);
        }

        else if (select.equals("name")) {
            DefaultFood defaultFood = foodMapper.findByFoodName(keyword);
            model.addAttribute("food", defaultFood);
        }

        else {
            List<DefaultFood> list = foodMapper.findByMaker(keyword);
            model.addAttribute("lists", list);
            return "food/list";
        }

        return "food/foodOne";
    }
}
