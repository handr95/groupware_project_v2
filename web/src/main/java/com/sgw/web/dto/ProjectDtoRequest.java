package com.sgw.web.dto;

import com.sgw.common.domain.Project;
import com.sgw.common.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectDtoRequest {
    private String projectTitle;
    private String projectDesc;
    private Short openYn;

    public Project toEntity(User _user) {
        return Project.builder()
            ._projectTitle(projectTitle)
            ._projectDesc(projectDesc)
            ._user(_user)
            ._openYn(openYn)
            .build();
    }
}