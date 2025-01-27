package OOPS.ABSTRACT_KEYWORD;

abstract class Vehicle {
    // Abstract method to be implemented by subclasses
    abstract void accelerate();
    
    // Abstract method to be implemented by subclasses, takes an int parameter (wheels) and returns an int
    abstract int brakes(int wheels);
}

class Car extends Vehicle {
    // Implementing the 'accelerate' method in the 'Car' subclass
    @Override
    void accelerate() {
        System.out.println("Car is accelerating");
    }
    
    // Implementing the 'brakes' method in the 'Car' subclass
    @Override
    int brakes(int wheels) {
        return wheels; // Simply returns the number of wheels as provided
    }
}

public class Abstract {
    public static void main(String[] args) {
        // Creating an instance of 'Car'
        Car car_1 = new Car();
        
        // Calling the 'accelerate' method on the car object
        car_1.accelerate();
        
        // Calling the 'brakes' method with an argument of 4 (wheels), and printing the result
        int wheels = car_1.brakes(4);
        System.out.println("Number od wheels is:" + wheels); // Prints 4
    }
}
