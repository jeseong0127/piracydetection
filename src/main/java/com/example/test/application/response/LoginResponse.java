package com.example.test.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private final MemberResponse member;

    private final TokenResponse token;
}
