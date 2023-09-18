import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        String taskNumber = "\nBonus Task: "; //Just to differentiate the tasks
        System.out.println(taskNumber);
        Scanner scanner = new Scanner(System.in); //User a scanner to get user inputs




        System.out.println("Welcome to My Calculator App");
        System.out.print("\n");


        System.out.println("What is your first value");  //First value to use in our operation
        double value1 = scanner.nextDouble();




        System.out.println("What is your second value"); //Second value
        double value2 = scanner.nextDouble();
        scanner.nextLine();




        System.out.println("What operation do you want to use?"); //Getting the operation so we can make the calculation
        String operation = scanner.nextLine();

        //Accounting for each operation and the various user inputs we may be given
        if (operation.equals("multiplication") || operation.equals("multiply") || operation.equals("*"))
        {
            double answer = value1 * value2;
            System.out.println("Answer = " + answer);
        } else if (operation.equals("addition") || operation.equals("add") || operation.equals("+")) {
            double answer = value1 + value2;
            System.out.println("Answer = " + answer);
        } else if (operation.equals("subtraction") || operation.equals("subtract") || operation.equals("-")) {
            double answer = value1 - value2;
            System.out.println("Answer = " + answer);
        } else if (operation.equals("division") || operation.equals("divide") || operation.equals("/")) {
            if (value2 == 0)
            {
                System.out.println("Error: Cannot divide by 0");  //Accounting for the zero case
                return;
            }
            else
            {
                double answer = value1 / value2;
                System.out.println("Answer = " + answer);
            }
            scanner.close();
        }
        scanner.close();
    }
}


