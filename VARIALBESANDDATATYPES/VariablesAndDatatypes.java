// Define the package for the class (optional, helps organize code)
package VARIALBESANDDATATYPES;

// Declare the class named 'VariablesAndDatatypes'
public class VariablesAndDatatypes {

    // Main method: the entry point of the program
    public static void main(String[] args){

        // Declare an integer variable to store the age of a person
        int age = 20;  // 'int' is used for whole numbers (no decimal places)

        // Declare a floating-point variable to store a number with decimals
        float number = 20.3f;  // 'float' is used for numbers with decimals, and 'f' is added to specify it's a float

        // Declare a byte variable to store marks (smaller range than 'int')
        byte marks = 21;  // 'byte' is used for small integers (range -128 to 127)

        // Declare a char variable to store a single character
        char letter = 'A';  // 'char' is used to store a single character enclosed in single quotes

        // Declare a String variable to store text (a sequence of characters)
        String name = "Nadeem Ahmad";  // 'String' is used for text, enclosed in double quotes

        // Declare a boolean variable to store true or false value
        boolean isPass = true;  // 'boolean' is used for true/false values

        // Declare a short variable to store the price (smaller range than 'int')
        short price = 220;  // 'short' is used for integers with a smaller range (-32,768 to 32,767)

        // Declare a long variable to store a large number (larger range than 'int')
        long number2 = 773987161L;  // 'long' is used for very large integers, and 'L' is added to specify it's a long

        // Corrected and improved print statements reflecting the variable names and data types

        // Print values with their corresponding data type
        System.out.println("Data Type: int, Value: " + age);           // Print age (int)
        System.out.println("Data Type: float, Value: " + number);     // Print floating-point number (float)
        System.out.println("Data Type: byte, Value: " + marks);       // Print marks (byte)
        System.out.println("Data Type: char, Value: '" + letter + "'");  // Print character (char)
        System.out.println("Data Type: String, Value: \"" + name + "\""); // Print name (String)
        System.out.println("Data Type: boolean, Value: " + isPass);   // Print pass status (boolean)
        System.out.println("Data Type: short, Value: " + price);      // Print price (short)
        System.out.println("Data Type: long, Value: " + number2);     // Print large number (long)
    }
}
