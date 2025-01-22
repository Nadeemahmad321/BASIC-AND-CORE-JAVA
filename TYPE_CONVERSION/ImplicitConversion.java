// Define the package for the class (optional, helps organize code)
package TYPE_CONVERSION;

// Declare the class named 'ImplicitConversion'
public class ImplicitConversion {

    // Main method: the entry point of the program
    public static void main(String[] args){

        // Declare an integer variable and initialize it with a value
        int number = 10;  // 'int' is a 32-bit integer type, and 'number' is assigned the value 10

        // Implicit type conversion (also known as type promotion):
        // The 'int' variable 'number' is assigned to a 'long' variable 'num2'.
        // In this case, the 'int' value is automatically converted to a 'long' by Java.
        long num2 = number;  // Implicit conversion from 'int' to 'long' happens automatically by Java
        
        // Print the value of 'num2' which is of type 'long'
        System.out.println(num2);  // Output: 10
    }
}
