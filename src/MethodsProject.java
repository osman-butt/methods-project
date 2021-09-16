import java.util.Scanner;

public class MethodsProject {
    public static void main(String[] args) {
        // Initiate scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Task 1 - implementation of smallestNumber method
        System.out.println("--- TASK 1 ---");

        // Ask user to input three numbers
        System.out.println("Please enter first number:");
        double number1 = scanner.nextDouble();
        System.out.println("Please enter second number:");
        double number2 = scanner.nextDouble();
        System.out.println("Please enter third number:");
        double number3 = scanner.nextDouble();

        // use the method
        System.out.println("The smallest value is " + smallestNumber(number1,number2,number3));

        // Task 2 - implementation of signOfNumber method
        System.out.println("--- TASK 2 ---");

        // Ask user to input a number
        System.out.println("Please enter a number:");
        double number_task2 = scanner.nextDouble();

        // use the method
        signOfNumber(number_task2);
    }

    // Task 1
    // Implement a function that takes 3 numbers as input
    // and returns the smallest value among the 3 numbers
    public static double smallestNumber(double number1, double number2, double number3){
        // We check min number pairwise
        double firstCheck = Math.min(number1,number2);
        double secondCheck = Math.min(firstCheck,number3);
        return Math.min(firstCheck,secondCheck);
    }

    // Task 2
    // Implementing a function that takes a number as an input
    // and prints the sign of the number.
    public static void signOfNumber(double number){
        String sign = "";
        if (number>0.0){
            sign = "positive";
        }else if (number < 0.0){
            sign = "negative";
        }else {
            sign = "zero";
        }
        System.out.println("The sign of value is " + sign);
    }

}