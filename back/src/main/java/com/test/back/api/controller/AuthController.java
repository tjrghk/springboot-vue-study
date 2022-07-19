package com.test.back.api.controller;


import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.back.api.entity.Member;
import com.test.back.api.provider.JwtTokenProvider;
import com.test.back.api.request.SignInRequest;
import com.test.back.api.request.SignUpRequest;
import com.test.back.api.response.SignInResponse;
import com.test.back.api.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signIn")
    public SignInResponse login(@RequestBody @Valid SignInRequest signInRequest) {
        Member member = authService.getMember(signInRequest);
        
        if (!bCryptPasswordEncoder.matches(signInRequest.getMemberPassword(), member.getMemberPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return SignInResponse.builder()
            .memberSeq(member.getMemberSeq())
            .memberId(member.getMemberId())
            .memberName(member.getMemberName())
            .memberRole(member.getMemberRole())
            .token(jwtTokenProvider.createToken(member.getMemberSeq(), member.getMemberRole()))
            .build();
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        request.setMemberPassword(bCryptPasswordEncoder.encode(request.getMemberPassword())); 
        authService.insertMember(request); 
    }
    
}
