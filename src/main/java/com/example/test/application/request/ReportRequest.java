package com.example.test.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class ReportRequest {
    private int metaSeq;

    private MultipartFile image;

    private String content;
}
