package com.example.test.domain.service;

import com.example.test.application.response.MemberReportCountResponse;
import com.example.test.domain.model.dto.GetMemberReportsDto;
import com.example.test.domain.model.repository.ReportRepository;

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
}