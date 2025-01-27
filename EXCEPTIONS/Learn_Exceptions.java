package EXCEPTIONS;

public class Learn_Exceptions {
    public static void main(String[] args) {
        // Initialize an array with 6 elements
        int arr[] = {0, 1, 2, 3, 4, 5};

        /* 
        The following code attempts to access an element at index 7 in the array, 
        but the array only has elements at indices 0 through 5. 
        This will cause an exception (ArrayIndexOutOfBoundsException).
        To handle this potential error, we use a try-catch block.
        */
        try {
            // Attempt to divide by 0, which will cause an ArithmeticException
            int div = 5 / 0; // This will throw ArithmeticException (division by zero)
            System.out.println(arr[7]); // This line will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            // This block handles any ArrayIndexOutOfBoundsException
            System.out.println("You are trying to access an element from the array that doesn't exist. The valid indices are between 0 and " + (arr.length - 1) + ".");
        } catch (ArithmeticException e) {
            // This block handles any ArithmeticException (like division by zero)
            System.out.println("Catch call:Division by zero is not allowed in mathematics.");
        } finally{
            System.out.println("Finally call:I will always run");
        }
    }
}
