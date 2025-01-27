# Java Encapsulation

## Introduction

Encapsulation is one of the four fundamental principles of Object-Oriented Programming (OOP), along with inheritance, polymorphism, and abstraction. Encapsulation is the practice of keeping fields (properties) within a class private and providing access to them via public methods (getters and setters).

By using encapsulation, you can:

- Protect the internal state of an object from unintended modification.
- Hide the complexity of an object from the outside world.
- Control access to an object's data.

In Java, encapsulation is implemented by:

1. Declaring fields as private.
2. Providing public getter and setter methods to access and modify the fields.

## Key Concepts

### 1. **Private Fields**

In encapsulation, we make the fields of a class **private** so that they cannot be directly accessed or modified from outside the class. This ensures that the internal state of an object is protected.

```java
class Person {
    private String name;
    private int age;
}
```

### 2. **Public Getter and Setter Methods**

To allow controlled access to the private fields, we provide **getter** and **setter** methods. A getter method retrieves the value of a field, while a setter method allows modification of the field.

```java
class Person {
    private String name;
    private int age;

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age
    public void setAge(int age) {
        if (age > 0) {  // Validation check
            this.age = age;
        } else {
            System.out.println("Age cannot be negative or zero");
        }
    }
}
```

### 3. **Benefits of Encapsulation**

- **Control**: The class can control how its fields are accessed and modified, preventing unintended changes.
- **Flexibility**: Encapsulation allows the class to change its internal implementation without affecting the external interface.
- **Data Validation**: The setter methods allow validation checks before data is updated.
- **Security**: By keeping fields private, encapsulation protects the object’s internal state and avoids unauthorized access.

## Example of Encapsulation in Java

Here is an example to demonstrate how encapsulation is implemented in Java:

```java
class Employee {
    // Private fields
    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }

    // Setter method for salary
    public void setSalary(double salary) {
        if (salary > 0) {  // Validating the salary before setting it
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative or zero");
        }
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee Salary: $" + getSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp = new Employee("John Doe", 50000);

        // Accessing the private fields through getters
        System.out.println("Initial Employee Details:");
        emp.displayEmployeeDetails();

        // Modifying the fields using setters
        emp.setName("Jane Smith");
        emp.setSalary(55000);

        // Displaying the updated employee details
        System.out.println("\nUpdated Employee Details:");
        emp.displayEmployeeDetails();

        // Trying to set an invalid salary
        emp.setSalary(-1000);  // This should display a validation message
    }
}
```

### Explanation:

- **Private Fields**: The `name` and `salary` fields in the `Employee` class are private. They cannot be directly accessed from outside the class.
- **Getter Methods**: The `getName()` and `getSalary()` methods are public, allowing access to the private fields.
- **Setter Methods**: The `setName()` and `setSalary()` methods are public and allow modification of the private fields. The setter for `salary` includes a validation check to ensure the salary is a positive value.
- **Encapsulation Benefits**: The `Employee` class provides controlled access to its data. Even though the `name` and `salary` fields are private, the user can interact with them through the public getter and setter methods.

### Output:

```
Initial Employee Details:
Employee Name: John Doe
Employee Salary: $50000.0

Updated Employee Details:
Employee Name: Jane Smith
Employee Salary: $55000.0
Salary cannot be negative or zero
```

## Advantages of Encapsulation

1. **Data Hiding**: By making the fields private, we prevent external entities from accessing or modifying the internal data directly.
2. **Maintainability**: Changes to the internal implementation (like changing the data type of a field) do not affect the external code that uses the class. As long as the getter and setter methods remain the same, the external code remains unchanged.
3. **Control over Data**: You can add validation logic in the setter methods to ensure that only valid data is set. This improves the integrity of the data.
4. **Increased Flexibility**: If the internal representation of the data needs to change, you can modify the code without affecting the users of the class.
5. **Security**: You can control who can access or modify the data using access modifiers (like `private`, `public`, and `protected`).

## Conclusion

Encapsulation is one of the core principles of Object-Oriented Programming and is fundamental to writing robust and maintainable code. It provides better control over an object's data by hiding its internal state and exposing the data only through getter and setter methods. Encapsulation enhances security, reduces complexity, and allows you to validate data before it's set.

In this guide, we've explained the concept of **Encapsulation in Java**, demonstrated how to implement it with practical examples, and discussed its advantages in software design.

By properly using encapsulation, you can create more secure, modular, and flexible Java applications.
