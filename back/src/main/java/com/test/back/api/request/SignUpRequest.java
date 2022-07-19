package com.test.back.api.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SignUpRequest {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String memberId;

    @NotBlank(message = "패스워드를 입력해주세요.")
    private String memberPassword;

    @NotBlank(message = "이름을 입력해주세요.")
    private String memberName;

    @NotBlank(message = "권한을 선택해주세요.")
    private String memberRole;
}
