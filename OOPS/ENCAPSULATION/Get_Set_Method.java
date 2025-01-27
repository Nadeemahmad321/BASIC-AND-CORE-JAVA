package OOPS.ENCAPSULATION;

// Dog class demonstrating encapsulation in Java
class Dog {
    // Step 1: Private fields (attributes)
    // These fields cannot be accessed directly outside the Dog class
    private String name;
    private int age;

    // Step 2: Setter method for name
    public void setName(String name) {
        this.name = name; // Assign the value to the name field
    }

    // Step 3: Getter method for name
    public String getName() {
        return name; // Return the value of the name field
    }

    // Step 4: Setter method for age
    public void setAge(int age) {
        this.age = age; // Assign the value to the age field
    }

    // Step 5: Getter method for age
    public int getAge() {
        return age; // Return the value of the age field
    }
}

public class Get_Set_Method {
    public static void main(String[] args) {
        // Step 6: Create a Dog object
        Dog dog_1 = new Dog();
        
        // Step 7: Setting values using setter methods
        dog_1.setName("Tommy");  // Setting the dog's name
        dog_1.setAge(5);         // Setting the dog's age
        
        // Step 8: Getting values using getter methods
        String name = dog_1.getName();  // Retrieving the dog's name
        int age = dog_1.getAge();      // Retrieving the dog's age
        
        // Step 9: Output the dog's name and age
        System.out.println("Name: " + name);  // Print the dog's name
        System.out.println("Age: " + age);    // Print the dog's age
    }
}
