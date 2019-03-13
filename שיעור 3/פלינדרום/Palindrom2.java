import java.util.Scanner;

public class Palindrom {
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("please enter a number with 5 digits: ");
        int number = scan.nextInt();

        int x1 = number / 10000 % 10;
        int x2 = number / 1000 % 10;
        int x3 = number / 100 % 10;
        int x4 = number / 10 % 10;
        int x5 = number % 10;

        System.out.println(x1 + ", " + x2 + ", " + x3 + ", " + x4 + ", " + x5);


        if (x1 == x5 && x2 == x4) {
            System.out.println("the number is a palindrom");}
        else{
            System.out.println("the number is not a palindrom");
        }
    }
}
