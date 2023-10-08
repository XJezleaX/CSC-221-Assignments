package org.example;

import java.util.ArrayList;

public class StudentRecord {
    private String name;
    private String rollNumber;
    private String marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
    public StudentRecord(String name, String rollNumber, String marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
}