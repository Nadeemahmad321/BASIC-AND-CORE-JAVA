package CONDITIONAL_STATEMENT;
import java.util.Scanner;

public class Switch_Statement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the day you want between(1 to 7):");
        int day = sc.nextInt();
        switch(day){
            case 1 :
                System.out.print("Sunday");
                break;
            case 2 :
                System.out.print("Monday");
                break;
            case 3 :
                System.out.print("Tuesday");
                break;
                case 4 :
                System.out.print("Wednesday");
                break;
            case 5 :
                System.out.print("Thursda");
                break;
            case 6 :
                System.out.print("Friday");
                break;
            case 7 :
                System.out.print("Saturday");
                break;
            default:
                System.out.print("Enter a valid day");
        }
        sc.close();
    }
}
