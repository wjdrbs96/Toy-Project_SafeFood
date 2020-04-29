package com.example.demo.mapper;

import com.example.demo.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findByLoginId(String loginId);
    void registerMember(Member member);
    String loginCheck(String loginId);
    int checkLoginId(String loginId);
    String findPassword(String loginId, String name);
}
