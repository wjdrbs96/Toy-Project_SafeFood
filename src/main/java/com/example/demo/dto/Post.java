package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Post {
    int postId;
    String content;
    int memberId;
    String createDateTime;
    String updateTime;
    String writer;
    String title;

}
