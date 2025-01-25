# Java Operators

This document explains all the different types of operators available in Java, including **Arithmetic Operators**, **Assignment Operators**, **Relational Operators**, **Logical Operators**, **Unary Operators**, **Bitwise Operators**, **Ternary Operator**, and **Type Comparison Operator**.

## Table of Contents

1. [Arithmetic Operators](#arithmetic-operators)
2. [Assignment Operators](#assignment-operators)
3. [Relational Operators](#relational-operators)
4. [Logical Operators](#logical-operators)
5. [Unary Operators](#unary-operators)
6. [Bitwise Operators](#bitwise-operators)
7. [Ternary Operator](#ternary-operator)
8. [Type Comparison Operator](#type-comparison-operator)

---

## 1. Arithmetic Operators

Arithmetic operators are used to perform basic mathematical operations like addition, subtraction, multiplication, etc.

| Operator | Description         | Example | Output |
| -------- | ------------------- | ------- | ------ |
| `+`      | Addition            | `a + b` | `15`   |
| `-`      | Subtraction         | `a - b` | `5`    |
| `*`      | Multiplication      | `a * b` | `50`   |
| `/`      | Division            | `a / b` | `2`    |
| `%`      | Modulus (remainder) | `a % b` | `0`    |

### Example:

```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("Addition: " + (a + b));       // 15
        System.out.println("Subtraction: " + (a - b));    // 5
        System.out.println("Multiplication: " + (a * b)); // 50
        System.out.println("Division: " + (a / b));       // 2
        System.out.println("Modulus: " + (a % b));        // 0
    }
}
```

````

### Explanation:

- **`+` (Addition):** Adds two operands.
- **`-` (Subtraction):** Subtracts the second operand from the first.
- **`*` (Multiplication):** Multiplies two operands.
- **`/` (Division):** Divides the first operand by the second.
- **`%` (Modulus):** Returns the remainder of the division of the first operand by the second.

---

## 2. Assignment Operators

Assignment operators are used to assign values to variables.

| Operator | Description         | Example  | Output |
| -------- | ------------------- | -------- | ------ |
| `=`      | Simple assignment   | `a = 10` | `10`   |
| `+=`     | Add and assign      | `a += 5` | `15`   |
| `-=`     | Subtract and assign | `a -= 5` | `5`    |
| `*=`     | Multiply and assign | `a *= 5` | `50`   |
| `/=`     | Divide and assign   | `a /= 5` | `2`    |
| `%=`     | Modulus and assign  | `a %= 5` | `0`    |

### Example:

```java
public class AssignmentExample {
    public static void main(String[] args) {
        int a = 10;

        a += 5;  // a = a + 5
        System.out.println("a += 5: " + a);  // 15

        a -= 5;  // a = a - 5
        System.out.println("a -= 5: " + a);  // 10

        a *= 2;  // a = a * 2
        System.out.println("a *= 2: " + a);  // 20

        a /= 5;  // a = a / 5
        System.out.println("a /= 5: " + a);  // 4

        a %= 3;  // a = a % 3
        System.out.println("a %= 3: " + a);  // 1
    }
}
```

### Explanation:

- **`=` (Simple assignment):** Assigns the value of the right operand to the left operand.
- **`+=` (Add and assign):** Adds the right operand to the left operand and assigns the result to the left operand.
- **`-=` (Subtract and assign):** Subtracts the right operand from the left operand and assigns the result to the left operand.
- **`*=` (Multiply and assign):** Multiplies the left operand by the right operand and assigns the result to the left operand.
- **`/=` (Divide and assign):** Divides the left operand by the right operand and assigns the result to the left operand.
- **`%=` (Modulus and assign):** Takes the modulus of the left operand by the right operand and assigns the result to the left operand.

---

## 3. Relational Operators

Relational operators are used to compare two values or expressions.

| Operator | Description              | Example  | Output  |
| -------- | ------------------------ | -------- | ------- |
| `==`     | Equal to                 | `a == b` | `false` |
| `!=`     | Not equal to             | `a != b` | `true`  |
| `>`      | Greater than             | `a > b`  | `true`  |
| `<`      | Less than                | `a < b`  | `false` |
| `>=`     | Greater than or equal to | `a >= b` | `true`  |
| `<=`     | Less than or equal to    | `a <= b` | `false` |

### Example:

```java
public class RelationalExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("a == b: " + (a == b));   // false
        System.out.println("a != b: " + (a != b));   // true
        System.out.println("a > b: " + (a > b));     // true
        System.out.println("a < b: " + (a < b));     // false
        System.out.println("a >= b: " + (a >= b));   // true
        System.out.println("a <= b: " + (a <= b));   // false
    }
}
```

### Explanation:

- **`==` (Equal to):** Returns `true` if both operands are equal, otherwise returns `false`.
- **`!=` (Not equal to):** Returns `true` if both operands are not equal, otherwise returns `false`.
- **`>` (Greater than):** Returns `true` if the left operand is greater than the right operand, otherwise returns `false`.
- **`<` (Less than):** Returns `true` if the left operand is less than the right operand, otherwise returns `false`.
- **`>=` (Greater than or equal to):** Returns `true` if the left operand is greater than or equal to the right operand, otherwise returns `false`.
- **`<=` (Less than or equal to):** Returns `true` if the left operand is less than or equal to the right operand, otherwise returns `false`.

---

## 4. Logical Operators

Logical operators are used to combine multiple conditions in conditional statements.

| Operator | Description | Example           | Output     |
| -------- | ----------- | ----------------- | ---------- | ------ | --- | ------- | ------ |
| `&&`     | Logical AND | `a > 5 && b < 10` | `true`     |
| `        |             | `                 | Logical OR | `a > 5 |     | b < 10` | `true` |
| `!`      | Logical NOT | `!(a > 5)`        | `false`    |

### Example:

```java
public class LogicalExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("a > 5 && b < 10: " + (a > 5 && b < 10));  // true
        System.out.println("a > 15 || b < 10: " + (a > 15 || b < 10)); // true
        System.out.println("!(a > 5): " + !(a > 5));         // false
    }
}
```

### Explanation:

- **`&&` (Logical AND):** Returns `true` if both conditions are `true`, otherwise returns `false`.
- **`||` (Logical OR):** Returns `true` if at least one condition is `true`, otherwise returns `false`.
- **`!` (Logical NOT):** Inverts the result of a condition (i.e., turns `true` to `false` and vice versa).

---

## 5. Unary Operators

Unary operators operate on a single operand. They are used to increment, decrement, or negate a value.

| Operator | Description | Example        | Output  |
| -------- | ----------- | -------------- | ------- |
| `+`      | Unary plus  | `+a`           | `5`     |
| `-`      | Unary minus | `-a`           | `-5`    |
| `++`     | Increment   | `a++` or `++a` | `6`     |
| `--`     | Decrement   | `a--` or `--a` | `4`     |
| `!`      | Logical NOT | `!a`           | `false` |

### Example:

```java
public class UnaryExample {
    public static void main(String[] args) {
        int a = 5;

        System.out.println("Unary plus: " + (+a));   // 5
        System.out.println("Unary minus: " + (-a));  // -5

        System.out.println("Post-increment: " + (a++)); // 5
        System.out.println("Pre-increment: " + (++a));  // 7

        System.out.println("Post-decrement: " + (a--)); // 7
        System.out.println("Pre-decrement: " + (--a));  // 5

        System.out.println("Logical NOT: " + !(a > 0));  // false
    }
}
```

### Explanation:

- **`+` (Unary plus):** Returns the operand as it is (no change).
- **`-` (Unary minus):** Negates the operand (changes the sign).
- **`++` (Increment):** Increases the value of the operand by 1. There are two forms: post-increment (`a++`) and pre-increment (`++a`).
- **`--` (Decrement):** Decreases the value of the operand by 1. There are two forms: post-decrement (`a--`) and pre-decrement (`--a`).
- **`!` (Logical NOT):** Reverses the boolean value of the operand (changes `true` to `false` and vice versa).

---

## 6. Bitwise Operators

Bitwise operators are used to perform operations on the binary representation of integers.

| Operator | Description          | Example    | Output |
| -------- | -------------------- | ---------- | ------ | --- | --- |
| `&`      | Bitwise AND          | `a & b`    | `1`    |
| `        | `                    | Bitwise OR | `a     | b`  | `7` |
| `^`      | Bitwise XOR          | `a ^ b`    | `6`    |
| `~`      | Bitwise complement   | `~a`       | `-6`   |
| `<<`     | Left shift           | `a << 2`   | `40`   |
| `>>`     | Right shift          | `a >> 2`   | `2`    |
| `>>>`    | Unsigned right shift | `a >>> 2`  | `2`    |

### Example:

```java
public class BitwiseExample {
    public static void main(String[] args) {
        int a = 5;  // Binary: 0101
        int b = 3;  // Binary: 0011

        System.out.println("a & b: " + (a & b));   // 1
        System.out.println("a | b: " + (a | b));   // 7
        System.out.println("a ^ b: " + (a ^ b));   // 6
        System.out.println("~a: " + (~a));         // -6
        System.out.println("a << 2: " + (a << 2)); // 20
        System.out.println("a >> 2: " + (a >> 2)); // 1
        System.out.println("a >>> 2: " + (a >>> 2)); // 1
    }
}
```

### Explanation:

- **`&` (Bitwise AND):** Performs AND operation on each bit of the operands.
- **`|` (Bitwise OR):** Performs OR operation on each bit of the operands.
- **`^` (Bitwise XOR):** Performs XOR (exclusive OR) operation on each bit of the operands.
- **`~` (Bitwise complement):** Inverts all the bits of the operand.
- **`<<` (Left shift):** Shifts the bits of the operand to the left by the specified number of positions (fills with 0s).
- **`>>` (Right shift):** Shifts the bits of the operand to the right by the specified number of positions (sign-extends the leftmost bit).
- **`>>>` (Unsigned right shift):** Shifts the bits to the right, filling the leftmost bits with 0s.

---

## 7. Ternary Operator

The ternary operator is a shorthand for `if-else` statement. It takes three operands.

| Operator | Description                  | Example                       | Output               |
| -------- | ---------------------------- | ----------------------------- | -------------------- |
| `? :`    | Conditional ternary operator | `condition ? value1 : value2` | `value1` or `value2` |

### Example:

```java
public class TernaryExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        int max = (a > b) ? a : b;  // If a > b, max = a, else max = b
        System.out.println("Max: " + max);  // Output: 10
    }
}
```

### Explanation:

- **`? :` (Ternary operator):** Evaluates the condition; if the condition is `true`, the first value is returned, otherwise the second value is returned.

---

## 8. Type Comparison Operator

The type comparison operator is used to check whether an object is an instance of a specific class or subclass.

| Operator     | Description                                            | Example                 | Output |
| ------------ | ------------------------------------------------------ | ----------------------- | ------ |
| `instanceof` | Checks if an object is an instance of a specific class | `obj instanceof String` | `true` |

### Example:

```java
public class TypeComparisonExample {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str instanceof String);  // Output: true
    }
}
```

### Explanation:

- **`instanceof` (Type comparison):** Returns `true` if the object is an instance of the specified class (or a subclass of it), otherwise returns `false`.

---

## Conclusion

Java operators are essential tools for manipulating data, comparing values, performing logical operations, and much more. Mastering operators like arithmetic, assignment, relational, logical, bitwise, and ternary operators will help you write more efficient and effective Java programs.

By understanding and utilizing all these operators, you will be able to perform a variety of operations and manage control flow in your programs with ease.
````
