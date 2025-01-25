package STRINGS;  // Defines the package where this class belongs

import java.util.Scanner;  // Imports the Scanner class to read user input

public class String_Methods {  // Renamed class to follow naming conventions (class names should be camel case, starting with an uppercase letter)
    public static void main(String[] args) {  // Main method where the program execution starts
        Scanner sc = new Scanner(System.in);  // Creates a new Scanner object 'sc' to take input from the user

        // Asking the user to input the first name
        System.out.print("Enter the first name: ");
        String firstName = sc.nextLine();  // Reads the first name input by the user

        // Asking the user to input the last name
        System.out.print("Enter the last name: ");
        String lastName = sc.nextLine();  // Reads the last name input by the user

        // Displaying both names before applying string methods
        System.out.println("First and Last Name Before using methods:");
        System.out.println(firstName);
        System.out.println(lastName);

        // Applying string methods and displaying the results
        System.out.println("\nFirst and Last Name After using methods:");
        
        // Convert first name to uppercase and last name to lowercase
        System.out.println("First name in uppercase: " + firstName.toUpperCase());
        System.out.println("Last name in lowercase: " + lastName.toLowerCase());

        // Using charAt method to get the character at a specific index
        System.out.println("Third character of first name: " + firstName.charAt(2));

        // Check if the first name starts with "Nad"
        System.out.println("Does the first name start with 'Nad'? " + firstName.startsWith("Nad"));

        // Check if the first name ends with "Nad"
        System.out.println("Does the first name end with 'Nad'? " + firstName.endsWith("Nad"));

        // Using trim() method to remove any leading or trailing whitespace from the string
        System.out.println("First name after trim: '" + firstName.trim() + "'");

        // Demonstrating converting an integer to a string
        int age = 20;
        String ageAsString = String.valueOf(age);  // Converts integer to string
        System.out.println("Age (int): " + age);
        System.out.println("Age as string: " + ageAsString);
        
        // Concatenating a number to the string
        System.out.println("Age as string concatenated with 2: " + ageAsString + 2);

        // Demonstrating string replace method
        String sentence = "I love java";
        System.out.println("\nOriginal sentence: " + sentence);
        System.out.println("Sentence after replacing 'java' with 'cpp': " + sentence.replace("java", "cpp"));

        // Checking if the sentence contains the word "cpp"
        System.out.println("Does the sentence contain 'cpp'? " + sentence.contains("cpp"));

        // Extracting a substring from the sentence
        System.out.println("Substring from index 2 to 4: " + sentence.substring(2, 4));

        // Splitting the sentence into words and printing each word
        String[] words = sentence.split(" ");  // Split the sentence into an array of words
        System.out.print("Words in the sentence: ");
        for (String word : words) {  // Iterate over each word in the array
            System.out.print(word + " ");  // Print each word followed by a space
        }

        // Demonstrating the toCharArray() method
        char[] charArray = firstName.toCharArray();  // Converts the string 'firstName' to a character array
        System.out.println("\nCharacter array of the first name:");
        for (char ch : charArray) {  // Iterate over each character in the array
            System.out.print(ch + " ");  // Print each character followed by a space
        }

        // Demonstrating the isEmpty() method
        System.out.println("\nIs the first name empty? " + firstName.isEmpty());  // Checks if 'firstName' is empty

        sc.close();  // Close the scanner object to free system resources
    }
}
