package OPERATORS;

import java.util.Scanner;

public class RelationalOperator {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner sc = new Scanner(System.in);
        
        // Ask the user to enter the first number
        System.out.print("Enter the first number: ");
        int num_1 = sc.nextInt();
        
        // Ask the user to enter the second number
        System.out.print("Enter the second number: ");
        int num_2 = sc.nextInt();
        
        // Check if num_1 is equal to num_2
        boolean isEqual = num_1 == num_2;
        
        // Check if num_1 is greater than num_2
        boolean isGreater = num_1 > num_2;
        
        // Check if num_1 is less than num_2
        boolean isLess = num_1 < num_2;
        
        // Check if num_1 is greater than or equal to num_2
        boolean isEqualToOrGreater = num_1 >= num_2;
        
        // Check if num_1 is less than or equal to num_2
        boolean isEqualToOrLess = num_1 <= num_2;
        
        // Print the results of the comparisons
        System.out.println("num_1 is equal to num_2: " + isEqual);
        System.out.println("num_1 is greater than num_2: " + isGreater);
        System.out.println("num_1 is less than num_2: " + isLess);
        System.out.println("num_1 is greater than or equal to num_2: " + isEqualToOrGreater);
        System.out.println("num_1 is less than or equal to num_2: " + isEqualToOrLess);
        
        // Close the scanner to avoid resource leak
        sc.close();
    }
}
