package CONDITIONAL_STATEMENT;  // Defines the package for the class

import java.util.Scanner;  // Imports the Scanner class to read user input

public class IfElseIf {  // Corrected class name to follow proper Java naming conventions (class names should start with a capital letter)
    public static void main(String[] args){  // Main method where the program execution begins
        Scanner sc = new Scanner(System.in);  // Creates a Scanner object 'sc' to read input from the user
        
        // Taking marks as input
        System.out.print("Enter the marks you obtained:");  // Prompts the user to enter their marks
        int marks = sc.nextInt();  // Reads the integer input (marks) and stores it in the variable 'marks'
        
        // Conditional statements to determine the grade based on marks
        if(marks >= 90){  // If the marks are 90 or above
            System.out.print("Grade A");  // Prints "Grade A"
        }else if(marks >= 80 && marks <= 89){  // If the marks are between 80 and 89 (inclusive)
            System.out.print("Grade B");  // Prints "Grade B"
        }else if(marks >= 70 && marks <= 79){  // If the marks are between 70 and 79 (inclusive)
            System.out.print("Grade C");  // Prints "Grade C"
        }else if(marks >= 60 && marks <= 69){  // If the marks are between 60 and 69 (inclusive)
            System.out.print("Grade D");  // Prints "Grade D"
        }else{  // If the marks are below 60
            System.out.print("Fail");  // Prints "Fail"
        }
        
        sc.close();  // Closes the Scanner object to free resources
    }
}

