import java.util.Scanner;

public class Palindrom {
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("please enter a number with 5 digits: ");
        int number = scan.nextInt();

        int x1 = number / 10000 % 10;   // Get the first digit
        int x2 = number / 1000 % 10;    // Get the second digit
        int x3 = number / 100 % 10;     // Get the third digit
        int x4 = number / 10 % 10;      // Get the forth digit
        int x5 = number % 10;           // Get the fifth digit

        // Printing all the digits by order
        System.out.println(x1 + ", " + x2 + ", " + x3 + ", " + x4 + ", " + x5);

        // Checking the first number with the fifth AND
        // and the second number with the forth
        if (x1 == x5 && x2 == x4) {
            System.out.println("the number is a palindrom");}
        else{
            System.out.println("the number is not a palindrom");
        }
    }
}
