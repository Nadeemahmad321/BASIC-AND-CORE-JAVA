package FUNCTION;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class Addition {  // Main class for performing addition using a function
    
    // This is a function (method) that takes two integer arguments and returns their sum
    public static int Add(int firstNumber, int secondNumber){  
        int ans = firstNumber + secondNumber;  // Adds the two numbers and stores the result in 'ans'
        return ans;  // Returns the result to the caller
    }

    // The main method where the program starts
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to take input from the user

        // Asking the user to input the first number
        System.out.print("Enter the first number:");  // Prints a prompt for the user to input the first number
        int firstNumber = sc.nextInt();  // Reads the first number input by the user and stores it in 'firstNumber'

        // Asking the user to input the second number
        System.out.print("Enter the second number:");  // Prints a prompt for the user to input the second number
        int secondNumber = sc.nextInt();  // Reads the second number input by the user and stores it in 'secondNumber'

        // Calling the 'Add' function and passing the two numbers to it
        int ans = Add(firstNumber, secondNumber);  // Stores the result of the addition in 'ans'

        // Prints the result of the addition
        System.out.print("Addition of two number is: " + ans);  // Prints the result of the addition

        sc.close();  // Closes the Scanner object to free system resources
    }
}
