package com.example.test.domain.service;

import com.example.test.application.response.MemberReportCountResponse;
import com.example.test.application.response.MemberWeekReportCountResponse;
import com.example.test.domain.model.dto.GetMemberReportsDto;
import com.example.test.domain.model.dto.GetMemberWeekProcessedReportCountDto;
import com.example.test.domain.model.dto.GetMemberWeekReportCountDto;
import com.example.test.domain.model.repository.ReportRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final ReportRepository reportRepository;

    public List<GetMemberReportsDto> getMemberReports(String memberId) {
        return reportRepository.findAllByRegId(memberId).stream()
                .map(GetMemberReportsDto::new)
                .collect(Collectors.toList());
    }

    public MemberReportCountResponse getMemberReportCount(String memberId) {
        return new MemberReportCountResponse(reportRepository.countByRegId(memberId), reportRepository.countByRegIdAndStatus(memberId, 1));
    }

    public MemberWeekReportCountResponse getMemberWeekReportCount(String memberId) {
        List<GetMemberWeekReportCountDto> reports = new ArrayList<>();
        List<GetMemberWeekProcessedReportCountDto> processedReports = new ArrayList<>();

        LocalDate now = LocalDate.now();
        LocalTime from = LocalTime.of(0, 0, 0);
        LocalTime to = LocalTime.of(23, 59, 59);

        for (int i = 0; i < 7; i++) {
            LocalDateTime start = LocalDateTime.of(now.minusDays(i), from);
            LocalDateTime end = LocalDateTime.of(now.minusDays(i), to);

            reports.add(new GetMemberWeekReportCountDto(start.getDayOfWeek(), reportRepository.countByRegIdAndStatusAndRegDateBetween(memberId, 0, start, end)));
            processedReports.add(new GetMemberWeekProcessedReportCountDto(start.getDayOfWeek(), reportRepository.countByRegIdAndStatusAndRegDateBetween(memberId, 1, start, end)));
        }

        return new MemberWeekReportCountResponse(reports, processedReports);
    }
}