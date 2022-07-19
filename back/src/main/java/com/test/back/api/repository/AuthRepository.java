package com.test.back.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.back.api.entity.Member;

public interface AuthRepository extends JpaRepository<Member, Long> {

    public Optional<Member> findByMemberId(String memberId);

    public Optional<Member> findByMemberSeq(Long memberSeq);
}