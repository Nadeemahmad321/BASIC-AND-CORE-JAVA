package CONDITIONAL_STATEMENT;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class If {  // Main class named "If"
    public static void main(String[] args){  // Main method that runs the program
        Scanner sc = new Scanner(System.in);  // Creates a Scanner object 'sc' to read input from the user
        
        // Taking age from user
        System.out.print("Enter your age to check if you are eligible for voting:");  // Prompts the user to input their age
        int age = sc.nextInt();  // Reads the age inputted by the user and stores it in the variable 'age'
        
        // Conditional statement to check if the user is eligible for voting
        if(age >= 18){  // Checks if the age is greater than or equal to 18
            System.out.print("Yeah! You are eligible for voting.");  // If the condition is true (age >= 18), it prints that the user is eligible for voting
        }
        
        sc.close();  // Closes the Scanner object to free resources
    }
}

