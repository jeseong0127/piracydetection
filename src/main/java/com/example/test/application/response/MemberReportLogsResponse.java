package com.example.test.application.response;

import com.example.test.domain.model.dto.GetMemberReportLogsDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberReportLogsResponse {
    private List<GetMemberReportLogsDto> logs;
}
