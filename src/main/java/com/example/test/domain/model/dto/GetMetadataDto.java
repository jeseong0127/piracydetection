package com.example.test.domain.model.dto;

import com.example.test.domain.model.entity.Metadata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.Getter;

@Getter
public class GetMetadataDto {
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

    private final LocalDate expirationDate;

    public GetMetadataDto(Metadata metadata) {
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

        this.expirationDate = expirationDate;
    }
}
