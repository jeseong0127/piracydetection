package com.example.test.domain.exception.report;

public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException() {
        super("존재하지 않는 신고입니다.");
    }
}
