# Java String Operations

## Overview

In Java, `String` is a class in the `java.lang` package that represents a sequence of characters. Strings are commonly used for text manipulation and are immutable in Java, meaning once a string object is created, its value cannot be changed. However, there are many built-in methods available to manipulate and interact with strings.

This document explains common string operations demonstrated through Java code. These operations include string concatenation, case conversion, character retrieval, substring extraction, and more.

## String Methods

### 1. **toUpperCase()**

The `toUpperCase()` method converts all characters in the string to uppercase.

**Example:**

```java
String firstName = "John";
System.out.println(firstName.toUpperCase());  // Output: JOHN
```

### 2. **toLowerCase()**

The `toLowerCase()` method converts all characters in the string to lowercase.

**Example:**

```java
String lastName = "Doe";
System.out.println(lastName.toLowerCase());  // Output: doe
```

### 3. **charAt()**

The `charAt()` method returns the character at the specified index in the string. Indexing starts from 0.

**Example:**

```java
String firstName = "John";
System.out.println(firstName.charAt(2));  // Output: h
```

### 4. **startsWith()**

The `startsWith()` method checks if the string starts with the specified prefix.

**Example:**

```java
String firstName = "John";
System.out.println(firstName.startsWith("Jo"));  // Output: true
```

### 5. **endsWith()**

The `endsWith()` method checks if the string ends with the specified suffix.

**Example:**

```java
String firstName = "John";
System.out.println(firstName.endsWith("hn"));  // Output: true
```

### 6. **trim()**

The `trim()` method removes leading and trailing whitespace from the string.

**Example:**

```java
String firstName = "  John  ";
System.out.println(firstName.trim());  // Output: John
```

### 7. **String.valueOf()**

The `String.valueOf()` method converts different types (like integers or floats) into their string representations.

**Example:**

```java
int age = 20;
String ageAsString = String.valueOf(age);
System.out.println(ageAsString);  // Output: 20
```

### 8. **replace()**

The `replace()` method is used to replace occurrences of a specified substring with another substring.

**Example:**

```java
String sentence = "I love java";
System.out.println(sentence.replace("java", "cpp"));  // Output: I love cpp
```

### 9. **contains()**

The `contains()` method checks if a specified substring is present in the string.

**Example:**

```java
String sentence = "I love java";
System.out.println(sentence.contains("java"));  // Output: true
```

### 10. **substring()**

The `substring()` method extracts a part of the string, starting from a specified index to another specified index (exclusive).

**Example:**

```java
String sentence = "I love java";
System.out.println(sentence.substring(2, 4));  // Output: lo
```

### 11. **split()**

The `split()` method divides the string into substrings based on a delimiter (e.g., space) and returns an array of these substrings.

**Example:**

```java
String sentence = "I love java";
String[] words = sentence.split(" ");
for (String word : words) {
    System.out.print(word + " ");  // Output: I love java
}
```

### 12. **toCharArray()**

The `toCharArray()` method converts the string into an array of characters.

**Example:**

```java
String firstName = "John";
char[] charArray = firstName.toCharArray();
for (char ch : charArray) {
    System.out.print(ch + " ");  // Output: J o h n
}
```

### 13. **isEmpty()**

The `isEmpty()` method checks if the string is empty (i.e., its length is 0).

**Example:**

```java
String firstName = "John";
System.out.println(firstName.isEmpty());  // Output: false
```

## Code Walkthrough

Here is a simple explanation of the code with examples:

1. **Getting User Input:**
   We first prompt the user to input their first name and last name using the `Scanner` class.

   ```java
   Scanner sc = new Scanner(System.in);
   System.out.print("Enter the first name: ");
   String firstName = sc.nextLine();
   ```

2. **Displaying Name Before and After Method Application:**
   Before applying string methods, we display the original names. Then, we use various string methods such as `toUpperCase()`, `toLowerCase()`, and others to manipulate the strings and display the results.

   ```java
   System.out.println("First and Last Name Before using methods:");
   System.out.println(firstName);
   System.out.println(lastName);
   ```

3. **String Method Operations:**
   We apply methods like `toUpperCase()`, `toLowerCase()`, `charAt()`, `startsWith()`, and others on the user input to demonstrate their functionality.

   ```java
   System.out.println("First name in uppercase: " + firstName.toUpperCase());
   System.out.println("Last name in lowercase: " + lastName.toLowerCase());
   ```

4. **Converting Integer to String:**
   The program also demonstrates converting an integer (`age`) to a string using `String.valueOf()` and concatenating it with another value.

   ```java
   int age = 20;
   String ageAsString = String.valueOf(age);
   System.out.println("Age as string concatenated with 2: " + ageAsString + 2);
   ```

5. **Splitting and Iterating Through Strings:**
   The `split()` method is used to break the sentence into individual words, and we iterate through the array of words.

   ```java
   String sentence = "I love java";
   String[] words = sentence.split(" ");
   for (String word : words) {
       System.out.print(word + " ");
   }
   ```

## Example Output

#### Input:

```
Enter the first name: John
Enter the last name: Doe
```

#### Output:

```
First and Last Name Before using methods:
John
Doe

First and Last Name After using methods:
First name in uppercase: JOHN
Last name in lowercase: doe
Third character of first name: h
Does the first name start with 'Nad'? false
Does the first name end with 'Nad'? false
First name after trim: 'John'
Age (int): 20
Age as string: 20
Age as string concatenated with 2: 202
Original sentence: I love java
Sentence after replacing 'java' with 'cpp': I love cpp
Does the sentence contain 'cpp'? false
Substring from index 2 to 4: lo
Words in the sentence: I love java
Character array of the first name:
J o h n
Is the first name empty? false
```

## Conclusion

In this guide, we've demonstrated various string methods in Java that allow you to manipulate and process strings effectively. Whether you're working with string concatenation, case conversion, character extraction, or substring replacement, these string methods are essential tools for text manipulation in Java programming.
