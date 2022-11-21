package com.example.test.domain.model.dto;

import com.example.test.domain.model.entity.Metadata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class GetMetadataDto {
    private String type;
    private final int metaSeq;
    private final String productCategory;
    private final String articleName;
    private final String modelName;
    private final String companyName;
    private final String registrationNumber;
    private final String registrationDate;
    private final String applicationNumber;
    private final String applicantName;
    private final String applicantAddress;
    private final String lastRightHolderName;
    private final String pathImg;
    private final String reserveId;
    private final LocalDateTime reserveDate;
    private final String regId;
    private final LocalDateTime regDate;
    private final int imgCount;

    private final String agentName;
    private final String agentAddress;
    private final String agentEmail;
    private final String agentPhone;

    private final LocalDateTime expirationDate;

    public GetMetadataDto(Metadata metadata, String type) {
        LocalDateTime dateTime = null;
        if (metadata.getRegistrationDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dateTime = LocalDateTime.parse(metadata.getRegistrationDate(), formatter);
        }

        this.type = type;
        this.metaSeq = metadata.getMetaSeq();
        this.productCategory = metadata.getProductCategory();
        this.articleName = metadata.getArticleName();
        this.modelName = metadata.getModelName();
        this.companyName = metadata.getCompanyName();
        this.registrationNumber = metadata.getRegistrationNumber();
        this.registrationDate = metadata.getRegistrationDate();
        this.applicationNumber = metadata.getApplicationNumber();
        this.applicantName = metadata.getKpsCompanyName();
        this.applicantAddress = metadata.getAgentAddress();
        this.lastRightHolderName = metadata.getLastRightHolderName();
        this.pathImg = metadata.getPathImg();
        this.reserveId = metadata.getReserveId();
        this.reserveDate = metadata.getReserveDate();
        this.regId = metadata.getRegId();
        this.regDate = metadata.getRegDate();
        this.imgCount = metadata.getImgCount();

        this.agentName = metadata.getAgentName();
        this.agentAddress = metadata.getAgentAddress();
        this.agentEmail = metadata.getAgentEmail();
        this.agentPhone = metadata.getAgentPhone();

        this.expirationDate = dateTime;
    }
}
