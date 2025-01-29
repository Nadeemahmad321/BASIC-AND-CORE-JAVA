package SET_INTERFACE;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Learn_Set_Interface {
    public static void main(String[] args) {
        // Creating a HashSet that implements Set
        Set<Integer> set = new HashSet<>();

        // 1. Add elements to the set
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);  // Duplicate element (will not be added)
        set.add(40);
        set.add(50);

        System.out.println("Set after adding elements: " + set);

        // 2. Checking if an element is present in the set
        System.out.println("Does the set contain 30? " + set.contains(30));
        System.out.println("Does the set contain 60? " + set.contains(60));

        // 3. Removing an element from the set
        set.remove(20);  // Removes the element '20'
        System.out.println("Set after removing 20: " + set);

        // 4. Checking the size of the set
        System.out.println("Size of the set: " + set.size());

        // 5. Checking if the set is empty
        System.out.println("Is the set empty? " + set.isEmpty());

        // 6. Clearing all elements from the set
        set.clear();
        System.out.println("Set after clearing: " + set);

        // 7. Adding new elements after clearing
        set.add(100);
        set.add(200);
        set.add(300);
        System.out.println("Set after adding new elements: " + set);

        // 8. Iterating over the elements in the set
        System.out.println("Iterating over the set:");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 9. Checking if the set is empty after some operations
        System.out.println("Is the set empty now? " + set.isEmpty());
    }
}

