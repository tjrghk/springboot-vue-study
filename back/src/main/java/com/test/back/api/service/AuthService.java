package com.test.back.api.service;

import org.springframework.stereotype.Service;

import com.test.back.api.entity.Member;
import com.test.back.api.repository.AuthRepository;
import com.test.back.api.request.SignInRequest;
import com.test.back.api.request.SignUpRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final AuthRepository authRepository;

    public Member getMember(SignInRequest signInRequest) {
        return authRepository.findByMemberId(signInRequest.getMemberId())
            .orElseThrow(() -> new IllegalArgumentException("회원 아님!"));
    }

    public Member getMember(Long memberSeq) {
        return authRepository.findByMemberSeq(memberSeq)
            .orElseThrow(() -> new IllegalArgumentException("회원 아님!"));
    }

    public void insertMember(SignUpRequest signUpRequest) {
        Member member = Member.builder()
            .memberId(signUpRequest.getMemberId())
            .memberPassword(signUpRequest.getMemberPassword())
            .memberName(signUpRequest.getMemberName())
            .memberRole(signUpRequest.getMemberRole())
            .build();

        authRepository.save(member);
    }
}
