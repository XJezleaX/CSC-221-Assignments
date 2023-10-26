package com.example.assignment3code;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService() {   //Making the filepath to sample.json for the rest of the code implementation
        this.taskRepository = new TaskRepository("sample.json");
    }

    //Implementing methods to interact with TaskRepository

    public List<Task> allTasks() {
        return taskRepository.allTasks();
    }

    public Task create(Task task) {
        taskRepository.add(task);
        return task;
    }

    public Task taskId(Long id) {
        return taskRepository.taskId(id);
    }

    public Task update(Long id, Task task) {
        if (taskRepository.taskId(id) != null) {
            task.setId(id);
            taskRepository.update(task);
            return task;
        }
        return null;
    }

    public boolean delete(Long id) {
        Task existing = taskRepository.taskId(id);
        if (existing != null) {
            taskRepository.delete(id);
            return true;
        }
        return false;
    }
}