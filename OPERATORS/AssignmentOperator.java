package OPERATORS;
import java.util.Scanner;

public class AssignmentOperator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // Enter the first number
        System.out.print("Enter the first number: ");
        int num_1 = sc.nextInt();
        
        // Enter the second number
        System.out.print("Enter the second number: ");
        int num_2 = sc.nextInt();

        // The '+=' is an assignment operator used for addition
        num_1 += num_2;  // Adds num_2 to num_1 and stores the result in num_1
        System.out.println("Addition (num_1 += num_2): " + num_1);  // Prints the result of addition
        
        num_1 -= num_2;  // Subtracts num_2 from num_1 and stores the result in num_1
        System.out.println("Subtraction (num_1 -= num_2): " + num_1);  // Prints the result of subtraction
        
        num_1 *= num_2;  // Multiplies num_1 by num_2 and stores the result in num_1
        System.out.println("Multiplication (num_1 *= num_2): " + num_1);  // Prints the result of multiplication
        
        num_1 /= num_2;  // Divides num_1 by num_2 and stores the result in num_1
        System.out.println("Division (num_1 /= num_2): " + num_1);  // Prints the result of division
        
        num_1 %= num_2;  // Finds the remainder of num_1 divided by num_2 and stores it in num_1
        System.out.println("Modulo (num_1 %= num_2): " + num_1);  // Prints the result of modulo
        
        // Close the scanner to avoid resource leak
        sc.close();  
    }
}

