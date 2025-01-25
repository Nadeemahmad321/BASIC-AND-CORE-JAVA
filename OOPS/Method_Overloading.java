package OOPS;
// Define a class named Greet
class Greet {
    // Define a method named Greeting with no parameters
    void Greeting() {
        // This will print "Hello, Everyone!" when called
        System.out.println("Hello, Everyone!");
    }

    // Define a method named Greeting, but with one String parameter (this is an overloaded version of the above method)
    void Greeting(String name) {
        // This will print "Hello" followed by the name provided when called, e.g., "Hello James"
        System.out.println("Hello " + name);
    }
}

// Main class where the program starts execution
public class Method_Overloading {
    public static void main(String[] args) {
        // Create an object of the Greet class
        Greet p1 = new Greet();

        // Call the first version of Greeting (with no parameters), it will print "Hello, Everyone!"
        p1.Greeting();

        // Call the overloaded version of Greeting (with a String parameter), it will print "Hello James"
        p1.Greeting("James");
    }
}

