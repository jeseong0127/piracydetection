package com.example.test.application.controller;

import com.example.test.application.response.MemberReportsResponse;
import com.example.test.core.security.AuthenticatedMember;
import com.example.test.core.security.MemberInfo;
import com.example.test.domain.service.MemberService;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ApiOperation("내 신고 내역 가져오기")
    @GetMapping("/reports")
    @ResponseStatus(HttpStatus.OK)
    public MemberReportsResponse getMemberReports(
            @MemberInfo AuthenticatedMember member
    ) {
        return new MemberReportsResponse(memberService.getMemberReports(member.getMemberId()));
    }

}