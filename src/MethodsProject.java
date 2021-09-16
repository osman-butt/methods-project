import java.util.Scanner;
import java.lang.*;

public class MethodsProject {
    public static void main(String[] args) {
        // Initiate scanner object for user input
        Scanner scannerDouble = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerBoolean = new Scanner(System.in);
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

        // use the method
        System.out.println("The smallest value is " + smallestNumber(number1,number2,number3));

        // Task 2 - implementation of signOfNumber method
        System.out.println("--- TASK 2 ---");

        // Ask user to input a number
        System.out.println("Please enter a number:");
        double number_task2 = scannerDouble.nextDouble();

        // use the method
        signOfNumber(number_task2);

        // Task 3 - implementation of getMiddleCharacter method
        System.out.println("--- TASK 3 ---");

        // Ask user to input a number
        System.out.println("Please enter a string:");
        String inputString = scannerString.nextLine();

        System.out.println("Do you want to remove white space? (enter: true/false)");
        boolean removeWhiteSpace = scannerBoolean.nextBoolean();

        System.out.println("If string length is even, do you want to choose the right hand side character? (enter: true/false)");
        boolean chooseRightChar = scannerBoolean.nextBoolean();

        // use the method
        System.out.println("The middle character is " + getMiddleCharacter(inputString,removeWhiteSpace,chooseRightChar));

        // Task 4 - implementation of getAreaOfTriangle method
        System.out.println("--- TASK 4 ---");

        // Ask user to input three numbers
        System.out.println("Please enter first side length of triangle:");
        double sideOne = scannerDouble.nextDouble();
        System.out.println("Please enter second side length of triangle:");
        double sideTwo = scannerDouble.nextDouble();
        System.out.println("Please enter third side length of triangle:");
        double sideThree = scannerDouble.nextDouble();

        // use the method
        System.out.println("Input Side-1: "+sideOne);
        System.out.println("Input Side-2: "+sideTwo);
        System.out.println("Input Side-3: "+sideThree);
        System.out.println("The area of the triangle is "+getAreaOfTriangle(sideOne,sideTwo,sideThree));

        // Task 5
        System.out.println("--- TASK 5 ---");

        System.out.println("Please enter password:");
        String password = scannerString.nextLine();

        System.out.println("Is the password valid: "+isValidPassword(password));

        // Task 6
        System.out.println("--- TASK 6 ---");

        System.out.println("Please enter a number:");
        int maximumNumber = scannerInt.nextInt();
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
    // NOT USED IN PROGRAM SINCE ITS OUTPUT IS CONTAINED IN OVERLOADED METHOD
    public static char getMiddleCharacter(String inputString){
        int lengthOfStringMinusOne = inputString.length()-1;
        int middleIndex = lengthOfStringMinusOne/2; // note we use integer division
        return inputString.charAt(middleIndex);
    }

    // Returns the middle character of a string,
    // and takes a string as input, a boolean variable to control,
    // whether we want to include or exclude whitespace, and a boolean to choose
    // if we want left or right char whenever the string has an even length.
    public static char getMiddleCharacter(String inputString, boolean ignoreWhitespace, boolean chooseRightChar){
        // If ignoreWhiteSpace=true, we remove whitespaces
        if(ignoreWhitespace){
            inputString = inputString.replaceAll("\\s", "");
        }
        int lengthOfStringMinusOne = inputString.length()-1;

        // if even and chooseRight==true, then we choose right char
        int middleIndex;
        if((lengthOfStringMinusOne % 2)==1 && chooseRightChar){
            middleIndex = lengthOfStringMinusOne/2 + 1; // note we use integer division
        }else{
            middleIndex = lengthOfStringMinusOne/2; // note we use integer division
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
        boolean isSecretContainedInPassword = toLowerPassword.indexOf("secret") !=-1? true: false;
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