package com.example.test.domain.model.dto;

import com.example.test.domain.model.entity.Metadata;
import com.example.test.domain.model.entity.Report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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

    private final String registrationDate;

    private final String applicantName;

    private final String applicantAddress;

    private final String agentName;

    private final String agentAddress;

    private final LocalDate expirationDate;

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

        this.registrationDate = metadata.getRegistrationDate();
        this.applicantName = metadata.getKpsCompanyName();
        this.applicantAddress = metadata.getApplicantAddress();
        this.agentName = metadata.getAgentName();
        this.agentAddress = metadata.getAgentAddress();

        LocalDate expirationDate = null;
        if (metadata.getRegistrationDate() != null) {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = dateformat.parse(metadata.getRegistrationDate().replaceAll("\\.", "-"));
                expirationDate = date.toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .plusYears(15);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        this.expirationDate = expirationDate;
    }
}