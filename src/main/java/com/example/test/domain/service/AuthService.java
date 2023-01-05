package com.example.test.domain.service;

import com.example.test.application.response.LoginResponse;
import com.example.test.core.security.JwtTokenProvider;
import com.example.test.core.util.Encoder;
import com.example.test.domain.exception.member.MemberNotFoundException;
import com.example.test.domain.exception.member.PasswordNotMatchedException;
import com.example.test.domain.model.dto.MemberDto;
import com.example.test.domain.model.dto.TokenDto;
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

    public LoginResponse login(String memberId, String memberPw) {
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(MemberNotFoundException::new);

        if (!encoder.encrypt("SHA-256", memberPw).equals(member.getMemberPw()))
            throw new PasswordNotMatchedException();

        MemberDto memberDto = new MemberDto(memberId, member.getMemberName());

        String accessToken = jwtTokenProvider.generateJwtToken(memberId, member.getMemberRole());
        TokenDto tokenDto = new TokenDto(accessToken);

        return new LoginResponse(memberDto, tokenDto);
    }
}
