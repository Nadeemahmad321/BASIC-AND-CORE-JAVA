package OOPS.INTERFACE;

// Defining an interface 'Vehicle' to represent common behaviors for all vehicles
interface Vehicle {
    // Abstract method to represent the ability to move
    void move();
    
    // Abstract method to represent the ability to carry passengers
    void carryPassengers(int passengers);
}

// Defining an interface 'WaterVehicle' for vehicles that move on water
interface WaterVehicle {
    // Abstract method to represent the ability to float
    void floatOnWater();
}

// The class 'Car' implements the 'Vehicle' interface to represent a land vehicle
class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("The car is moving on the road.");
    }

    @Override
    public void carryPassengers(int passengers) {
        System.out.println("The car is carrying " + passengers + " passengers.");
    }
}

// The class 'Boat' implements both 'Vehicle' and 'WaterVehicle' interfaces
class Boat implements Vehicle, WaterVehicle {
    @Override
    public void move() {
        System.out.println("The boat is moving on the water.");
    }

    @Override
    public void carryPassengers(int passengers) {
        System.out.println("The boat is carrying " + passengers + " passengers.");
    }

    @Override
    public void floatOnWater() {
        System.out.println("The boat is floating on the water.");
    }
}

public class Interface {
    public static void main(String[] args) {
        // Creating an instance of 'Car'
        Car car = new Car();
        car.move();  // Calls the 'move' method from Vehicle interface
        car.carryPassengers(4);  // Calls the 'carryPassengers' method from Vehicle interface
        
        System.out.println();

        // Creating an instance of 'Boat'
        Boat boat = new Boat();
        boat.move();  // Calls the 'move' method from Vehicle interface
        boat.carryPassengers(6);  // Calls the 'carryPassengers' method from Vehicle interface
        boat.floatOnWater();  // Calls the 'floatOnWater' method from WaterVehicle interface
    }
}

