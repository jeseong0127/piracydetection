package com.example.test.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberReportCountResponse {
    private final int reportCount;

    private final int processedReportCount;
}
