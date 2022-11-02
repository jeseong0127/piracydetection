package com.example.test.domain.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "image")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageNo;

    private int metaSeq;

    private String imageName;

    private String imagePath;

    private String imageSize;

    private String imageType;

    private char isDeleted;

    private String regId;

    private LocalDateTime regDate;

    public Image(String memberId, int metaSeq, String imagePath, String imageName, String fileSize, String fileType) {
        this.metaSeq = metaSeq;
        this.imageName = imagePath;
        this.imagePath = imageName;
        this.imageSize = fileSize;
        this.imageType = fileType;
        this.regId = memberId;
        this.regDate = LocalDateTime.now();
    }
}
