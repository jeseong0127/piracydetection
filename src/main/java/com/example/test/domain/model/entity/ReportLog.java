package com.example.test.domain.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "report_log")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class ReportLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportNo;

    @ManyToOne
    @JoinColumn(name = "META_SEQ")
    @ToString.Exclude
    private Metadata metadata;

    private char status;

    private String title;

    private String content;

    private String regId;

    private LocalDateTime regDate;

    private LocalDateTime delDate;
}
