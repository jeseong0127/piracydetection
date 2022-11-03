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

    private final int status;

    private final String content;

    private final String regId;

    private final LocalDateTime regDate;

    private final String productCategory;

    private final String articleName;

    private final String modelName;

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
    }
}