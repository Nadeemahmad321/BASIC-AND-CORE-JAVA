package QUEUE_INTERFACE;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Learn_queue {
    public static void main(String[] args) {
        // Create a queue that stores integers
        Queue<Integer> list = new LinkedList<>();
        
        // Initialize the scanner to take user input
        Scanner sc = new Scanner(System.in);

        // Ask the user for the size of the queue
        System.out.print("Enter the size of LinkedList: ");
        int size = sc.nextInt();
        
        // Loop to allow user to input 'size' number of elements
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element of LinkedList: ");
            int element = sc.nextInt();
            
            // Add the element to the queue
            list.add(element);  // You could also use list.offer(element) here
        }

        // Display the current elements of the queue
        System.out.println("Elements of LinkedList: " + list);

        // Remove the first element from the queue
        list.remove();  // Alternatively, list.poll() can be used here
        
        // Display the queue after removal
        System.out.println("Elements of LinkedList after removal: " + list);

        // Display the element at the front of the queue without removing it
        System.out.print("Peek: " + list.peek());  // peek() shows the first element without removal
        sc.close();
    }
}
