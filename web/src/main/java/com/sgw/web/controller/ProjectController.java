package com.sgw.web.controller;

import com.sgw.common.domain.Project;
import com.sgw.common.domain.User;
import com.sgw.common.domain.UserSession;
import com.sgw.common.service.ProjectService;
import com.sgw.common.service.UserService;
import com.sgw.web.dto.ProjectDtoRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/project")
@RequiredArgsConstructor
public class ProjectController {
    private final HttpSession httpSession;
    private final ProjectService projectService;
    private final UserService userService;

    @GetMapping
    public String getAddProjectPage() {
        return "project";
    }

    @ResponseBody
    @PostMapping
    public Project addProject(@RequestBody ProjectDtoRequest _projectDtoRequest) {
        UserSession userSession = (UserSession) httpSession.getAttribute("userSession");
        Optional<User> user = userService.findByUserNo(userSession.getUserNo());
        if (user.isPresent() == false) {
            //에러에러
        }

        return projectService.save(_projectDtoRequest.toEntity(user.get()));
    }

    @GetMapping("/{projectNo}")
    public String getProject(@PathVariable String projectNo) {
        return "project";
    }
}
