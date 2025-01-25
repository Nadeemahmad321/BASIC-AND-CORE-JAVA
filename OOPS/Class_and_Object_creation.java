package OOPS;
// Define a class named Dog. A class is like a blueprint for creating objects (like creating a blueprint for a house).
class Dog {
    // Declare three properties (also called fields or attributes) for the Dog class:
    String name;  // To store the dog's name
    int age;      // To store the dog's age
    String color; // To store the dog's color

    // Define a method (function) that simulates the dog barking.
    void bark() {
        // This will print the dog's name and the message "is barking".
        System.out.println(name + " is barking");
    }

    // Define another method that simulates the dog walking.
    void walk() {
        // This will print the dog's name and the message "is walking".
        System.out.println(name + " is walking");
    }

    // Define a method that prints the dog's age.
    void age() {
        // This will print the dog's name and its age.
        System.out.println(name + " age is " + age);
    }

    // Define a method that prints the dog's color.
    void color() {
        // This will print the dog's name and its color.
        System.out.println(name + " color is " + color);
    }
}

// The main class where the program starts execution.
public class Class_and_Object_creation {
    public static void main(String[] args) {
        // Create the first dog object (an instance of the Dog class).
        Dog dog_1 = new Dog(); // "dog_1" is an object of the Dog class.
        dog_1.name = "Tommy";  // Set the dog's name to "Tommy".
        dog_1.color = "Black"; // Set the dog's color to "Black".
        dog_1.age = 5;         // Set the dog's age to 5.
        
        // Call the methods on dog_1:
        dog_1.bark();  // This will print "Tommy is barking".
        dog_1.color(); // This will print "Tommy color is Black".
        dog_1.age();   // This will print "Tommy age is 5".

        // Create the second dog object (another instance of the Dog class).
        Dog dog_2 = new Dog(); // "dog_2" is another object of the Dog class.
        dog_2.name = "Leo";    // Set the dog's name to "Leo".
        
        // Call the walk method on dog_2:
        dog_2.walk();          // This will print "Leo is walking".
    }
}
