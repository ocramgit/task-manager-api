package me.marco.Task.service;

import me.marco.Task.domain.Task;
import me.marco.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getUserList() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        return taskRepository.save(new Task(task.getTask(), task.getDescription()));
    }
}