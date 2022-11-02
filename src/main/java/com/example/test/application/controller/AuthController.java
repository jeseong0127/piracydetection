package com.example.test.application.controller;

import com.example.test.application.request.LoginRequest;
import com.example.test.application.response.LoginResponse;
import com.example.test.domain.exception.member.NotMatchPasswordException;
import com.example.test.domain.service.AuthService;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ApiOperation("로그인")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(
            @RequestBody LoginRequest loginRequest
    ) throws NotMatchPasswordException {
        return authService.login(loginRequest);
    }

}
