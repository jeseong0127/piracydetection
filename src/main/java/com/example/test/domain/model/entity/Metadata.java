package com.example.test.domain.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "metadata")
@Getter
@Setter
@DynamicUpdate
@RequiredArgsConstructor
public class Metadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int metaSeq;

    private String highProductCategory;

    private String productCategory;

    private String articleName;

    private String modelName;

    private String companyName;

    private String kpsCompanyName;

    private String registrationNumber;

    private String registrationDate;

    private String applicationNumber;

    private String applicantAddress;

    @Column(name = "LASTRIGHT_HOLDERNAME")
    private String lastRightHolderName;

    private String pathImg;

    private String pathImgGoods;

    @Column(name = "RESERV_ID")
    private String reserveId;

    @Column(name = "RESERV_DATE")
    private LocalDateTime reserveDate;

    private String regId;

    private String regName;

    private LocalDateTime regDate;

    private int imgCount;

    private char useYn;

    @Column(name = "SUBSCRIPTION")
    private String subScription;

    @Column(name = "DSSHPCLSSCD")
    private String dsshpclsscd;

    private String agentName;

    private String agentAddress;

}
