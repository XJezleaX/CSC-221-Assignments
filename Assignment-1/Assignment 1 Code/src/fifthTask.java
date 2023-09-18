public class fifthTask {
    private int n;


    public fifthTask() {
    }


    public int getN() {
        return this.n;
    }


    public void setN(int n) {
        this.n = n;
    }


    public static long calculateFactorial(int n) {
        long factorial;
        if (n >= 2) {
            factorial = (long)n * calculateFactorial(n - 1);
            return factorial;
        } else {
            factorial = 1L;
            return factorial;
        }
    }


    public static void main(String[] args) {
        String taskNumber = "Task Five: ";
        System.out.println(taskNumber);
        long answer1 = calculateFactorial(1);
        System.out.println("Example 1: The factorial is " + answer1);
        long answer2 = calculateFactorial(8);
        System.out.println("Example 2: The factorial is " + answer2);
    }
}
