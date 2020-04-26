package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

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

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }



}
