package CONDITIONAL_STATEMENT;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class if_else {  // Main class named "if_else"
    public static void main(String[] args){  // Main method, the entry point of the program
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to read input from the user
        
        System.out.print("Enter your age to check if you are eligible for voting:");  // Asks the user to input their age
        int age = sc.nextInt();  // Reads the integer input from the user (age) and stores it in the 'age' variable
        
        // The 'if-else' conditional statement checks whether the user is eligible to vote
        if(age >= 18){  // If the user's age is greater than or equal to 18
            System.out.print("Yeah! You are eligible for voting.");  // Prints a message if the user is eligible
        }else{  // If the user's age is less than 18
            System.out.print("You are not eligible for voting.");  // Prints a message if the user is not eligible
        }
        
        sc.close();  // Closes the Scanner object to release system resources
    }
}

