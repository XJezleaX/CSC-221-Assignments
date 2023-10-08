package org.example;

import java.util.Arrays;

public class Student {
    private String name;  //Defining name,rllnumber, and array for marks

    private String rollnumber;

    private double[] marks;

    public String getName() {
        return name;
    }  //Getter and setter for everything

    public void setName(String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public double[] getMarks() {
        return marks;
    }
    public void setMarks(double[] marks) {
        this.marks = marks;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }
    public Student(String name, String rollnumber, double[] marks) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.marks = marks;
    }

    public double calculateAverageMarks() {     //Calculating average function
        double average = 0.0;
        double sum = 0.0;                       //Defining sum to 0

        for (double mark : marks) {
            sum = sum + mark;                   //As we go through the mark array, sum will increment, becoming whatever is in sum + mark
        }
        if(marks.length == 0) {                  //Handling the division by 0 case
            average = 0;
        }
        else{
            average = sum / marks.length;
        }
        return average;
    }

    public void displayStudentInfo() {     //Function to display student info
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollnumber);
        System.out.println("Average Marks: " + calculateAverageMarks());
    }

    public static void main(String[] args) {
        double[] addMarks = {89.5, 65.0, 79.9, 52.0};
        Student addStudent = new Student("Maria", "1", addMarks); //Sample output
        System.out.println("\n----------------------------\nObject-Oriented Programming\n"); //Defiining assignment section
        addStudent.displayStudentInfo();
        System.out.println("Marks: " + Arrays.toString(addStudent.getMarks()));
        System.out.println("\n----------------------------\n");
    }
}