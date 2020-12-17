package com.swg.web.controller;

import com.swg.common.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
    final private HttpSession httpSession;

    @GetMapping("/")
    public String main(Model model) {
        Optional<User> user = (Optional<User>) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.get().getNickNm());
        }
        return "main";
    }
}
