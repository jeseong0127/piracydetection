package com.example.test.application.exception;

import com.example.test.core.response.ErrorResponse;
import com.example.test.domain.exception.report.ReportNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ReportExceptionHandler {
    @ExceptionHandler(ReportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleReportNotFound(ReportNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Report-001", exception.getMessage());
    }
}
