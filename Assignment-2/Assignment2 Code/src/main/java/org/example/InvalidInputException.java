package org.example;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;


public class InvalidInputException {
    public static boolean validOption (String choice){  //Ensuring for menu option we are given an Int between 1-6
        try {
            int intChoice = Integer.parseInt(choice);
            return intChoice >= 1 && intChoice <= 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validname (String name){   //Ensuring our name is a letter in the alphabet
        return name.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean validRollNumber (String rollNumber) {
        return rollNumber.matches("\\d{8}");
    }

    public static boolean addValidRollNumber (String rollNumber){  //Ensuring our roll number is 8 digits
        if (!rollNumber.matches("\\d{8}")) {                 //Making our roll number system 8 digits long
            System.out.println("\nYour roll number should be an 8-digit number!");
            return false;
        }
        try (CSVReader reader = new CSVReader(new FileReader("StudentRecords.txt"))) {  //Checking the roll number is not already taken
            String[] currentRolls;

            while ((currentRolls = reader.readNext()) != null) {   //Roll number will be index[1] in our string for records
                String rollOnFile = currentRolls[1];

                if (rollNumber.equals(rollOnFile)) {
                    System.out.println("\nYour roll number is already on file!"); //Give message if roll number is already on file, (not valid)
                    return false;
                }
            }
        } catch (IOException e) {  //Accounting for errors
            e.printStackTrace();
            IOError();
            return false;
        }
        return true;
    }

    public static boolean validEditRoll (String editroll){
        return editroll.matches("\\d{8}");
    }
    public static boolean validEditName (String editname){

        return editname.matches("^[a-zA-Z]+$");
    }

    public static boolean validMarks (String marks){         //Ensuring our marks are non-negative and <=100
        try {
            double decMark = Double.parseDouble(marks);
            return decMark >= 0 && decMark <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean validEditMarks (String editmarks){
        try {
            double decMark = Double.parseDouble(editmarks);
            return decMark >= 0 && decMark <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void IOError (){                            //Handles errors with friendly user messages
        System.out.println("Error has occurred please try again!");
    }
}

