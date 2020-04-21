package com.example.demo.mapper;

import com.example.demo.dto.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> postAll();
}
