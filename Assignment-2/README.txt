Comprehensive Java Program: Student Information Management

The program will allow a new student record to be displayed using the Java Student class. User will enter their name, roll number, and marks. Then, the program will calculate average marks and return its decimal value. Finally, student info will be displayed for the user to analyze.

In our main class is a programmed user-driven menu for a student record system. The program will create a new CSV File and allow users to add data: names, roll numbers, and marks. The user data will be written to the CSV for record and allow a variety of functions to be performed: search record, edit records, view all, delete, etc.

-----------------------------------------------------
STUDENT JAVA CLASS:
Sample Input: 
double[] addMarks = {89.5, 65.0, 79.9, 52.0};
        Student addStudent = new Student("Maria", "1", addMarks); 
        addStudent.displayStudentInfo();

Sample Output:

Object-Oriented Programming

Name: Maria
Roll Number: 1
Average Marks: 71.6
Marks: [89.5, 65.0, 79.9, 52.0]

----------------------------------------------------

MAIN JAVA CLASS OUTPUT

SAMPLE INPUT, Option 1: Add my Record:


Enter your full name: Maria Lopez

Enter your 8-Digit roll number: 12345678

How many marks would you like you enter?: 5

Enter student's marks 1: 67

Enter student's marks 2: 99

Enter student's marks 3: 65

Enter student's marks 4: 85

Enter student's marks 5: 96


SAMPLE OUTPUT, Option 1: Add my Record:

Record Added!

----------------------------------------------------
SAMPLE INPUT, Option 2: Search for Student Record:

Enter your 8-Digit roll number: 12345678


SAMPLE OUTPUT, Option 2: Search for Student Record:

Student Name: Maria Lopez
Roll Number: 12345678
Marks: 67.0 99.0 65.0 85.0 96.0

----------------------------------------------------
SAMPLE INPUT, Option 3: Edit My Record:


Enter your 8-Digit roll number: 12345678

Here is your current record on file: 

Student Name: Maria Lopez
Roll Number: 12345678
Marks: 67.0 99.0 65.0 85.0 96.0

Editing Record:

Enter your full name: Kelsey

Enter your roll number: 12345678

How many marks would you like to enter?: 7

Enter student's marks 1: 88

Enter student's marks 2: 94

Enter student's marks 3: 69

Enter student's marks 4: 85

Enter student's marks 5: 97

Enter student's marks 5: 90

Enter student's marks 5: 98


SAMPLE OUTPUT, Option 3: Edit My Record:

New Edited Record: 

Student Name: Kelsey
Roll Number: 12345678
Marks: 88.0 94.0 69.0 85.0 97.0 90.0 98.0

Edits Complete!


----------------------------------------------------

SAMPLE INPUT, Option 4: View All Records:

Does not require input!


SAMPLE OUTPUT, Option 4: View All Records:

Full Name,Roll Number,Marks
Kelsey,12345678,88.0 88.0 94.0 69.0 85.0 97.0 90.0 98.0

----------------------------------------------------

SAMPLE INPUT, Option 5: Delete a Record:

Enter the 8-Digit roll number to delete: 12345678


SAMPLE OUTPUT, Option 5: Delete a Record:

Deleting record...

----------------------------------------------------
SAMPLE INPUT, Option 6: Exit:

Does not require input!


SAMPLE OUTPUT, Option 6: Exit:

Exiting program...
