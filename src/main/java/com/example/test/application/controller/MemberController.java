package com.example.test.application.controller;

import com.example.test.application.response.MemberReportCountResponse;
import com.example.test.application.response.MemberReportLogsResponse;
import com.example.test.application.response.MemberReportsResponse;
import com.example.test.application.response.MemberWeekReportCountResponse;
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

    @ApiOperation("내 신고 개수 가져오기")
    @GetMapping("/reports/count")
    @ResponseStatus(HttpStatus.OK)
    public MemberReportCountResponse getMemberReportCount(
            @MemberInfo AuthenticatedMember member
    ) {
        return memberService.getMemberReportCount(member.getMemberId());
    }

    @ApiOperation("일주일 신고내역 가져오기")
    @GetMapping("/week-reports")
    @ResponseStatus(HttpStatus.OK)
    public MemberWeekReportCountResponse getMemberWeekReportCount(
            @MemberInfo AuthenticatedMember member
    ) {
        return memberService.getMemberWeekReportCount(member.getMemberId());
    }

    @ApiOperation("내 신고 기록 가져오기")
    @GetMapping("/reports/logs")
    @ResponseStatus(HttpStatus.OK)
    public MemberReportLogsResponse getReportLogs(
            @MemberInfo AuthenticatedMember member
    ) {
        return memberService.getReportLogs(member.getMemberId());
    }
}
