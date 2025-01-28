### Explanation:

- **Autoboxing**: The automatic conversion of a primitive type (e.g., `int`) into a corresponding wrapper class (e.g., `Integer`).
- **Unboxing**: The automatic conversion of a wrapper class object (e.g., `Integer`) back to its corresponding primitive type (e.g., `int`).

---

### `README.md` on Wrapper Classes, Autoboxing, and Unboxing

# Wrapper Classes, Autoboxing, and Unboxing in Java

## Overview

In Java, **wrapper classes** allow primitive data types (such as `int`, `char`, `float`, etc.) to be represented as objects. These wrapper classes are part of the `java.lang` package and are used for manipulating primitive types as objects. The process of automatically converting between primitives and wrapper objects is known as **autoboxing** and **unboxing**.

## Table of Contents

1. [What are Wrapper Classes?](#what-are-wrapper-classes)
2. [Autoboxing](#autoboxing)
3. [Unboxing](#unboxing)
4. [Advantages of Wrapper Classes](#advantages-of-wrapper-classes)
5. [Example Code](#example-code)

## What are Wrapper Classes?

Wrapper classes in Java are classes that encapsulate (wrap) primitive data types into objects. These classes provide useful methods to manipulate primitive data types as objects.

The wrapper classes for the primitive types are as follows:

- `int` → `Integer`
- `char` → `Character`
- `double` → `Double`
- `float` → `Float`
- `boolean` → `Boolean`
- `long` → `Long`
- `byte` → `Byte`
- `short` → `Short`

### Example:

```java
int primitiveInt = 5;
Integer wrappedInt = new Integer(primitiveInt); // Wrapping primitive int into Integer object
```

## Autoboxing

**Autoboxing** is the automatic conversion of a primitive type to its corresponding wrapper class. In Java, the compiler can automatically perform this conversion when you assign a primitive type to a wrapper class.

For example:

```java
int primitiveInt = 10;
Integer wrapperInt = primitiveInt;  // Autoboxing: int to Integer
```

In the example above, the primitive `int` is automatically converted into an `Integer` object.

### Example:

```java
Integer obj = 12;  // Autoboxing
```

The compiler automatically converts the `int` value `12` into an `Integer` object.

## Unboxing

**Unboxing** is the reverse process, where a wrapper class object is automatically converted into its corresponding primitive type.

For example:

```java
Integer wrapperInt = new Integer(10);
int primitiveInt = wrapperInt;  // Unboxing: Integer to int
```

In the example above, the `Integer` object is automatically converted into a primitive `int`.

### Example:

```java
int age = obj_1;  // Unboxing
```

Here, the `Integer` object `obj_1` is automatically converted back into a primitive `int` value.

## Advantages of Wrapper Classes

1. **Nullability**: Primitive types cannot be `null`, but wrapper classes can. This is useful when you need to represent a value that might not be available (e.g., in databases).

   ```java
   Integer obj = null; // valid for wrapper class
   int primitiveInt = null; // error
   ```

2. **Use with Collections**: Java collections (like `ArrayList`) can store only objects, not primitive types. So, you use wrapper classes to store primitives in collections.

   ```java
   ArrayList<Integer> list = new ArrayList<>();
   list.add(10); // Autoboxing occurs here
   ```

3. **Utility Methods**: Wrapper classes come with useful utility methods, such as parsing strings into numbers, converting numbers to strings, etc.

   ```java
   String numberString = "100";
   int number = Integer.parseInt(numberString); // Converts string to int
   ```

## Example Code

The following code demonstrates both autoboxing and unboxing in Java:

```java
package WRAPPER_CLASSES;

public class Auto_Boxing_and_Unboxing {
    public static void main(String[] args) {
        // Creating an Integer object using the constructor (not recommended for modern code)
        Integer obj_1 = new Integer(12);

        // Creating an Integer object using the static valueOf method (preferred)
        Integer obj_2 = Integer.valueOf(12);

        // Autoboxing: Converting a primitive int to an Integer object automatically
        Integer obj = 12; // Autoboxing happens here

        // Unboxing: Converting an Integer object to a primitive int automatically
        int age = obj_1; // Unboxing happens here

        System.out.println("Autoboxed Integer: " + obj);
        System.out.println("Unboxed value: " + age);
    }
}
```

### Output:

```
Autoboxed Integer: 12
Unboxed value: 12
```

### Explanation:

- **Autoboxing** happens when the primitive `int` (value `12`) is automatically converted to an `Integer` object.
- **Unboxing** happens when the `Integer` object `obj_1` is automatically converted to a primitive `int`.

## Conclusion

Wrapper classes in Java allow primitive types to be treated as objects. Autoboxing and unboxing make the conversion between primitive types and their corresponding wrapper classes seamless, improving the readability and convenience of Java code. By understanding how autoboxing and unboxing work, you can work effectively with both primitive types and objects in Java.
