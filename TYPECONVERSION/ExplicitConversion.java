// Define the package for the class (optional, helps organize code)
package TYPECONVERSION;

public class ExplicitConversion {

    // Main method: the entry point of the program
    public static void main(String[] args){

        // Declare a long variable and initialize it with a large value
        long num_1 = 1000000L;  // 'long' is a 64-bit data type, and 'num_1' is assigned a value of 1000000

        // Explicit type conversion (type casting):
        // We are converting the value of 'num_1' (which is of type 'long') to an 'int'.
        // This is done explicitly using a type cast. The '(int)' before 'num_1' tells Java to convert the value.
        int num_2 = (int)num_1;  // Explicit conversion (casting) from 'long' to 'int'
        
        // Print the value of 'num_2' which is of type 'int'
        System.out.println(num_2);  // Output: 1000000
    }
}

