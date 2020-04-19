package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int memberId;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String nickName;
    private String[] allergie;
}
