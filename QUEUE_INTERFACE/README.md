# Queue Interface in Java

## Overview

This project demonstrates how to implement and use the **Queue** interface in Java, utilizing three different data structures:

1. **LinkedList**
2. **ArrayDeque**
3. **PriorityQueue**

A **Queue** is a **First In, First Out (FIFO)** data structure, where elements are added to the rear and removed from the front. Different queue implementations offer unique performance characteristics and use cases.

### Key Operations:

1. **Enqueue (add/offer)** - Adding elements to the queue.
2. **Dequeue (remove/poll)** - Removing elements from the queue.
3. **Peek** - Viewing the front element of the queue without removing it.

The implementation covers basic queue operations, including:

- Adding elements.
- Removing an element.
- Peeking at the front element.

## Features

- **Add elements** to the queue using either `add()` or `offer()`.
- **Remove elements** from the queue using `remove()` or `poll()`.
- **Peek at the front element** without removing it using `peek()`.

## Setup and Usage

### Requirements

- Java 8 or later.

### How to run the program:

1. Clone or download this repository.
2. Compile the program using your preferred IDE or command line.
3. Run the `Learn_queue` class to see how the queue works interactively.

### Example Usage

Upon running the program, the user is prompted to enter the size of the queue and then enter the elements one by one. After that, the program will:

1. Display the contents of the queue.
2. Remove the front element.
3. Show the contents of the queue again after removal.
4. Peek at the front element.

### Sample Output:

```
Enter the size of LinkedList: 3
Enter the element of LinkedList: 10
Enter the element of LinkedList: 20
Enter the element of LinkedList: 30
Elements of LinkedList: [10, 20, 30]
Elements of LinkedList after removal: [20, 30]
Peek: 20
```

## Queue Implementations

### 1. **LinkedList Queue**

- **LinkedList** is a doubly-linked list implementation of the `Queue` interface. It provides efficient addition and removal operations at both ends of the queue.

#### Code Example:

```java
Queue<Integer> list = new LinkedList<>();
list.add(10); // Enqueue
list.remove(); // Dequeue
System.out.println(list.peek()); // Peek
```

### 2. **ArrayDeque Queue**

- **ArrayDeque** is a resizable array implementation of the `Deque` (Double Ended Queue) interface, which can also be used as a queue. It is faster than `LinkedList` for most use cases but does not support thread-safe operations.

#### Code Example:

```java
Queue<Integer> arrayDeque = new ArrayDeque<>();
arrayDeque.add(10); // Enqueue
arrayDeque.remove(); // Dequeue
System.out.println(arrayDeque.peek()); // Peek
```

### 3. **PriorityQueue**

- **PriorityQueue** is an implementation of the `Queue` interface where elements are ordered according to their natural ordering or by a comparator provided at queue construction time. Elements are dequeued in order of their priority (smallest or largest depending on comparator).

#### Code Example:

```java
Queue<Integer> priorityQueue = new PriorityQueue<>();
priorityQueue.add(10); // Enqueue
priorityQueue.add(5);  // Enqueue
priorityQueue.add(20); // Enqueue
System.out.println(priorityQueue.remove()); // Dequeue (removes 5 because it has the highest priority)
System.out.println(priorityQueue.peek()); // Peek (now 10)
```

## Comparison of Queue Implementations

| **Implementation** | **Use Case**                                                       | **Performance Characteristics**                   |
| ------------------ | ------------------------------------------------------------------ | ------------------------------------------------- |
| **LinkedList**     | Best for general-purpose queues. Supports both ends.               | O(1) for add and remove operations at both ends.  |
| **ArrayDeque**     | Fast queue operations when you need a resizable array.             | O(1) for add and remove operations at both ends.  |
| **PriorityQueue**  | Best for situations where elements need to be ordered by priority. | O(log n) for enqueue and dequeue (based on heap). |

## Code Implementation

```java
package QUEUE_INTERFACE;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Learn_queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Choose Queue implementation
        System.out.println("Choose Queue Implementation: ");
        System.out.println("1. LinkedList");
        System.out.println("2. ArrayDeque");
        System.out.println("3. PriorityQueue");
        int choice = sc.nextInt();

        Queue<Integer> list = null;

        // Initialize the selected queue type
        switch (choice) {
            case 1:
                list = new LinkedList<>();
                break;
            case 2:
                list = new ArrayDeque<>();
                break;
            case 3:
                list = new PriorityQueue<>();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Ask the user for the size of the queue
        System.out.print("Enter the size of the queue: ");
        int size = sc.nextInt();

        // Loop to allow user to input 'size' number of elements
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element of the queue: ");
            int element = sc.nextInt();
            list.add(element); // Enqueue
        }

        // Display the current elements of the queue
        System.out.println("Elements of the queue: " + list);

        // Remove the first element from the queue
        list.remove(); // Dequeue
        System.out.println("Elements after removal: " + list);

        // Peek at the front element of the queue
        System.out.println("Peek: " + list.peek()); // Peek
    }
}
```

## Conclusion

This program demonstrates how to implement and use the **Queue** interface in Java with different underlying data structures:

- **LinkedList**: Best for general-purpose queues.
- **ArrayDeque**: Offers faster queue operations than `LinkedList` in most scenarios.
- **PriorityQueue**: Useful when elements need to be ordered by priority.

Each implementation is useful in different situations, depending on your performance needs and whether you need priority ordering.
