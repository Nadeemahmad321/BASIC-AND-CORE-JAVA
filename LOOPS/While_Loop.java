package LOOPS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class While_Loop {  // Main class for the While Loop example
    public static void main(String[] args){  // The main method, where program execution begins
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to capture input from the user
        
        // Asking the user to enter the range for counting
        System.out.print("Enter the range:");  // Prints a message prompting the user for the range
        int range = sc.nextInt();  // Reads the integer value entered by the user (range for counting)
        
        int i = 0;  // Initializes the variable 'i' to 0. This is where the counting starts from.
        
        // Starting the counting process using a while loop
        System.out.print("Counting:");  // Prints "Counting:" to indicate the start of the loop output
        while(i <= range){  // While loop that continues as long as 'i' is less than or equal to the specified range
            System.out.print(i);  // Prints the current value of 'i'
            System.out.print(" ");  // Prints a space between numbers for better readability
            i++;  // Increments the value of 'i' by 1 in each iteration of the loop
        }
        sc.close();
    }
}

