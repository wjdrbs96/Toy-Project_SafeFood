package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired MemberMapper memberMapper;

    @GetMapping("login")
    public String login() {
        return "login/login";
    }


    @PostMapping("login")
    public String login(Model model,
                        HttpSession session, String loginId, String password) {

        session.setAttribute("loginId", loginId);
        String pwd = memberMapper.loginCheck(loginId);
        String errorMsg = "";

        if (pwd == null) {
            errorMsg = "아이디가 존재하지 않습니다";
            model.addAttribute("errorMsg", errorMsg);
            return "login/login";
        }
        else if (!pwd.equals(password)) {
            errorMsg = "입력하신 정보가 맞지 않습니다";
            model.addAttribute("errorMsg", errorMsg);
            return "login/login";
        }

        return "redirect:/food/list";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("register")
    public String register() {
        return "login/signUp";
    }

    @PostMapping("register")
    public String register(Model model,
                           Member member){
        String errorId = "";
        String errorPw = "";
        String errorName = "";
        String errorEmail = "";
        String errorNickName = "";


        if (member.getLoginId() == null || member.getLoginId().length() == 0) {
            errorId = "사용자 아이디를 입력하세요";
            model.addAttribute("errorId", errorId);
        }
        else if (member.getPassword() == null || member.getPassword().length() == 0) {
            errorPw = "비밀번호1를 입력하세요";
            model.addAttribute("errorPw", errorPw);
        }

        else if (member.getName() == null || member.getName().length() == 0) {
            errorName = "이름을 입력하세요";
            model.addAttribute("errorName", errorName);
        }
        else if (member.getNickName() == null || member.getNickName().length() == 0) {
            errorNickName = "닉네임을 입력하세요";
            model.addAttribute("errorNickName", errorNickName);
        }

        else if (member.getEmail() == null || member.getEmail().length() == 0) {
            errorEmail = "이메일 주소를 입력하세요";
            model.addAttribute("errorEmail", errorEmail);

        }
        else {
            memberMapper.registerMember(member);
            return "login/login";
        }

        return "login/signUp";
    }



}
