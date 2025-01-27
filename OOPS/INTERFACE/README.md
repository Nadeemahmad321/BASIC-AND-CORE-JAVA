# Java Interface and Multiple Inheritance Example

## Introduction

This project demonstrates the key concepts of **abstraction**, **interfaces**, and **multiple inheritance** in Java. These concepts are foundational to Object-Oriented Programming (OOP) and allow for more modular, flexible, and maintainable code.

### Concepts Covered:

- **Abstraction** using interfaces
- **Interfaces** for defining common behaviors
- **Multiple Inheritance** in Java via interfaces
- Concrete implementations in Java classes

## Key Concepts

### 1. **Abstraction**

Abstraction is a fundamental concept in OOP that allows us to define "what" an object can do without specifying "how" it does it. In Java, abstraction is achieved using **abstract classes** or **interfaces**.

- **Interfaces**: Define a contract (i.e., method signatures) that classes must follow, but do not provide method implementations. This is a perfect example of abstraction because the actual logic is deferred to the implementing class.

### 2. **Interfaces**

An **interface** is like a contract that specifies what methods a class should implement, without providing the actual logic. Any class that implements an interface is required to provide concrete implementations for the methods defined in that interface.

```java
interface Vehicle {
    void move();  // Abstract method
    void carryPassengers(int passengers);  // Abstract method
}
```

### 3. **Multiple Inheritance via Interfaces**

Java does **not** support multiple inheritance with classes (a class cannot extend more than one class). However, **multiple inheritance** is possible with interfaces. A class can implement **multiple interfaces**, thereby inheriting behaviors (methods) from multiple sources.

#### Highlighting Multiple Inheritance:

In this project, the `Boat` class implements both the `Vehicle` and `WaterVehicle` interfaces. This demonstrates **multiple inheritance** in Java, where a single class can inherit methods from more than one interface.

```java
interface WaterVehicle {
    void floatOnWater();  // Abstract method for water-based behavior
}

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
```

In the `Boat` class:

- We are implementing **two interfaces**: `Vehicle` (for common vehicle behavior) and `WaterVehicle` (for behaviors specific to water-based vehicles).
- This showcases multiple inheritance in action, where the `Boat` inherits methods from both interfaces and provides its own implementation.

### 4. **Concrete Class Implementations**

Once interfaces are defined, concrete classes like `Car` and `Boat` implement the interfaces and provide the logic for the methods declared in the interfaces.

```java
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
```

Here, the `Car` class implements the `Vehicle` interface, providing concrete implementations for the `move()` and `carryPassengers()` methods.

## Code Example

Here is the complete code example demonstrating **interfaces**, **abstraction**, and **multiple inheritance**:

```java
package OOPS.INTERFACE;

interface Vehicle {
    void move();
    void carryPassengers(int passengers);
}

interface WaterVehicle {
    void floatOnWater();
}

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

public class InterfaceExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        car.carryPassengers(4);

        System.out.println();

        Boat boat = new Boat();
        boat.move();
        boat.carryPassengers(6);
        boat.floatOnWater();
    }
}
```

### Output:

```
The car is moving on the road.
The car is carrying 4 passengers.

The boat is moving on the water.
The boat is carrying 6 passengers.
The boat is floating on the water.
```

### Explanation:

- The **`Car`** class implements the `Vehicle` interface, so it must provide concrete implementations for the `move()` and `carryPassengers()` methods.
- The **`Boat`** class implements both the `Vehicle` and `WaterVehicle` interfaces, so it must provide concrete implementations for all the methods in both interfaces, demonstrating **multiple inheritance**.

### Multiple Inheritance in Action:

- The `Boat` class inherits behaviors from both the `Vehicle` interface and the `WaterVehicle` interface. This is possible because Java allows **multiple inheritance through interfaces**, meaning a class can implement more than one interface.
- **Key Point**: This is **different from** class inheritance in Java, where a class can only extend **one superclass**.

## Conclusion

This project provides a clear example of how **interfaces** in Java enable the concepts of **abstraction** and **multiple inheritance**:

- **Abstraction** is demonstrated by defining methods in interfaces without implementing them in the interface itself.
- **Multiple inheritance** is achieved by implementing multiple interfaces in a single class, allowing the class to inherit methods from more than one source.
- This design pattern promotes modularity and flexibility, making it easy to extend functionality without modifying existing code.
