````markdown
# Simple Java Program: Hello World and Printing Different Data Types

This project demonstrates two Java programs:

1. A simple program that prints messages using `System.out.println()` and `System.out.print()`.
2. A program that prints different data types such as strings, integers, floating-point numbers, and characters.

### File Structure:

- **`Hello.java`**: Prints a greeting message using `println()` and `print()`.
- **`Printing.java`**: Prints various data types including strings, integers, floating-point numbers, and characters.

## Prerequisites

Before running the program, ensure that you have:

- **Java Development Kit (JDK)** installed.
- A **text editor** or **IDE** like IntelliJ IDEA, Eclipse, or Visual Studio Code.

## Code Explanation

### 1. **`Hello.java`**: Prints Greeting Messages

This program prints two messages:

- It prints `"Hello World!"` using the `System.out.println()` method, which ensures the message is followed by a new line.
- It then prints `"Hello,Friends"` using `System.out.print()`, which does **not** move to the next line, so the output continues on the same line.

### 2. **`Printing.java`**: Prints Different Data Types

This program prints various types of data:

- It prints the string `"Hello"` using `System.out.println()`, followed by a newline.
- It prints the integer `3`, the floating-point number `3.41`, and the character `"A"`, each followed by a newline (except for the character `"A"` which is printed using `System.out.print()` to avoid a newline).

## Steps to Run the Program

1. **Create Java Files**:

   - Create two files: `Hello.java` and `Printing.java`.

2. **Write the Code**:

   - Copy and paste the provided code for each class into their respective files.

3. **Compile the Java Program**:
   Open your terminal or command prompt and navigate to the directory where the `Hello.java` and `Printing.java` files are saved. Then run the following command to compile the files:

   ```bash
   javac Hello.java Printing.java
   ```
````

This will create `.class` files for both classes.

4. **Run the Program**:
   To run the `Hello` class, use the following command:

   ```bash
   java INTRODUCTIONTOJAVA.Hello
   ```

   This will print:

   ```
   Hello World!
   Hello,Friends
   ```

   To run the `Printing` class, use the following command:

   ```bash
   java INTRODUCTIONTOJAVA.Printing
   ```

   This will print:

   ```
   Hello
   3
   3.41
   A
   ```

## Output Explained

### Output of `Hello.java`:

- The first message (`Hello World!`) is printed using `System.out.println()`, which moves the cursor to the next line after printing.
- The second message (`Hello,Friends`) is printed using `System.out.print()`, which does not move to the next line. The cursor stays on the same line, so the output continues.

### Output of `Printing.java`:

- The string `"Hello"` is printed, followed by a newline.
- The integer `3` is printed, followed by a newline.
- The floating-point number `3.41` is printed, followed by a newline.
- The character `"A"` is printed without a newline.

## Understanding `println()` vs `print()`

- **`System.out.println()`**: This method prints the specified message followed by a newline. After printing, the cursor moves to the next line.

  Example:

  ```
  System.out.println("Hello");
  System.out.println("World");
  ```

  Output:

  ```
  Hello
  World
  ```

- **`System.out.print()`**: This method prints the specified message without moving to the next line. The cursor stays on the same line.

  Example:

  ```
  System.out.print("Hello");
  System.out.print(" ");
  System.out.print("World");
  ```

  Output:

  ```
  Hello World
  ```
