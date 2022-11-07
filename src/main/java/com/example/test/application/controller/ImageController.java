package com.example.test.application.controller;

import com.example.test.core.security.AuthenticatedMember;
import com.example.test.core.security.MemberInfo;
import com.example.test.domain.service.ImageService;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @ApiOperation(value = "신고 이미지 조회하기")
    @GetMapping(value = "/{reportNo}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] viewImage(
            @MemberInfo AuthenticatedMember member,
            @PathVariable int reportNo
    ) {
        return imageService.viewImage(reportNo, member.getMemberId());
    }

    @ApiOperation(value = "검색 대표 이미지 조회하기")
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] viewThumbnailImage(
            @RequestParam String imagePath
    ) {
        return imageService.viewThumbnailImage(imagePath);
    }
}
