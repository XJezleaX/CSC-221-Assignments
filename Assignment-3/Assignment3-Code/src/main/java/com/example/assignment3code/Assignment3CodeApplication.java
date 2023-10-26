package com.example.assignment3code;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment3CodeApplication {
	public static void main(String[] args) {
		SpringApplication.run(Assignment3CodeApplication.class, args);
	}
	String filePath = "src/main/test/sample.json";
	TaskRepository taskRepository = new TaskRepository(filePath);

}
