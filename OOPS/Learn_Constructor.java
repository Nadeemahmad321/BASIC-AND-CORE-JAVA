package OOPS;
// Define a class named Car
class Car {
    // Declare properties (fields) for the Car class
    String make;
    String model;
    int year;

    // Constructor to initialize the car's properties when a new object is created
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display the car's details
    void displayDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
    }
}

// Main class to execute the program
public class Learn_Constructor {
    public static void main(String[] args) {
        // Creating a new Car object and passing the values to the constructor
        Car myCar = new Car("Toyota", "Corolla", 2020);
        
        // Calling the method to display the car's details
        myCar.displayDetails();
    }
}
