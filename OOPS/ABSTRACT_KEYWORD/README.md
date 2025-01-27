# Understanding the `abstract` Keyword in Java

## Introduction

In Java, the `abstract` keyword is used to define classes and methods that are intended to be used as a blueprint for other classes. It provides the ability to define methods and properties without specifying the implementation in the abstract class itself. This concept is central to **Object-Oriented Programming (OOP)**, especially when dealing with inheritance and polymorphism.

## Abstract Classes

An abstract class is a class that cannot be instantiated directly. It may contain abstract methods (methods without a body), as well as regular methods with implementations. A class that contains at least one abstract method must also be declared abstract.

### Key Points:

- An **abstract class** can have both abstract and concrete methods.
- **Abstract methods** do not have a body and must be implemented by subclasses.
- Abstract classes are useful for creating a common interface for subclasses while allowing them to implement specific behavior.

### Syntax:

```java
abstract class ClassName {
    // Abstract method (does not have a body)
    abstract void abstractMethod();

    // Regular method (can have a body)
    void regularMethod() {
        System.out.println("This is a regular method.");
    }
}
```

## Abstract Methods

An abstract method is a method that is declared in an abstract class but does not have any implementation. Any subclass that extends an abstract class must provide an implementation for all the abstract methods, unless the subclass is also abstract.

### Syntax:

```java
abstract class ClassName {
    // Abstract method
    abstract void methodName();
}
```

## Example of Using the `abstract` Keyword

### Abstract Class and Subclass Example:

```java
abstract class Vehicle {
    // Abstract method
    abstract void accelerate();

    // Abstract method
    abstract int brakes(int wheels);
}

class Car extends Vehicle {
    // Implementing the abstract methods in the subclass
    @Override
    void accelerate() {
        System.out.println("Car is accelerating");
    }

    @Override
    int brakes(int wheels) {
        return wheels; // Simply returns the number of wheels
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an instance of 'Car'
        Car car_1 = new Car();

        // Calling the 'accelerate' method
        car_1.accelerate();

        // Calling the 'brakes' method and printing the result
        int wheels = car_1.brakes(4);
        System.out.println("Number of wheels: " + wheels);
    }
}
```

### Output:

```
Car is accelerating
Number of wheels: 4
```

## Benefits of Abstract Classes

1. **Code Reusability**: You can define common behavior in an abstract class, which can then be reused by subclasses.
2. **Enforcing Standards**: By using abstract methods, you enforce that subclasses must implement specific methods, ensuring a consistent API.
3. **Flexibility**: Abstract classes allow you to define methods without knowing how they will be implemented in subclasses.

## When to Use the `abstract` Keyword

- When you have a base class with some shared behavior, but you want to leave certain details for subclasses to define.
- When you want to define a common interface (a set of methods) that must be implemented by all subclasses.
- When you want to prevent direct instantiation of a class and ensure that it is only used as a parent class.

## Conclusion

The `abstract` keyword is a powerful feature in Java that enables developers to design more flexible and reusable code. It allows you to define incomplete classes or methods that must be completed in subclasses, providing a foundation for polymorphism and inheritance. Using abstract classes correctly can help enforce coding standards and provide cleaner, more maintainable code.
