package com.example.test.domain.model.dto;

import java.time.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetMemberWeekProcessedReportCountDto {
    private final DayOfWeek day;
    private final int count;
}
