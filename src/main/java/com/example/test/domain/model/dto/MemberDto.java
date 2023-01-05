package com.example.test.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberDto {
    private final String memberId;

    private final String memberName;
}
