package LOOPS;
import java.util.Scanner;
public class Multiplication {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want:");
        int number = sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(number + " * " + i + " = " + number*i);
        }
        sc.close();
    }
}
