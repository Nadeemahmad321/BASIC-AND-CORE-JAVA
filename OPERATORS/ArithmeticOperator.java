package OPERATORS;
import java.util.Scanner;

public class ArithmeticOperator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // Enter the first number
        System.out.print("Enter the first number: ");
        int num_1 = sc.nextInt();
        
        // Enter the second number
        System.out.print("Enter the second number: ");
        int num_2 = sc.nextInt();
        
        // Addition result is stored in the 'add' variable
        int add = num_1 + num_2;

        // Subtraction result is stored in the 'subtraction' variable
        int subtraction = num_1 - num_2;

        // Multiplication result is stored in the 'mul' variable
        int mul = num_1 * num_2;
        
        // Division result is stored in the 'div' variable
        double div = (double)num_1 / num_2;  // Integer division
        
        // Modulo result (remainder after division) is stored in the 'mod' variable
        int mod = num_1 % num_2;

        // Display the result of addition
        System.out.println("Addition of two numbers is: " + add);

        // Display the result of subtraction
        System.out.println("Subtraction of two numbers is: " + subtraction);

        // Display the result of multiplication
        System.out.println("Multiplication of two numbers is: " + mul);
        
        // Display the result of division
        System.out.println("Division of two numbers is: " + div);
        
        // Display the result of modulo
        System.out.println("Modulo (remainder) of two numbers is: " + mod);
        
        // Close the scanner to avoid resource leak
        sc.close();
    }
}
