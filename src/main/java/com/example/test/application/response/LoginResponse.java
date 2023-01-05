package com.example.test.application.response;

import com.example.test.domain.model.dto.MemberDto;
import com.example.test.domain.model.dto.TokenDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private final MemberDto member;

    private final TokenDto token;
}
