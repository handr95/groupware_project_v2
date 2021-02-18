package com.sgw.common.repository;

import com.sgw.common.domain.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
