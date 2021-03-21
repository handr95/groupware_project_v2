package com.sgw.web.controller;

import com.sgw.common.domain.Project;
import com.sgw.common.domain.User;
import com.sgw.common.domain.UserSession;
import com.sgw.common.service.ProjectService;
import com.sgw.common.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final HttpSession httpSession;
    private final ProjectService projectService;
    private final UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        UserSession userSession = (UserSession) httpSession.getAttribute("userSession");
        if (userSession != null) {
            Optional<User> user = userService.findByUserNo(userSession.getUserNo());
            List<Project> projectList = projectService.findByUser(user.get());
            model.addAttribute("projectList", projectList);
        }

        model.addAttribute("userSession", userSession);
        return "main";
    }
}