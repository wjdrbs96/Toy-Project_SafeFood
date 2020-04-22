package com.example.demo.mapper;

import com.example.demo.dto.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> postAll();
    void postInsert(Post post);
    Post findByPostId(int postId);
    void postUpdate(String title, String contents, int postId);
    void postDelete(int postId);
}
