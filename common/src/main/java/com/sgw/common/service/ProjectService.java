package com.sgw.common.service;

import com.sgw.common.domain.Project;
import com.sgw.common.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project _project) {
        Project project = projectRepository.save(_project);
        return project;
    }
}
