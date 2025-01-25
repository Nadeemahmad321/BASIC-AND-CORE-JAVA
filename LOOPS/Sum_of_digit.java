package LOOPS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class Sum_of_digit {  // Main class to calculate the sum of digits
    public static void main(String[] args){  // The main method where the program starts
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to take input from the user
        
        // Asking the user to input a number
        System.out.print("Enter the number:");  // Prints a message prompting the user to enter a number
        int number = sc.nextInt();  // Reads the integer value entered by the user and stores it in 'number'
        
        // Main logic to calculate the sum of digits
        int sum = 0;  // Initializes the variable 'sum' to 0, which will hold the sum of digits
        
        // While loop to process each digit of the number
        while(number != 0){  // The loop continues as long as the number is not 0
            int digit = number % 10;  // Gets the last digit of the number using modulus operator (%)
            sum += digit;  // Adds the last digit to the sum
            number /= 10;  // Removes the last digit by dividing the number by 10 (integer division)
        }
        
        // Prints the final sum of digits
        System.out.print("Sum of digits is: " + sum);  // Outputs the sum of the digits
        
        sc.close();  // Closes the scanner object to free system resources
    }
}
