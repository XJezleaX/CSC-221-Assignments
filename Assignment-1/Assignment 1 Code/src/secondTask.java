import java.util.Scanner;


public class secondTask {
    public static void main(String[] args) {
        String taskNumber = "\nTask Two: ";
        System.out.println(taskNumber);
        Scanner scanner = new Scanner(System.in);  //Using the scanner to get number from user
        System.out.println("What is your age: ");  //Printing message
        int age = scanner.nextInt();               //Next given int will be assigned to int age
        if (age >= 18) {                           //If statement to print different messages depending on user input
            System.out.println("Your are an adult");
        } else {
            System.out.println("Your are a minor");
        }


        scanner.close();
    }
}
