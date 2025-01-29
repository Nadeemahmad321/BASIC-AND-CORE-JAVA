package QUEUE_INTERFACE;
import java.util.PriorityQueue;
import java.util.Queue;

public class Learn_priority_queue {
    public static void main(String[] args){
        // Create a PriorityQueue with a custom comparator to sort elements in descending order
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Add elements to the PriorityQueue
        pq.add(30);
        pq.add(90);
        pq.add(50);
        pq.add(40);

        // Display the current PriorityQueue elements (ordered by their priority)
        System.out.println("Priority elements: " + pq);

        // Remove the highest priority element (since we sorted it in descending order, it's the largest element)
        pq.poll();

        // Display the updated PriorityQueue after polling the highest priority element
        System.out.println("Priority elements after poll: " + pq);
    }
}
