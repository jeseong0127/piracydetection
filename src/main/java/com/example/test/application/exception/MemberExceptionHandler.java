package com.example.test.application.exception;

import com.example.test.core.response.ErrorResponse;
import com.example.test.domain.exception.member.MemberNotFoundException;
import com.example.test.domain.exception.member.PasswordNotMatchedException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MemberExceptionHandler {
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMemberNotFound(MemberNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Member-001", exception.getMessage());
    }

    @ExceptionHandler(PasswordNotMatchedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleNotMatchPassword(PasswordNotMatchedException exception) {
        return new ErrorResponse(HttpStatus.CONFLICT, "Member-002", exception.getMessage());
    }
}
