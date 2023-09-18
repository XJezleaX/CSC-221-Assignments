import java.util.Random;

public class thirdTask {
    public static void main(String[] args) {
        String taskNumber = "\nTask Three: ";
        String even = "Even Numbers: ";
        String odd = "\nSum of all Odd Numbers: ";
        System.out.println(taskNumber);
        System.out.println(even);
        int sum = 0;


        int i;
        for(i = 1; i <= 20; ++i) {
            if (i % 2 == 0) {
                System.out.print("" + i + " ");
            }
        }


        System.out.print("\n");
        System.out.println(odd);


        for(i = 1; i <= 50; ++i) {
            if (i % 2 != 0) {
                sum += i;
            }
        }


        System.out.print(sum);
    }
}
