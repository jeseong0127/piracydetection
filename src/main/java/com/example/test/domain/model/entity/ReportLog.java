package com.example.test.domain.model.entity;

import com.example.test.application.request.ReportRequest;

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

    public ReportLog(String memberId, ReportRequest reportRequest, Metadata metadata) {
        this.metadata = metadata;
        this.status = 'P';
        this.content = reportRequest.getContent();
        this.regId = memberId;
        this.regDate = LocalDateTime.now();
    }

    public ReportLog(String memberId, Report report, char type) {
        this.metadata = report.getMetadata();
        this.status = type;
        this.content = report.getContent();
        this.regId = memberId;
        this.regDate = LocalDateTime.now();
    }

    public ReportLog(Report report, char type) {
        this.metadata = report.getMetadata();
        this.status = type;
        this.content = report.getContent();
        this.regDate = LocalDateTime.now();
    }
}
