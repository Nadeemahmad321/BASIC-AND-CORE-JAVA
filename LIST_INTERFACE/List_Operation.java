package COLLECTION_INTERFACE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List_Operation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        // Get the size of the list
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        // Add elements to the list
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element for array (" + (i + 1) + " of " + size + "): ");
            int elem = sc.nextInt();
            list.add(elem);
        }

        // Get an index to retrieve an element
        System.out.print("Enter the index to get the element from the array: ");
        int index = sc.nextInt();
        
        // Check if the index is valid
        if (index >= 0 && index < list.size()) {
            System.out.println("Element at index " + index + ": " + list.get(index));
        } else {
            System.out.println("Invalid index.");
        }

        // Set a new value at the provided index
        System.out.print("Enter the value for set in array: ");
        int setValue = sc.nextInt();
        if (index >= 0 && index < list.size()) {
            list.set(index, setValue);
            System.out.println("Updated array: " + list);
        } else {
            System.out.println("Invalid index to set value.");
        }

        // Insert a new value at a specific index
        System.out.print("Enter the value to add in the array: ");
        int addValue = sc.nextInt();
        System.out.print("Enter the index to insert the value: ");
        index = sc.nextInt();
        
        // Check if the index is valid for insertion
        if (index >= 0 && index <= list.size()) {
            list.add(index, addValue);
            System.out.println("Updated array after insertion: " + list);
        } else {
            System.out.println("Invalid index to insert value.");
        }
        
        sc.close();
    }
}

    