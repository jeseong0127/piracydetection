package com.example.test.application.controller;

import com.example.test.application.response.MainMetadataResponse;
import com.example.test.domain.service.MainService;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @ApiOperation("메인 메타데이터 리스트 가져오기")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MainMetadataResponse getMainMetadata(
    ) {
        return new MainMetadataResponse(mainService.getMainMetadata());
    }
}
