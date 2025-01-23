package CONDITIONAL_STATEMENT;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class for reading input from the user

public class Nested_if_else {  // Main class named "Nested_if_else"
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
        
        // Start of the nested if-else condition to determine the greatest number
        if(firstNumber > secondNumber){  // If the first number is greater than the second number
            if(firstNumber > thirdNumber){  // Nested if: checks if the first number is greater than the third number
                System.out.print("First number is greater than all numbers.");  // Prints this if the first number is greater than both
            }else{  // If the first number is not greater than the third number
                System.out.print("Third number is greater than all numbers.");  // Prints this if the third number is greater than the first
            }
        }else{  // If the second number is greater than or equal to the first number
            if(secondNumber > thirdNumber){  // Nested if: checks if the second number is greater than the third number
                System.out.print("Second number is greater than all numbers.");  // Prints this if the second number is greater than both
            }else{  // If the second number is not greater than the third number
                System.out.print("Third number is greater than all numbers.");  // Prints this if the third number is greater than the second
            }
        }
        
        sc.close();  // Closes the Scanner object to free system resources
    }
}
