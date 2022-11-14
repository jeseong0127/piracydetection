package com.example.test.domain.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "main")
@Getter
@Setter
@DynamicUpdate
@RequiredArgsConstructor
public class Main {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mainNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "META_SEQ")
    @ToString.Exclude
    private Metadata metadata;

    private LocalDateTime regDate;
}
