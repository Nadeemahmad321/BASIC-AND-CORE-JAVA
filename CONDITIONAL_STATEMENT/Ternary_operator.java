package CONDITIONAL_STATEMENT;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class for reading user input

public class Ternary_operator {  // Main class named "Ternary_operator"
    public static void main(String[] args){  // Main method where program execution starts
        Scanner sc = new Scanner(System.in);  // Creates a Scanner object 'sc' for reading input from the user
        
        // Prompt the user to enter the first number
        System.out.print("Enter the first number:");  
        int firstNumber = sc.nextInt();  // Reads the first number inputted by the user
        
        // Prompt the user to enter the second number
        System.out.print("Enter the second number:");  
        int secondNumber = sc.nextInt();  // Reads the second number inputted by the user
        
        // Prompt the user to enter the third number
        System.out.print("Enter the third number:");  
        int thirdNumber = sc.nextInt();  // Reads the third number inputted by the user
        
        // Using the ternary operator to determine the greatest number
        String result = (firstNumber > secondNumber  // First check: Is firstNumber greater than secondNumber?
            ? ((firstNumber > thirdNumber)  // If true, then check if firstNumber is also greater than thirdNumber
                ? "First number is greater"  // If both conditions are true, assign "First number is greater"
                : "Third number is greater")  // If firstNumber is not greater than thirdNumber, assign "Third number is greater"
            : (secondNumber > thirdNumber)  // If the first condition is false, check if secondNumber is greater than thirdNumber
            ? "Second number is greater"  // If true, assign "Second number is greater"
            : "Third number is greater");  // If secondNumber is not greater than thirdNumber, assign "Third number is greater"
        
        System.out.print(result);  // Print the result (which contains the largest number's description)
        
        sc.close();  // Close the Scanner object to free resources
    }
}

