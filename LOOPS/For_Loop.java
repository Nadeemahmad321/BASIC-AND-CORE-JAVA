package LOOPS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class For_Loop {  // Main class for the For Loop example
    public static void main(String[] args){  // The main method, where program execution starts
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to get input from the user
        
        // Asking the user for the range of counting
        System.out.print("Enter the range:");  // Prints a prompt asking the user to enter a range
        int range = sc.nextInt();  // Reads the integer input (range) from the user
        
        // Starting the count from 0 to the value of the range
        System.out.print("Counting:");  // Prints the label "Counting:" to indicate the beginning of the loop
        for(int i = 0; i <= range; i++){  // A for loop that starts at i = 0 and counts up to 'range' inclusive
            System.out.print(i);  // Prints the current value of 'i'
            System.out.print(" ");  // Adds a space between the numbers for better formatting
        }
        
        sc.close();  // Closes the scanner object to free resources
    }
}

