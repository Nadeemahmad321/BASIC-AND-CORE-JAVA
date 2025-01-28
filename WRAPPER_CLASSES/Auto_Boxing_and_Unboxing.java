package WRAPPER_CLASSES;

public class Auto_Boxing_and_Unboxing {
    public static void main(String[] args) {
        // Creating an Integer object using the constructor (not recommended for modern code)
        Integer obj_1 = new Integer(12);

        // Creating an Integer object using the static valueOf method (preferred)
        Integer obj_2 = Integer.valueOf(12);

        // Autoboxing: Converting a primitive int to an Integer object automatically
        Integer obj = 12; // Autoboxing happens here

        // Unboxing: Converting an Integer object to a primitive int automatically
        int age = obj_1; // Unboxing happens here

        System.out.println("Autoboxed Integer: " + obj);
        System.out.println("Unboxed value: " + age);
    }
}
