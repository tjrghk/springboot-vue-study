package com.test.back.api.response;

import java.util.HashMap;


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
public class SignInResponse {
    
    private final HashMap<String, Object> memberInfo = new HashMap<>();
    private String token;

    @Builder
    public SignInResponse(Long memberSeq, String memberId, String memberName, String memberRole, String token) {
        memberInfo.put("memberSeq", memberSeq);
        memberInfo.put("memberId", memberId);
        memberInfo.put("memberName", memberName);
        memberInfo.put("memberRole", memberRole);
       
        this.token = token;
    }
}
