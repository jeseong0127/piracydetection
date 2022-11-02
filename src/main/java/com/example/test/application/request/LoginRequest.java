package com.example.test.application.request;

import lombok.Data;

@Data
public class LoginRequest {
    private final String memberId;
    private final String memberPw;
}
