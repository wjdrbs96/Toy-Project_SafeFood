package com.example.demo.controller;

import com.example.demo.dto.Food;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

    @GetMapping("login")
    public String login() {
        return "login/login";
    }


    @PostMapping("login")
    public String login(HttpSession session, String loginId, String password) {
        session.setAttribute("loginId", loginId);
        return "redirect:/food/list";
    }



}
