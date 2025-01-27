package OOPS.INHERITANCE;
class Parent {
    String name;
    int age;

    // Constructor for Parent class
    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display person's properties
    void personProperties() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Method to simulate a walk
    void walk() {
        System.out.println(name + " is walking");
    }

}

class Child extends Parent {
    int yearOfBirth;

    // Constructor for Child class
    public Child(String name, int age, int yearOfBirth) {
        super(name, age); // Calling the Parent constructor
        this.yearOfBirth = yearOfBirth;
    }

    // Overriding personProperties method
    @Override
    void personProperties() {
        // Calling the Parent class's method using super()
        super.personProperties(); // Displays the Parent class properties
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println("This is comes from overriden");
        
    }

}

public class Method_overriden {
    public static void main(String[] args) {
        // Creating a Parent object
        System.out.println("Parent information:");
        Parent ramesh = new Parent("Ramesh", 45);
        ramesh.walk(); // Parent's walk method
        ramesh.personProperties(); // Parent's personProperties method        
        // Creating a Child object
        System.out.println("\nChild information:");
        Child rakesh = new Child("Rakesh", 20, 2000);
        rakesh.walk(); // Overridden walk method in Child
        rakesh.personProperties(); // Overridden personProperties method in Child
    }
}
