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


    public static long calculateFactorial(int n) { //Factorial function
        long factorial;  //Using long for larger numbers
        if (n >= 2) {
            factorial = (long)n * calculateFactorial(n - 1);
            return factorial;
        } else {
            factorial = 1;  //If 0 or 1 then factorial will always be 1 per math logic
            return factorial;
        }
    }


    public static void main(String[] args) {
        String taskNumber = "Task Five: ";
        System.out.println(taskNumber);
        System.out.println("Example 1: The factorial is " + calculateFactorial(1)); //Giving two examples
        System.out.println("Example 2: The factorial is " + calculateFactorial(8));
    }
}
