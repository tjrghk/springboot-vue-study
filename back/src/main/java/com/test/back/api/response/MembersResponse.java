package com.test.back.api.response;

import com.test.back.api.entity.Member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@Getter
@Setter
public class MembersResponse {
    private Long memberSeq;
    private String memberId;
    private String memberName;
    private String memberRole;
   
    public MembersResponse(Member member) {
        this.memberSeq = member.getMemberSeq();
        this.memberId = member.getMemberId();
        this.memberName = member.getMemberName();
        this.memberRole = member.getMemberRole();
    }

    @Builder
    public MembersResponse(Long memberSeq, String memberId, String memberName, String memberRole) {
        this.memberSeq = memberSeq;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberRole = memberRole;
    }
}
