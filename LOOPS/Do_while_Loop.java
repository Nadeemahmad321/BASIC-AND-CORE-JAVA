package LOOPS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class Do_while_Loop {  // Main class for the Do-While Loop example
    public static void main(String[] args){  // The main method where the program execution begins
        Scanner sc = new Scanner(System.in);  // Creates a Scanner object 'sc' to take input from the user
        
        // Asking the user to enter the range for counting
        System.out.print("Enter the range:");  // Prints a message asking for the range
        int range = sc.nextInt();  // Reads the integer value entered by the user as 'range'
        
        int i = 0;  // Initializes the variable 'i' to 0, starting point of counting
        
        // Do-while loop to print numbers from 0 to the specified range
        do {  // The loop executes at least once before checking the condition
            System.out.print(i);  // Prints the current value of 'i'
            System.out.print(" ");  // Prints a space to separate the numbers
            i++;  // Increments the value of 'i' by 1
        } while (i <= range);  // Checks if 'i' is less than or equal to the 'range'
        
        sc.close();  // Closes the scanner to free up system resources
    }
}

