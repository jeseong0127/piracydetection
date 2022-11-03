package com.example.test.application.response;

import com.example.test.domain.model.dto.GetMemberReportsDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberReportsResponse {
    private final List<GetMemberReportsDto> report;
}
