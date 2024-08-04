package com.example.wanted_pre_onboarding_backend.controller;


import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.response.CommonResponse;
import com.example.wanted_pre_onboarding_backend.response.status.SuccessCode;
import com.example.wanted_pre_onboarding_backend.service.RecruitPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/wanted")
public class RecruitPostController {
    private final RecruitPostService recruitPostService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RecruitPostController(RecruitPostService recruitPostService) {
        this.recruitPostService = recruitPostService;
    }

    @PostMapping("/register")
    public CommonResponse register(@RequestBody RecruitPostRequest.RegisterPost request){
        logger.info("request -  companyId: " + request.getCompanyId());
        recruitPostService.register(request);
        return CommonResponse.res(SuccessCode.REGISTER_SUCCESS);
    }

    @PostMapping("/update/{postId}")
    public CommonResponse update(@PathVariable int postId, @RequestBody RecruitPostRequest.UpdatePost request){
        logger.info("request -  postId: " + postId);
        recruitPostService.update(postId, request);
        return CommonResponse.res(SuccessCode.UPDATE_SUCCESS);
    }

}
