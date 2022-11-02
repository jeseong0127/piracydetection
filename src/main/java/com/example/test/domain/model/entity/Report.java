package com.example.test.domain.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Report")
@Data
@DynamicUpdate
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportNo;

    private int metaSeq;

    private int status;

    private String title;

    private String content;

    private String regId;

    private LocalDateTime regDate;

    private LocalDateTime delDate;

}
