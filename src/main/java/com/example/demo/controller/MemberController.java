package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("login")
    public String login() {
        return "login/login";
    }

    @PostMapping("food/list")
    public String foodList() {
        return "save";
    }


}
