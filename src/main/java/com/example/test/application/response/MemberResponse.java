package com.example.test.application.response;

import com.example.test.domain.model.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberResponse {
    private final String memberId;

    private final String memberName;

    public MemberResponse(Member member) {
        this.memberId = member.getMemberId();
        this.memberName = member.getMemberName();
    }
}
