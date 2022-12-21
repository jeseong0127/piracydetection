package com.example.test.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private final MemberDto member;

    private final TokenDto token;
}
