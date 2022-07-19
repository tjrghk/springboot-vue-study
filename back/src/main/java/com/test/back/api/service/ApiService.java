package com.test.back.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.back.api.repository.ApiRepository;
import com.test.back.api.request.MembersRequest;
import com.test.back.api.response.MembersResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {
    
    private final ApiRepository apiRepository;

    public List<MembersResponse> getMemberList(MembersRequest memberRequest) {
        return apiRepository.getList(memberRequest)
            .stream()
            .map(member -> new MembersResponse(member)).collect(Collectors.toList());
    }
  
}
