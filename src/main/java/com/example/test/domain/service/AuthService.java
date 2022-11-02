package com.example.test.domain.service;

import com.example.test.application.request.LoginRequest;
import com.example.test.application.response.LoginResponse;
import com.example.test.application.response.MemberResponse;
import com.example.test.application.response.TokenResponse;
import com.example.test.core.security.JwtTokenProvider;
import com.example.test.core.util.Encoder;
import com.example.test.domain.exception.member.MemberNotFoundException;
import com.example.test.domain.exception.member.NotMatchPasswordException;
import com.example.test.domain.model.entity.Member;
import com.example.test.domain.model.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final Encoder encoder;

    public LoginResponse login(LoginRequest loginRequest) throws NotMatchPasswordException {
        Member member = memberRepository.findByMemberId(loginRequest.getMemberId()).orElseThrow(MemberNotFoundException::new);

        if (!encoder.encrypt("SHA-256", loginRequest.getMemberPw()).equals(member.getMemberPw()))
            throw new NotMatchPasswordException();

        MemberResponse memberResponse = new MemberResponse(member);

        String accessToken = jwtTokenProvider.generateJwtToken(member.getMemberId());
        TokenResponse tokenResponse = new TokenResponse(accessToken);

        return new LoginResponse(memberResponse, tokenResponse);
    }
}
