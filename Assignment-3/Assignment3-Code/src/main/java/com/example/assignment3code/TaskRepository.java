package com.example.assignment3code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;  //Accounting for errors in our code
import java.util.ArrayList;
import java.util.List;
import java.io.File;

//Repository with JSON File: (20 points)
public class TaskRepository {
    private String filePath;
    private List<Task> tasks;
    private ObjectMapper objectMapper;

    //Defining what is save and load for later on
    private List<Task> load() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Task>>() {});  //Gets all the listed tasks in the JSON file
        } catch (IOException e) {      //Accounting for errors
            return new ArrayList<>();
        }
    }

    private void save() {
        try {
            objectMapper.writeValue(new File(filePath), tasks);  //Writing tasks for JSON file
        } catch (IOException e) {        //Accounting for errors
            e.printStackTrace();
        }
    }

    public TaskRepository(String filePath) {  //Getting our filepath which is the json file "sample.json"
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        tasks = load();   //Getting all the task records on file
    }

    private Long randomId() {
        return tasks.stream().map(Task::getId).max(Long::compareTo)
                .orElse(1L) + 3;  //Looks at all other ids and adds three to the highest one
    }

    //Basic Operations being implemented
    public List<Task> allTasks() { //Getting all the tasks from our JSON file
        return tasks;
    }

    public Task taskId(Long id) {         //Using the id variable to find a specific task so we can use it for the update function later
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public void update(Task task) {
        Task existing = taskId(task.getId());
        if (existing != null) {
            tasks.remove(existing);             //Taking out the old task to subsitute in the new one
            tasks.add(task);
            save();              //Putting the new completed list of tasks in the JSON file
        }
    }
    public void add(Task task) {          //Adds a new task with a random id if not given
        if (task.getId() == null) {
            task.setId(randomId());
        }
        tasks.add(task);
        save();                         //Putting the new completed list of tasks in the JSON file
    }

    public void delete(Long id) {
        Task taskToRemove = taskId(id);
        if (taskToRemove != null) {            //Deleting the task if it is not empty
            tasks.remove(taskToRemove);
            save();
        }
    }
}