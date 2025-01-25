package ARRAYS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class Creation_of_array {  // Main class for array creation and input
    public static void main(String[] args){  // Array creation
        // Here, we are creating an array of integers with a size of 10.
        try ( // The main method where the program starts
                Scanner sc = new Scanner(System.in) // Creates a new Scanner object 'sc' to take input from the user
        ) {
            // Array creation
            // Here, we are creating an array of integers with a size of 10.
            int arr[] = new int[10];  // Creates an array of integers with space for 10 elements
            // Asking the user to input elements for the array
            System.out.println("Enter the element of array:");  // Prints a prompt for the user to enter elements
            // Loop to read 10 elements from the user and store them in the array
            for(int i = 0; i < 10; i++){  // Loop runs 10 times (for array size 10)
                arr[i] = sc.nextInt();  // Reads the next integer input and stores it in the array at index 'i'
            }   // Printing the elements of the array
            System.out.println("Array elements are:");  // Prints a label for the array output
            for (int i = 0; i < 10; i++) {
                // Loop runs to print each element of the array
                System.out.print(arr[i] + " ");  // Prints each element followed by a space
            }
            // Closes the scanner object to free system resources
        } // Creates an array of integers with space for 10 elements
    }
}

