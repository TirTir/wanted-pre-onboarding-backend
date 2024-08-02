package com.example.wanted_pre_onboarding_backend.controller;


import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.response.CommonResponse;
import com.example.wanted_pre_onboarding_backend.response.ResponseMessage;
import com.example.wanted_pre_onboarding_backend.response.StatusCode;
import com.example.wanted_pre_onboarding_backend.service.RecruitPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanted")
public class RecruitPostController {
    private final RecruitPostService recruitPostService;

    @Autowired
    public RecruitPostController(RecruitPostService recruitPostService) {
        this.recruitPostService = recruitPostService;
    }

    @PostMapping("/register")
    public CommonResponse register(@RequestBody RecruitPostRequest request){
        recruitPostService.register(request);
        return CommonResponse.res(StatusCode.OK, ResponseMessage.REGISTER_SUCCESS);
    }
}
