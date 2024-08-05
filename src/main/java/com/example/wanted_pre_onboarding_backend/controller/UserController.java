package com.example.wanted_pre_onboarding_backend.controller;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.dto.UserRequest;
import com.example.wanted_pre_onboarding_backend.response.CommonResponse;
import com.example.wanted_pre_onboarding_backend.response.status.SuccessCode;
import com.example.wanted_pre_onboarding_backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping({"/wanted", "/wanted/"})
public class UserController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/apply")
    public CommonResponse apply(@RequestBody UserRequest.ApplyPost request){
        logger.info("request -  userId: {}", request.getUserId());
        userService.apply(request);
        return CommonResponse.res(SuccessCode.APPLY_SUCCESS);
    }
}
