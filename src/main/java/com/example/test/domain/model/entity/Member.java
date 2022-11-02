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
@Table(name = "member")
@Data
@DynamicUpdate
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    private String memberId;

    private String memberPw;

    private String memberRole;

    private String memberName;

    private String memberPhone;

    private char useYn;

    private LocalDateTime regDate;

    private LocalDateTime updDate;

    private LocalDateTime delDate;
}
