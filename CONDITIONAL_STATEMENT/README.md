# Conditional Statements in Java

This guide explains the various **conditional statements** in Java that allow a program to decide which block of code to execute based on certain conditions. We will explore the following types of conditional statements:

1. **If Statement**
2. **If-Else Statement**
3. **Nested If-Else Statement**
4. **If-Else If Ladder**
5. **Switch Case Statement**
6. **Ternary Operator**

---

## 1. If Statement

### Explanation:

The `if` statement is the simplest form of a conditional statement. It checks whether a condition is true. If the condition evaluates to true, the block of code inside the `if` block is executed.

### Syntax:

```java
if (condition) {
    // Block of code to be executed if the condition is true
}
```

### Example:

For example, to check if a person is eligible to vote, you might check if their age is 18 or more:

- **Condition**: Age >= 18
- **Action**: Print "Eligible for voting" if true

### Flowchart:

```
  +---------------------------+
  |  Condition (age >= 18)?    |
  +-----------+---------------+
              |
       True   |   False
              |
  +-----------+---------------+
  |  Execute block:           |
  |  "Eligible for voting"    |
  +---------------------------+
```

---

## 2. If-Else Statement

### Explanation:

An `if-else` statement is used when you want to execute one block of code if a condition is true and another block if the condition is false.

### Syntax:

```java
if (condition) {
    // Block of code if condition is true
} else {
    // Block of code if condition is false
}
```

### Example:

To determine whether a person has passed or failed based on their marks:

- **Condition**: Marks >= 50
- **Action**: Print "Passed" if true, "Failed" if false

### Flowchart:

```
  +---------------------------+
  |  Condition (marks >= 50)?  |
  +-----------+---------------+
              |
       True   |   False
              |
  +-----------+---------------+
  |  Execute block:           |
  |  "Passed"                 |
  +---------------------------+
              |
              |
  +---------------------------+
  |  Execute block:           |
  |  "Failed"                 |
  +---------------------------+
```

---

## 3. Nested If-Else Statement

### Explanation:

A **nested if-else** statement is an `if` or `else` block inside another `if` or `else` block. This allows for more complex decision-making with multiple layers of conditions.

### Syntax:

```java
if (condition1) {
    if (condition2) {
        // Block of code if both conditions are true
    } else {
        // Block of code if condition1 is true and condition2 is false
    }
} else {
    // Block of code if condition1 is false
}
```

### Example:

To find the greatest of three numbers, you use nested if-else conditions to compare each number:

- **Condition**: Compare `firstNumber` with `secondNumber` and `thirdNumber`.

### Flowchart:

```
  +----------------------------+
  |  Condition (firstNumber >  |
  |  secondNumber)?            |
  +------------+---------------+
               |
         True  |  False
               |
  +------------+----------------------------+
  |  Condition (firstNumber > thirdNumber)? |
  +------------+----------------------------+
               |
        True    |   False
               |
  +------------+------------------+        +---------------------------+
  |  "First number is greater"   |        | "Third number is greater" |
  +------------------------------+        +---------------------------+
```

---

## 4. If-Else If Ladder

### Explanation:

The `if-else if` ladder is used to evaluate multiple conditions in a sequence. It's helpful when you need to check more than two conditions. If the first condition is false, it moves to the next one, and so on.

### Syntax:

```java
if (condition1) {
    // Block of code if condition1 is true
} else if (condition2) {
    // Block of code if condition2 is true
} else if (condition3) {
    // Block of code if condition3 is true
} else {
    // Block of code if all conditions are false
}
```

### Example:

To assign grades based on marks, you check several conditions (A, B, C, etc.):

- **Condition**: Marks >= 90 -> Grade A, Marks >= 80 -> Grade B, etc.

### Flowchart:

```
  +---------------------------+
  | Condition (marks >= 90)?   |
  +-----------+---------------+
              |
       True   |   False
              |
  +-----------+--------------------------+
  |  Execute block:                    |
  |  "Grade A"                         |
  +-------------------------------------+
              |
              |
  +---------------------------+
  | Condition (marks >= 80)?   |
  +-----------+---------------+
              |
        True |   False
              |
  +-----------+--------------------------+
  |  Execute block:                    |
  |  "Grade B"                         |
  +-------------------------------------+
              |
              |
  +---------------------------+
  | Execute block:            |
  | "Fail"                    |
  +---------------------------+
```

---

## 5. Switch Case Statement

### Explanation:

The `switch` case statement is used when you need to check a variable against a set of possible values. It is more efficient than using multiple `if-else` statements when dealing with a fixed set of conditions.

### Syntax:

```java
switch (variable) {
    case value1:
        // Block of code if variable == value1
        break;
    case value2:
        // Block of code if variable == value2
        break;
    default:
        // Block of code if variable does not match any case
}
```

### Example:

To determine the day of the week based on a number (1-7):

- **Condition**: Check if `dayNumber` equals 1, 2, etc.

### Flowchart:

```
  +-------------------------------+
  |   Condition (day == 1)?        |
  +------------+------------------+
               |
         True  |  False
               |
  +------------+------------------+
  | "Day 1 is Monday"             |
  +-------------------------------+
```

---

## 6. Ternary Operator

### Explanation:

The **ternary operator** is a shorthand for the `if-else` statement. It evaluates a condition and returns one value if true, and another if false. It’s often used to assign values to variables based on conditions.

### Syntax:

```java
variable = (condition) ? value_if_true : value_if_false;
```

### Example:

To determine if a number is positive or negative:

- **Condition**: `number > 0`
- **Action**: Assign "Positive" if true, "Negative" if false.

### Flowchart:

```
  +----------------------------+
  |  Condition (number > 0)?   |
  +------------+---------------+
               |
        True   |    False
               |
  +------------+------------+
  |  "Positive"            |
  +------------------------+
```

---

### Conclusion

Understanding conditional statements in Java is fundamental to controlling the flow of execution based on certain conditions. The conditional statements we covered—`if`, `if-else`, `nested if-else`, `if-else if`, `switch case`, and the `ternary operator`—are all tools you can use to create flexible, decision-based logic in your programs.
