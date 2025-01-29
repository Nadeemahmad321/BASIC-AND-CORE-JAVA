package QUEUE_INTERFACE;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Learn_ArrayDeque {
    public static void main(String[] args) {
        // Create a new ArrayDeque to store integers
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // Create a scanner object to take input from the user
        Scanner sc = new Scanner(System.in);
        
        // Ask the user to enter the size of the ArrayDeque
        System.out.print("Enter the number of elements for ArrayDeque: ");
        int size = sc.nextInt();
        
        // Loop to allow user to input 'size' number of elements
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element for ArrayDeque: ");
            int element = sc.nextInt();
            dq.add(element);  // Add the element to the deque (default adds to the back)
        }
        
        // Display the current elements in the ArrayDeque
        System.out.println("ArrayDeque elements: " + dq);
        
        // Offer elements to both ends (the default offer adds to the rear)
        dq.offer(20);  // Adds to the rear of the deque
        dq.offerLast(30);  // Explicitly adds to the rear
        dq.offerFirst(40);  // Adds to the front of the deque
        
        // Display the updated elements in the ArrayDeque after using offer
        System.out.println("Updated ArrayDeque elements: " + dq);

        // Demonstrating peek() - shows the front element without removal
        System.out.println("Peek at the first element: " + dq.peek());

        // Demonstrating poll() - retrieves and removes the first element
        System.out.println("Polling (removing) the first element: " + dq.poll());

        // Display the current state of the ArrayDeque after poll
        System.out.println("ArrayDeque after poll: " + dq);

        // Demonstrating pollFirst() - removes the first element (equivalent to poll())
        System.out.println("Polling first element (pollFirst): " + dq.pollFirst());

        // Demonstrating pollLast() - removes the last element
        System.out.println("Polling last element (pollLast): " + dq.pollLast());

        // Display the current state of the ArrayDeque after pollFirst and pollLast
        System.out.println("ArrayDeque after polling first and last: " + dq);

        // Demonstrating isEmpty() - check if the deque is empty
        System.out.println("Is the ArrayDeque empty? " + dq.isEmpty());

        // Demonstrating size() - get the number of elements in the deque
        System.out.println("Current size of ArrayDeque: " + dq.size());

        // Demonstrating remove() - removes the first element
        dq.remove();  // Removes the first element
        System.out.println("ArrayDeque after removing the first element: " + dq);
        sc.close();
    }
}
