package com.test.back.api.repository;

import java.util.List;

import com.test.back.api.entity.Member;
import com.test.back.api.request.MembersRequest;

public interface ApiRepositoryTemplate {
    List<Member> getList(MembersRequest memberRequest);
}
