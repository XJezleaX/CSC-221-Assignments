
package org.example;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {
    private static Scanner searchScan;                                  //scanner to be used in future
    private static final String CSV_FILE_PATH = "./StudentRecords.txt"; //States our csv file path for future
    private static final String[] labelling = {"Full Name", "Roll Number", "Marks"}; //Will be our column labels

    private static void ensureFileExits() {
        File file = new File("StudentRecords.txt");
        if (!file.exists()) {                 //Checking if file does not exit
            try {
                if (file.createNewFile()) {   //If it does not exist we create a new file named "StudentRecords.txt"
                    List<String[]> labelTop = new ArrayList<>();
                    labelTop.add(labelling);
                    typeInCSV(CSV_FILE_PATH, labelTop);    //Giving our file a label on top for each column
                }
            } catch (IOException e) {             //Handling errors, user friendly message and debugging
                InvalidInputException.IOError();
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ensureFileExits();         //Make sure we have a file to write and read to/from
        menu();                    //Displays my menu options

        String choice = menuChoice(); //Gets menu choice so we can go to next menu

        while (!InvalidInputException.validOption(choice)) {                                             //Validates roll number, same as before
            System.out.println("\nERROR: Please pick from given options above (Be careful to not have a space!)");
            System.out.print("\nPlease select an option: ");
            choice = menuChoice();
        }

        if (choice.equals("1")) {         //Add record code
            firstChoice();
        }
        if (choice.equals("2")) {         //Search for student record code
            secondChoice();
        }
        if (choice.equals("3")) {         //Edit my record code
            thirdChoice();
        }
        if (choice.equals("4")) {         //View all records code
            fourthChoice();
        }
        if (choice.equals("5")) {         //Delete record code
            fifthChoice();
        }
        if (choice.equals("6")) {         //Exit record code
            sixthChoice();
        }

    }

    public static void menu(){
        System.out.println("\nWelcome to your student records\n----------------------------"); //Menu
        System.out.print("\nOption 1: Add my Record");
        System.out.print("\nOption 2: Search for Student Record");
        System.out.print("\nOption 3: Edit My Record");
        System.out.print("\nOption 4: View All Records");
        System.out.print("\nOption 5: Delete a Record");
        System.out.print("\nOption 6: Exit\n\n");
        System.out.print("Please select an option: ");
    }

    private static String menuChoice() {
        Scanner scanner = new Scanner(System.in); //Takes in user sub menu choice
        return scanner.nextLine();
    }

    private static void firstChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------------------\nOption 1: Add my Record"); // Menu design for separation

        List<String[]> data = new ArrayList<>();

        System.out.print("\nEnter your full name: "); // Gets name for record using scanner
        String name = scanner.nextLine();

        while (!InvalidInputException.validname(name)) { // Checks that name contains letters
            System.out.println("\nName should contain only letters of the alphabet!");
            System.out.print("\nEnter your full name: ");
            name = scanner.nextLine();
        }

        System.out.print("\nEnter your 8-Digit roll number: "); // Gets roll number for record using scanner
        String rollNumber = scanner.nextLine();

        while (!InvalidInputException.addValidRollNumber(rollNumber)) { // Checks that roll number is 8-digit long
            System.out.print("\nEnter your roll number (8 digits): ");
            rollNumber = scanner.nextLine();
        }

        System.out.print("\nHow many marks would you like to enter?: ");  //Getting how many marks user wants
        int numMarks = scanner.nextInt();
        double[] allMarks = new double[numMarks];
        scanner.nextLine();

        for (int i = 0; i < numMarks; i++) {    //Labelling each mark
            System.out.print("\nEnter student's mark " + (i + 1) + ": ");
            String marks = scanner.nextLine();

            while (!InvalidInputException.validMarks(marks)) { // Checks marks are non-negative and less than 100 (regular grade scale)
                System.out.println("Marks cannot be below 0 or above 100 and have to be a number!");
                System.out.print("\nEnter student's mark (0-100): ");
                marks = scanner.nextLine();
            }
            allMarks[i] = Double.parseDouble(marks);
        }

        StringBuilder marksString = new StringBuilder();
        for (int i = 0; i < numMarks; i++) {
            marksString.append(allMarks[i]);
            if (i < numMarks - 1) {
                marksString.append(" ");
            }
        }

        String[] studentData = new String[]{name, rollNumber, marksString.toString()};
        data.add(studentData); // Places student record in a string in StudentRecords.txt
        typeInCSV(CSV_FILE_PATH, data);

        System.out.print("\nRecord Added!"); // Successful message for the user
    }

    private static void secondChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------------------\nOption 2: Search for Student Record");  //Menu design for separation
        System.out.print("\nEnter your 8-Digit roll number: ");                  //Gets roll number for record using scanner
        String rollNumber = scanner.nextLine();

        while (!InvalidInputException.validRollNumber(rollNumber)) {                   //Validates roll number, same as before
            System.out.print("\nYour roll number should be an 8-digit number!");
            System.out.print("\n\nEnter your roll number (8 digits): ");
            rollNumber = scanner.nextLine();
        }

        boolean found = false;      //Bool found because as long as we have not found the roll number we will continue

        try {
            searchScan = new Scanner(new File("StudentRecords.txt"));  //Searching the StudentRecord.txt file
            searchScan.useDelimiter("[,\n]");                            //Using delimiters to search through each roll number

            while (searchScan.hasNext() && !found) {                             //Storing the strings rollnumber, name and marks value
                String studentName = searchScan.next();
                String studentRoll = searchScan.next();
                String studentMarks = searchScan.next();

                if (studentRoll.equals(rollNumber)) {                           //When value matches with user given roll number we have found the record
                    found = true;
                    System.out.println("\nStudent Name: " + studentName + "\nRoll Number: " + studentRoll + "\nMarks: " + studentMarks); //Return the name, rollnumber, and mark at that StudentRecords.txt string
                }
            }
            if(!found){
                System.out.println("\nStudent record not found!"); //Accounting for record not found case
            }
        } catch (Exception e) {                 //Handling error with friendly message and debugging techniques
            InvalidInputException.IOError();
            e.printStackTrace();
        }
    }

    private static void thirdChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------------------\nOption 3: Edit My Record");  //Menu design for separation
        System.out.print("\nEnter your 8-Digit roll number: ");  //Gets rollnumber for record using scanner
        String rollNumber = scanner.nextLine();

        while (!InvalidInputException.validRollNumber(rollNumber)) {                   //Validating record
            System.out.print("\nYour roll number should be an 8-digit number!");
            System.out.print("\n\nEnter your roll number (8 digits): ");
            rollNumber = scanner.nextLine();
        }

        boolean found = false;

        try {
            File originalFile = new File("StudentRecords.txt");   //Stating original file as we will get our record from it
            File editFile = new File("temp.txt");                 //Using a temp file to re-write our record on
            FileWriter fw = new FileWriter("temp.txt", true);    //Using filwriter to write our edited data in temp
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);                                //Will print out entire record string on file

            searchScan = new Scanner(new File("StudentRecords.txt"));
            searchScan.useDelimiter("[,\n]");

            while (searchScan.hasNext()) {
                String studentName = searchScan.next();
                String studentRoll = searchScan.next();
                String studentMarks = searchScan.next();

                if (studentRoll.equals(rollNumber) && !found) {
                    found = true;
                    System.out.println("\nHere is your current record on file: ");   //Telling users what the file already has
                    System.out.println("\nStudent Name: " + studentName + "\nRoll Number: " + studentRoll + "\nMarks: " + studentMarks);
                    System.out.print("\nEditing Record:\n\nEnter your full name: "); //Letting users edit their name, roll number
                    String editname = scanner.nextLine();

                    while (!InvalidInputException.validEditName(editname)) {                      //Checks that name contains letters
                        System.out.println("\nName should be letters of the alphabet!");
                        System.out.print("\nEnter your full name: ");
                        editname = scanner.nextLine();
                    }

                    System.out.print("\nEnter your roll number: ");
                    String editroll = scanner.nextLine();

                    if (!InvalidInputException.validEditRoll(editroll)) {                                  //Validating roll number
                        System.out.println("\nYour roll number should be an 8-digit number.");
                        System.out.print("\nEnter your roll number (8 digits): ");
                        editroll = scanner.nextLine();
                    }

                    System.out.print("\nHow many marks would you like to enter?: ");  //Getting how many marks user wants
                    int numMarks = scanner.nextInt();
                    double[] studentAllMarks = new double[numMarks];
                    scanner.nextLine();

                    for (int i = 0; i < numMarks; i++) {
                        System.out.print("\nEnter student's mark " + (i + 1)+ ": ");
                        String editmarks = scanner.nextLine();

                        while (!InvalidInputException.validEditMarks(editmarks)) {                                //Checks marks are non-negative and less than 100 (regular grade scale)
                            System.out.println("Marks cannot be below 0 or above 100 and have to be a number!");
                            System.out.print("\nEnter student's mark (0-100): ");
                            editmarks = scanner.nextLine();
                        }
                        studentAllMarks[i] = Double.parseDouble(editmarks);
                    }

                    StringBuilder marksString = new StringBuilder();
                    for (int i = 0; i < numMarks; i++) {
                        marksString.append(studentAllMarks[i]);
                        if (i < numMarks - 1) {
                            marksString.append(" ");
                        }
                    }

                    System.out.println("\nNew Edited Record: ");                     //Printing edited record for user to see
                    System.out.println("\nStudent Name: " + editname + "\nRoll Number: " + editroll + "\nMarks: " + marksString.toString());
                    pw.println(editname + "," + editroll + "," +  + studentAllMarks[0] + " " + marksString.toString());         //Printing onto temp file
                } else {               //If not the given roll number simply writing string onto temp file as is
                    pw.println(studentName + "," + studentRoll + "," + studentMarks);
                }
            }
            searchScan.close();
            pw.flush();
            pw.close();

            if (originalFile.exists()) {     //Deleting our original StudentRecords.txt and renaming temp file to StudentRecords.txt
                if (originalFile.delete()) {
                    if (editFile.renameTo(originalFile)) {
                        if (found) {
                            System.out.println("\nEdits Complete!");  //Success confirmation for user
                        } else {
                            System.out.println("\nStudent record not found!"); //Accounting for record not found case
                        }
                    }
                }
            }
        }catch(Exception e){                  //Handling errors with user friendly message and debugging techniques
            InvalidInputException.IOError();
            e.printStackTrace();
        }
    }

    private static void fourthChoice() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("StudentRecords.txt"));                 //Reading from our csv file
        System.out.println("\n----------------------------\nOption 4: View All Records\n");  //Menu display for separation
        scan.useDelimiter(":");
        while (scan.hasNext()) {
            System.out.print(scan.next());                                                   //Printing every record on file for display
        }
        scan.close();
    }

    private static void fifthChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n----------------------------\nOption 5: Delete a Record\n");  //Menu display for separation
        System.out.print("\nEnter the 8-Digit roll number to delete: ");    //Gets roll number for deletion using scanner
        String rollNumber= scanner.nextLine();

        while (!InvalidInputException.validRollNumber(rollNumber)) {                      //Checks that roll number is 8-digit long
            System.out.print("\nYour roll number should be an 8-digit number!");
            System.out.print("\n\nEnter your roll number (8 digits): ");
            rollNumber = scanner.nextLine();
        }

        try {
            File originalFile = new File("StudentRecords.txt");     //Defining original file and temp file for use
            File editFile = new File("temp.txt");
            FileReader fr = new FileReader(originalFile);                    //Reading from original StudentRecords.txt file
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(editFile);                        //Writing to temp file our records with the deletion done
            BufferedWriter bw = new BufferedWriter(fw);

            boolean found = false;
            String csvline;

            while ((csvline = br.readLine()) != null) {
                String[] info = csvline.split(",");                   //Splitting our string to remove the file
                String studentRoll = info[1].trim();

                if (!studentRoll.equals(rollNumber)) {                      //If it is not the file want delete then just write the record as normal
                    bw.write(csvline);
                    bw.newLine();
                } else {
                    found = true;
                }
            }
            br.close();
            bw.close();
            fr.close();
            fw.close();
            if (originalFile.delete()) {                    //Deleting original StudentRecords.txt again and renaming our temp file to it
                if (editFile.renameTo(originalFile)) {
                    if (found) {
                        System.out.print("\nDeleting record...\n"); //Success confirmation for user
                    } else {
                        System.out.println("\nStudent record not found!"); //Accounting for record not found case
                    }
                }
            }
        } catch (IOException e) {             //Handling errors with user friendly message and debugging techniques
            InvalidInputException.IOError();
            e.printStackTrace();
        }
    }

    private static void sixthChoice(){
        System.out.print("\n----------------------------\nOption 6: Exit\n\n"); //Menu design for separation and exit message
        System.out.print("Exiting program...\n\n");
    }
    public static void typeInCSV (String output, List < String[]>data){
        try {
            FileWriter outputfile = new FileWriter(output, true); //Appending our file with the student record
            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {                  //Handling errors once again with user friendly message and debugging techniques
            InvalidInputException.IOError();
            e.printStackTrace();
        }
    }
}
