package com.swg.web.controller;

import com.swg.common.domain.User;
import com.swg.common.service.UserService;
import com.swg.web.dto.SignupDtoRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @ResponseBody
    @GetMapping("/signup/{nickNm}")
    public Boolean checkNickNm(@PathVariable(name = "nickNm") String nickNm) {
        User findUser = userService.findByNickNm(nickNm).get();
        if (findUser == null) {
            return true;
        }

        return false;
    }

    @ResponseBody
    @PostMapping("/signup")
    public User signup(@RequestBody SignupDtoRequest signupDtoRequest) {
        return userService.save(signupDtoRequest.toEntity());
    }
}
