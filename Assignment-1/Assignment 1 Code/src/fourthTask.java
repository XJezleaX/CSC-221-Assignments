public class fourthTask {
    private int width;  //Creating our int variables for formula
    private int length;


    public int getWidth() {  //Getter and setter for everything
        return this.width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getLength() {
        return this.length;
    }


    public void setLength(int length) {
        this.length = length;
    }


    public fourthTask(int length, int width) {
        this.length = length;
        this.width = width;
    }


    public int calculateArea() {     //Area function, are will equal length times width
        int area = this.length * this.width;
        return area;
    }

    public static void main(String[] args) {
        String taskNumber = "\nTask Four: ";
        System.out.println("\n");
        System.out.println(taskNumber);

        fourthTask example1 = new fourthTask(4, 5); //Create a new object and put in the desired length and width
        int answer1 = example1.calculateArea();  //Calculate area for this object
        System.out.println("Example 1: Length = " + example1.getLength() + " and width =  " + example1.getWidth()); //Print length and width we chose
        System.out.println("Area = " + answer1 + "\n");  //Print the area

        fourthTask example2 = new fourthTask(6, 7);
        int answer2 = example2.calculateArea();
        System.out.println("Example 2: Length = " + example2.getLength() + " and width =  " + example2.getWidth());
        System.out.println("Area = " + answer2 + "\n");

        fourthTask example3 = new fourthTask(12, 11);
        int answer3 = example3.calculateArea();
        System.out.println("Example 3: Length = " + example3.getLength() + " and width =  " + example3.getWidth());
        System.out.println("Area = " + answer3 + "\n");

        fourthTask example4 = new fourthTask(4, 10);
        int answer4 = example4.calculateArea();
        System.out.println("Example 4: Length = " + example4.getLength() + " and width =  " + example4.getWidth());
        System.out.println("Area = " + answer4 + "\n");
    }
}
