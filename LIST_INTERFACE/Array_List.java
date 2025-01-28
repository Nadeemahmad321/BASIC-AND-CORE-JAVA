package LIST_INTERFACE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_List {
    public static void main(String[] args) {
        
        // Create an ArrayList to store Integer elements
        List<Integer> list = new ArrayList<>();
        
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Ask the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        // Loop to take the elements for the list based on the size
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element for array (" + (i + 1) + " of " + size + "): ");
            int elem = sc.nextInt();
            list.add(elem); // Add the entered element to the list
        }
        
        // Print the elements of the list
        System.out.println("\nArray elements: " + list);
        
        // Print the size of the list
        System.out.println("Size of the list: " + list.size());
        
        // Check if the list is empty and print a message
        if (list.isEmpty()) {
            System.out.println("The array is empty.\n");
        } else {
            System.out.println("The array is not empty.\n");
        }
        
        // Ask the user to input an element to check if it is in the list
        System.out.print("Enter an element to check if it is present in the array: ");
        int available = sc.nextInt();
        
        // Check if the list contains the specified element
        if (list.contains(available)) {
            System.out.println("\nThe array contains: " + available + "\n");
        } else {
            System.out.println("\nThe array does not contain: " + available + "\n");
        }
        
        // Remove the element at index 1 (second element)
        System.out.println("Removing element at index 1...");
        list.remove(1);
        System.out.println("Array after removal: " + list);
        System.out.println("Size of the list after removal: " + list.size() + "\n");
        
        // Remove the element with the value 4
        System.out.println("Removing element with value 4...");
        list.remove(Integer.valueOf(4));
        System.out.println("Array after removal: " + list);
        
        // Close the Scanner object
        sc.close();
    }
}
