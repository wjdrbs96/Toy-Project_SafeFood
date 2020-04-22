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
import java.text.SimpleDateFormat;
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


}
