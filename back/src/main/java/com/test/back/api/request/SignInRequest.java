package com.test.back.api.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SignInRequest {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String memberId;

    @NotBlank(message = "패스워드를 입력해주세요.")
    private String memberPassword;
}
