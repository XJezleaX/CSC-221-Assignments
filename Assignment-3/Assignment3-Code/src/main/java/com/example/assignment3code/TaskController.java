package com.example.assignment3code;

import org.springframework.web.bind.annotation.*;
import java.util.List;


//Controller: (25 points)
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController() {    //Making the filepath to sample.json for the rest of the code implementation
        this.taskRepository = new TaskRepository("sample.json");
    }

    @GetMapping            //Handelling endpoint for seeing all tasks
    public List<Task> allTasks() {
        return taskRepository.allTasks();
    }

    @PostMapping("/create")             //Handelling endpoint for adding task
    public Task create(@RequestBody Task task) {
        taskRepository.add(task);
        return task;
    }

    @GetMapping("/{id}")       //Handelling endpoint for seeing a specified task assigned to an id
    public Task taskId(@PathVariable Long id) {
        return taskRepository.taskId(id);
    }

    @PutMapping("/{id}")         //Handelling endpoint for updating already existing task
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        taskRepository.update(task);
        return task;
    }

    @DeleteMapping("/{id}")         //Handelling endpoint for deletion
    public void deleteTask(@PathVariable Long id) {
        taskRepository.delete(id);
    }
}
