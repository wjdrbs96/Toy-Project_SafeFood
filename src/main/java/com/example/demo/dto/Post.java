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

    public Post() {

    }

    public Post(String content, int memberId, String createDateTime, String updateTime, String writer, String title) {
        this.content = content;
        this.memberId = memberId;
        this.createDateTime = createDateTime;
        this.updateTime = updateTime;
        this.writer = writer;
        this.title = title;
    }

    public Post(int postId, String content, int memberId, String createDateTime, String updateTime, String writer, String title) {
        this.postId = postId;
        this.content = content;
        this.memberId = memberId;
        this.createDateTime = createDateTime;
        this.updateTime = updateTime;
        this.writer = writer;
        this.title = title;
    }
}
