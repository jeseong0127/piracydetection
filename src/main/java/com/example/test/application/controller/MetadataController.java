package com.example.test.application.controller;

import com.example.test.application.response.MetadataResponse;
import com.example.test.domain.service.MetadataService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metadata")
@RequiredArgsConstructor
public class MetadataController {
    private final MetadataService metadataService;

    @ApiOperation("메타데이터 이미지 검색")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MetadataResponse getMetadata(
            @RequestParam(required = false) List<String> images
    ) {
            return new MetadataResponse(metadataService.getImageSearchMetadata(images));
    }
}
