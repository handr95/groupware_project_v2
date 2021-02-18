package com.sgw.common.service;

import com.sgw.common.domain.Task;
import com.sgw.common.domain.User;
import com.sgw.common.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task _task) {
        Task task = taskRepository.save(_task);
        return task;
    }

    public Optional<Task> findByTaskNo(Long _taskNo) {
        Optional<Task> task = taskRepository.findByTaskNo(_taskNo);
        return task;
    }

}
