package STRINGS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class Concate {  // Main class to demonstrate string concatenation
    public static void main(String[] args){  // Main method where program execution starts
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to take user input

        // Asking the user to input the first name
        System.out.print("Enter the first name:");  // Prints prompt for the user to enter the first name
        String firstName = sc.next();  // Reads the first name from the user and stores it in 'firstName'

        // Asking the user to input the last name
        System.out.print("Enter the last name:");  // Prints prompt for the user to enter the last name
        String lastName = sc.next();  // Reads the last name from the user and stores it in 'lastName'

        // String Concatenation: Combining the first name, a space, and the last name to form the full name
        String fullName = firstName + " " + lastName;  // Concatenates the first name, a space, and the last name

        // Printing the full name using concatenation
        System.out.print("Full Name: " + fullName);  // Prints the full name to the console

        sc.close();  // Closes the Scanner object to free system resources
    }
}

