package com.example.test.domain.model.dto;

import com.example.test.domain.model.entity.Metadata;
import com.example.test.domain.model.entity.ReportLog;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetMemberReportLogsDto {

    private int reportNo;

    private String content;

    private char status;

    private LocalDateTime regDate;

    private int metaSeq;

    private final String productCategory;

    private final String modelName;

    private final String registrationNumber;

    private final String lastRightHolderName;

    public GetMemberReportLogsDto(ReportLog reportLog) {

        this.reportNo = reportLog.getReportNo();
        this.content = reportLog.getContent();
        this.status = reportLog.getStatus();
        this.regDate = reportLog.getRegDate();

        Metadata metadata = reportLog.getMetadata();
        this.productCategory = metadata.getProductCategory();
        this.metaSeq = metadata.getMetaSeq();
        this.modelName = metadata.getModelName();
        this.registrationNumber = metadata.getRegistrationNumber();
        this.lastRightHolderName = metadata.getLastRightHolderName();
    }
}
