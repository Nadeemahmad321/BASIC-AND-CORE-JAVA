# Java Inheritance and Method Overriding

## Introduction

Inheritance is one of the core concepts of Object-Oriented Programming (OOP). It allows a class (called the **child class** or **subclass**) to inherit the properties and methods of another class (called the **parent class** or **superclass**). This helps in code reusability and creates a hierarchical relationship between classes.

In Java, inheritance is implemented using the `extends` keyword, and method overriding allows a subclass to provide a specific implementation of a method already defined in its parent class.

This guide will explain **Single Inheritance** and **Method Overriding** in Java.

## Key Concepts

### 1. **Inheritance**

Inheritance allows a class to inherit properties and behaviors (methods) from another class. This allows the child class to reuse code from the parent class and add its own functionality.

- **Parent Class (Superclass)**: The class whose properties and methods are inherited.
- **Child Class (Subclass)**: The class that inherits the properties and methods from the parent class.

#### Syntax:

```java
class Parent {
    // Parent class code
}

class Child extends Parent {
    // Child class code
}
```

### 2. **Method Overriding**

Method overriding happens when a subclass provides its own implementation for a method that is already defined in the parent class. This enables a subclass to modify the behavior of a method.

- The method signature (method name, return type, and parameters) in the child class must be the same as the method in the parent class.
- The `@Override` annotation is commonly used to indicate that a method is being overridden.

#### Example of Method Overriding:

In the parent class, you might have a method `display()`:

```java
class Parent {
    void display() {
        System.out.println("Display method in Parent class");
    }
}
```

In the child class, you override the `display()` method to provide its own behavior:

```java
class Child extends Parent {
    @Override
    void display() {
        System.out.println("Display method in Child class");
    }
}
```

### 3. **Super Keyword**

In Java, `super` is used within a subclass to refer to its parent class. It can be used to:

- Call the parent class constructor.
- Access parent class methods and fields.

For example, to call a method from the parent class within an overridden method in the child class:

```java
class Child extends Parent {
    @Override
    void display() {
        super.display(); // Calls the Parent class's display method
        System.out.println("Display method in Child class");
    }
}
```

## Example of Single Inheritance

Single inheritance refers to the inheritance where one class inherits from another. In the following example:

- The **Parent** class has basic properties like `name` and `age`.
- The **Child** class inherits from the **Parent** class and adds its own properties like `yearOfBirth`.

### Steps:

1. **Create a Parent class**: The parent class will have common properties and methods like `name`, `age`, and a method `personProperties()`.
2. **Create a Child class**: The child class inherits from the parent class, and it can either use the parent class methods or override them.
3. **Override methods in the Child class**: You can override methods such as `personProperties()` to add more specific behavior for the child class.

### Key Points:

- **Single Inheritance**: A child class can inherit from only one parent class, forming a single inheritance chain.
- **Method Overriding**: The child class can provide its specific implementation of a method, which is already defined in the parent class.

## Advantages of Inheritance

1. **Code Reusability**: Inheritance allows you to reuse existing code from the parent class, reducing redundancy and making the code easier to maintain.
2. **Extensibility**: By inheriting from a parent class, you can easily add new functionalities in the child class without modifying the parent class.
3. **Method Overriding**: Subclasses can modify the behavior of methods defined in the parent class, offering greater flexibility and customization in behavior.

## Conclusion

Inheritance is one of the pillars of OOP, and it plays an essential role in promoting code reuse and creating an organized and hierarchical structure in your programs. Method overriding allows subclasses to adapt and customize behavior defined in parent classes, giving you greater control over method functionality.

In this guide, we've covered **Single Inheritance** and **Method Overriding** with examples, and we've also explored how the `super` keyword helps in accessing methods and properties from the parent class. By understanding these concepts, you'll be able to write more modular, maintainable, and extensible Java programs.
