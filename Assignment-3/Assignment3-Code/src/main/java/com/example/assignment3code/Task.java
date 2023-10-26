package com.example.assignment3code;

import com.fasterxml.jackson.annotation.JsonInclude;  //Utilizing jackson for serialization and deserialization
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;     //Taking care of exceptions

//Task Entity with JSON: (15 points)
@JsonInclude(JsonInclude.Include.NON_NULL) //Accounting for issues with a user not giving a value for one of our variables
public class Task{
    private Long id;              //Ensuring we have necessary fields by defining a long variable named id
    private String description;  //Ensuring we have necessary fields by defining a string variable named description
    private boolean completed;   //Ensuring we have necessary fields by defining a boolean variable named completed

    public Long getId() {    //Getter and setter for everything (Lines 21 through 35)
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task(String description) {  //creating a constructor for our description variable
        this.description = description;
    }

    public static Task fromJson(String json) throws IOException {  //Creating a proper attribute for deserialization and implementing method to convert from JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Task.class);
    }
    public String toJson() throws IOException {                   //Creating a proper attribute for serialization and implementing method to convert to JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
