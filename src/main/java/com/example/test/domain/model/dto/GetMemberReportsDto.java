package com.example.test.domain.model.dto;

import com.example.test.domain.model.entity.Metadata;
import com.example.test.domain.model.entity.Report;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetMemberReportsDto {
    private final int reportNo;

    private final char status;

    private final String content;

    private final String regId;

    private final LocalDateTime regDate;

    private final String productCategory;

    private final String articleName;

    private final String modelName;

    private final String registrationNumber;

    private final String lastRightHolderName;

    private final String pathImg;

    public GetMemberReportsDto(Report report) {
        this.reportNo = report.getReportNo();
        this.status = report.getStatus();
        this.content = report.getContent();
        this.regId = report.getRegId();
        this.regDate = report.getRegDate();

        Metadata metadata = report.getMetadata();
        this.productCategory = metadata.getProductCategory();
        this.articleName = metadata.getArticleName();
        this.modelName = metadata.getModelName();
        this.registrationNumber = metadata.getRegistrationNumber();
        this.lastRightHolderName = metadata.getLastRightHolderName();
        this.pathImg = metadata.getPathImg();
    }
}