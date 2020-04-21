package com.example.demo.controller;

import com.example.demo.dto.Post;
import com.example.demo.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostMapper postMapper;

    @GetMapping("post/main")
    public String postMain(Model model) {
        List<Post> post = postMapper.postAll();
        model.addAttribute("post", post);

        return "post/noticeList";
    }
}
