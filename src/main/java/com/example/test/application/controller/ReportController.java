package com.example.test.application.controller;

import com.example.test.application.request.DeleteReportRequest;
import com.example.test.application.request.ReportRequest;
import com.example.test.core.security.AuthenticatedMember;
import com.example.test.core.security.MemberInfo;
import com.example.test.domain.service.ReportService;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @ApiOperation("신고 제출하기")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void submitReport(
            @MemberInfo AuthenticatedMember member,
            @ModelAttribute ReportRequest reportRequest
    ) {
        reportService.submitReport(member.getMemberId(), reportRequest);
    }

    @ApiOperation("신고 삭제하기")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteReport(
            @RequestBody DeleteReportRequest reportNo
    ) {
        reportService.deleteReport(reportNo);
    }
}
