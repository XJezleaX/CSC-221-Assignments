import java.util.Scanner;


public class secondTask {
    public static void main(String[] args) {
        String taskNumber = "\nTask Two: ";
        System.out.println(taskNumber);
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your age: ");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("Your are an adult");
        } else {
            System.out.println("Your are a minor");
        }


        scanner.close();
    }
}
