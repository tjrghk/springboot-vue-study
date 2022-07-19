package com.test.back.api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.back.api.request.MembersRequest;
import com.test.back.api.response.MembersResponse;
import com.test.back.api.service.ApiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/members")
    public List<MembersResponse> memberList(@ModelAttribute MembersRequest memberRequest) {
        return apiService.getMemberList(memberRequest);
    }
}
