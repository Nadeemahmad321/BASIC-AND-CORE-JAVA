package OOPS;

public class Inner_and_Nested_class {
    
    // Non-static inner class (Dog)
    class Dog {
        String name;
        int age;
        
        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void dogProperties() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
    
    // Static nested class (Animal)
    static class Animal {
        String animalName;
        
        public Animal(String animalName) {
            this.animalName = animalName;
        }

        void animalProperties() {
            System.out.println("Type: " + animalName);
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the non-static inner class 'Dog'
        Inner_and_Nested_class outerClass = new Inner_and_Nested_class();
        Dog dog_1 = outerClass.new Dog("Tommy", 5);
        dog_1.dogProperties();

        // Creating an instance of the static nested class 'Animal'
        Animal type = new Animal("Monkey");
        type.animalProperties();
    }
}
