package com.example.demo.controller;

import com.example.demo.dto.Food;
import com.example.demo.dto.Member;
import com.example.demo.dto.Post;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.mapper.PostMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostMapper postMapper;

    @Autowired
    MemberMapper memberMapper;

    @GetMapping("post/main")
    public String postMain(Model model) {
        List<Post> post = postMapper.postAll();
        model.addAttribute("post", post);

        return "post/noticeList";
    }

    @GetMapping("post/write")
    public String postWrite() {
        return "post/noticeWrite";
    }

    @PostMapping("post/write")
    public String postWrite(HttpSession session,
                            @RequestParam("title") String title,
                            @RequestParam("contents") String contents) {

        String loginId = (String)session.getAttribute("loginId");
        Member member = memberMapper.findByLoginId(loginId);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Post post = new Post(contents, member.getMemberId(), sdf.format(date), sdf.format(date), member.getNickName(), title);
        postMapper.postInsert(post);

        return "redirect:/post/main";
    }

    @GetMapping("post/edit")
    public String postEdit(Model model,
                           @RequestParam("postId") int postId) {

        Post post = postMapper.findByPostId(postId);
        model.addAttribute("post", post);
        return "post/noticeEdit";
    }

    @PostMapping("post/update")
    public String postUpdate(@RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("postId") int postId) {

        postMapper.postUpdate(title, contents, postId);
        return "redirect:/post/main";
    }

    @GetMapping("post/delete")
    public String postDelete(@RequestParam("postId") int postId) {
        postMapper.postDelete(postId);

        return "redirect:/post/main";
    }

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
        Food food = new Food(jsonObject2.get("name"), jsonObject2.get("image"), jsonObject2.get("maker"), jso2.get("SERVING_WT"), jso2.get("NUTR_CONT2"), jsonObject2.get("marterial"));

        model.addAttribute("food", food);

        return "food/foodDetail";
    }
}
