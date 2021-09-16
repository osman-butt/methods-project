import java.util.Scanner;
import java.lang.*;

public class MethodsProject {
    public static void main(String[] args) {
        // Initiate scanner object for user input
        Scanner scannerDouble = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        // Task 1 - implementation of smallestNumber method
        System.out.println("--- TASK 1 ---");

        // Ask user to input three numbers
        System.out.println("Please enter first number:");
        double number1 = scannerDouble.nextDouble();
        System.out.println("Please enter second number:");
        double number2 = scannerDouble.nextDouble();
        System.out.println("Please enter third number:");
        double number3 = scannerDouble.nextDouble();

        // implementation of method
        System.out.println("The smallest value is " + smallestNumber(number1,number2,number3));


        // Task 2 - implementation of signOfNumber method
        System.out.println("--- TASK 2 ---");

        // Ask user to input a number
        System.out.println("Please enter a number:");
        double number_task2 = scannerDouble.nextDouble();

        // implementation of method
        signOfNumber(number_task2);


        // Task 3 - implementation of getMiddleCharacter method
        System.out.println("--- TASK 3 ---");

        // Ask user to input a number
        System.out.println("Please enter a string:");
        String inputString = scannerString.nextLine();

        // implementation of method
        System.out.println("The middle character is " + getMiddleCharacter(inputString));


        // Task 4 - implementation of getAreaOfTriangle method
        System.out.println("--- TASK 4 ---");

        // Ask user to input three numbers
        System.out.println("Please enter first side length of triangle:");
        double sideOne = scannerDouble.nextDouble();
        System.out.println("Please enter second side length of triangle:");
        double sideTwo = scannerDouble.nextDouble();
        System.out.println("Please enter third side length of triangle:");
        double sideThree = scannerDouble.nextDouble();

        // implementation of method
        System.out.println("Input Side-1: "+sideOne);
        System.out.println("Input Side-2: "+sideTwo);
        System.out.println("Input Side-3: "+sideThree);
        System.out.println("The area of the triangle is "+getAreaOfTriangle(sideOne,sideTwo,sideThree));


        // Task 5
        System.out.println("--- TASK 5 ---");

        // Ask user for a password
        System.out.println("Please enter password:");
        String password = scannerString.nextLine();

        // implementation of method
        System.out.println("Is the password valid: "+isValidPassword(password));


        // Task 6
        System.out.println("--- TASK 6 ---");

        // Ask user to input a number
        System.out.println("Please enter a number:");
        int maximumNumber = scannerInt.nextInt();

        // Implementation of method
        printNumbers(maximumNumber);
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
        String sign;
        if (number>0.0){
            sign = "positive";
        }else if (number < 0.0){
            sign = "negative";
        }else {
            sign = "zero";
        }
        System.out.println("The sign of value is " + sign);
    }


    // Task 3
    // Returns the middle character of string,
    // and takes a string as input.
    // If the string has spaces, the user is asked whether they what them removed or not.
    // If the string is of even length, the user is able to choose left or right
    // character.
    public static char getMiddleCharacter(String inputString){
        // Initiate scanner object for user input
        Scanner scannerTask3 = new Scanner(System.in);

        // Check if string contains whitespace
        boolean containsWhitespace = inputString.contains(" ");
        if(containsWhitespace){
            System.out.println("String contains spaces, do you want to remove them? (y/n)");
            String removeSpace = scannerTask3.nextLine();
            if(removeSpace.equals("y")){
                inputString = inputString.replaceAll("\\s", "");
            }
        }

        int lengthOfStringMinusOne = inputString.length()-1;
        int middleIndex = lengthOfStringMinusOne/2; // note we use integer division

        // Check if string is of even length
        boolean isEven = (inputString.length() % 2)==0;
        if(isEven){
            System.out.println("String is of even length, do you want to the left or right character? (l/r)");
            String leftOrRightChar = scannerTask3.nextLine();
            if(leftOrRightChar.equals("r")){
                middleIndex = lengthOfStringMinusOne/2 + 1;
            }
        }

        return inputString.charAt(middleIndex);
    }


    // Task 4
    // We take the three sides of a triangle as input, and use Herons formula
    // to get the area of the triangle
    public static double getAreaOfTriangle(double sideOne,double sideTwo, double sideThree){
        double semiPerimeter = (sideOne+sideTwo+sideThree)/2.0;
        // Herons formula
        double area = Math.sqrt(semiPerimeter*(semiPerimeter-sideOne)*(semiPerimeter-sideTwo)*(semiPerimeter-sideThree));
        return area;
    }


    // Task 5
    // valid password checker
    public static boolean isValidPassword(String password){
        // Initially we assume that the password is correct
        // But if it fails one of the test, the password comes out
        // as none valid
        boolean validPassword = true;

        // check if it is eight characters long:
        int lengthOfPassword = password.length();
        if(lengthOfPassword<8){
            validPassword = false;
        }
        boolean hasNonAlphanumeric = password.matches("^.*[^a-zA-Z0-9 ].*$");
        if(hasNonAlphanumeric){
            validPassword = false;
        }

        // Cannot contain word "secret"
        String toLowerPassword = password.toLowerCase();
        boolean isSecretContainedInPassword = toLowerPassword.contains("secret");
        if(isSecretContainedInPassword){
            validPassword = false;
        }

        // Check if first char in password is "-"
        char firstChar = password.charAt(0);
        if(firstChar=='-'){
            validPassword = false;
        }

        return validPassword;
    }


    // Task 6
    // Takes number as an input, and prints number from 1 to maximumNumber
    public static void printNumbers(int maximumNumber){
        for (int i = 1; i<=maximumNumber;i++){
            System.out.print("["+i+"]");
        }
    }
}