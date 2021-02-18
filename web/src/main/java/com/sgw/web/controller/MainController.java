package com.sgw.web.controller;

import com.sgw.common.domain.UserSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
    final private HttpSession httpSession;

    @GetMapping("/")
    public String main(Model model) {
        UserSession userSession = (UserSession) httpSession.getAttribute("userSession");

        model.addAttribute("userSession", userSession);
        return "main";
    }
}
