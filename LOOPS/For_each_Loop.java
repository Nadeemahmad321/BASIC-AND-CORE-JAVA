package LOOPS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class For_each_Loop {  // Main class to demonstrate the use of a for-each loop
    public static void main(String[] args){  // The main method where the program execution begins
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to read input from the user
        
        // Asking the user to input the size of the array
        System.out.print("Enter the size of array:");  // Prints a prompt for the user to input the size
        int size = sc.nextInt();  // Reads the integer input (size of the array) and stores it in 'size'
        
        sc.nextLine();  // Consumes the leftover newline character from the previous input (from nextInt())
        
        // Create an array of Strings with the specified size
        String names[] = new String[size];  // Initializes the array 'names' to hold 'size' number of String elements
        
        // Loop to take input for each element of the array
        for(int i = 0; i < size; i++){  // The loop runs 'size' number of times (based on the array size)
            System.out.print("Enter the name:");  // Prompts the user to input a name
            names[i] = sc.nextLine();  // Reads the name entered by the user and stores it in the array at index 'i'
        }
        
        // Using a for-each loop to print the elements of the array
        System.out.println("The entered names are:");  // Prints a label before displaying the names
        for(String name : names){  // For-each loop to iterate over each element (name) in the 'names' array
            System.out.println(name);  // Prints each name in the array on a new line
        }
        
        sc.close();  // Closes the Scanner object to free system resources
    }
}
