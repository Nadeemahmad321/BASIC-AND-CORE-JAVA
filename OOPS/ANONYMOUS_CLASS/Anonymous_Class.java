package OOPS.ANONYMOUS_CLASS;

class OuterClass {
    public void outerMethod() {
        System.out.println("This is the outer method.");
    }
}

public class Anonymous_Class {
    public static void main(String[] args) {
        
        // Anonymous class extending OuterClass and overriding outerMethod
        OuterClass obj = new OuterClass() {
            @Override
            public void outerMethod() {
                System.out.println("This is the overridden outer method in the anonymous class.");
            }

            // Adding a new method in the anonymous class
            void sing() {
                System.out.println("Ram sings a song.");
            }
        };

        // Calling the overridden method
        obj.outerMethod(); // This will call the overridden version

        // Using the 'sing' method from the anonymous class
        // We need to cast the obj to OuterClass to access methods declared in the anonymous class
        ((OuterClass) obj).sing();
    }
}
