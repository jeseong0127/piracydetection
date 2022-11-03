package com.example.test.application.response;

import com.example.test.domain.model.dto.GetMemberWeekReportCountDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberWeekReportCountResponse {
    private final List<GetMemberWeekReportCountDto> reports;
}
