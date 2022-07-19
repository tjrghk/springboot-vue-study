package com.test.back.api.repository;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.back.api.entity.Member;
import com.test.back.api.entity.QMember;
import com.test.back.api.request.MembersRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiRepositoryImpl implements ApiRepositoryTemplate {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> getList(MembersRequest memberRequest) {
        return jpaQueryFactory.selectFrom(QMember.member)
            .limit(memberRequest.getSize())
            .offset(memberRequest.getOffset())
            .orderBy(QMember.member.memberSeq.desc())
            .fetch();
    }
    

   
    
    
}
