package com.example.test.application.response;

import com.example.test.domain.model.dto.GetMemberWeekProcessedReportCountDto;
import com.example.test.domain.model.dto.GetMemberWeekReportCountDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberWeekReportCountResponse {
    private final List<GetMemberWeekReportCountDto> reports;

    private final List<GetMemberWeekProcessedReportCountDto> processedReports;
}
