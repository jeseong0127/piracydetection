package com.example.test.domain.model.dto;

import com.example.test.domain.model.entity.Main;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetMainMetadataDto {
    private int mainNo;

    private int metaSeq;

    private String modelName;

    private String highProductCategory;

    private String productCategory;

    private String pathImg;

    private LocalDateTime regDate;

    public GetMainMetadataDto(Main main) {
        this.mainNo = main.getMainNo();
        this.metaSeq = main.getMetadata().getMetaSeq();
        this.modelName = main.getMetadata().getModelName();
        this.highProductCategory = main.getMetadata().getHighProductCategory();
        this.productCategory = main.getMetadata().getProductCategory();
        this.pathImg = main.getMetadata().getPathImg();
        this.regDate = main.getRegDate();
    }
}
