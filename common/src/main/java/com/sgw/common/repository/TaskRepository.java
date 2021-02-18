package com.sgw.common.repository;

import com.sgw.common.domain.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTaskNo(Long taskNo);
}
