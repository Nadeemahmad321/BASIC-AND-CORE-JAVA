package GENERICS;
// Importing Scanner class from java.util package to read input from the user
import java.util.Scanner;

// Defining a generic class Human which takes a generic type T
class Human<T> {
    // Declaring three instance variables of type T
    T firstName;
    T lastName;
    T location;

    // Constructor to initialize the Human object with firstName, lastName, and location
    public Human(T firstName, T lastName, T location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    // Method to display the properties of the Human object
    public void humanProperties() {
        System.out.println("First Name:" + firstName);  // Prints the first name
        System.out.println("Last Name:" + lastName);    // Prints the last name
        System.out.println("Location:" + location);     // Prints the location
    }
}

// Main class containing the main method
public class Generics {
    public static void main(String[] args) {
        // Creating a Scanner object to get user input
        Scanner Sc = new Scanner(System.in);

        // Prompting the user to enter the first name
        System.out.print("Enter the first name:");
        String firstName = Sc.next();

        // Prompting the user to enter the last name
        System.out.print("Enter the last name:");
        String lastName = Sc.next();

        // Prompting the user to enter the location
        System.out.print("Enter the location:");
        String location = Sc.next();

        // Creating a Human object with the type String and passing the user inputs
        Human<String> person_1 = new Human<>(firstName, lastName, location);

        // Calling the method to display the properties of the Human object
        person_1.humanProperties();
        Sc.close();
    }
}
