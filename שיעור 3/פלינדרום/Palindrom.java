import java.util.Scanner;

public class Palindrom
{
   public static void main(String[]args)
   {
       Scanner scan = new Scanner(System.in);
       int number,number1,firstDigit,newNum;
       newNum=0;

       System.out.println("please enter 5 numbers");
       number = scan.nextInt();
       number1= number;
       
       firstDigit = number%10;
       newNum=(newNum+firstDigit)*10;
       number=number/10;
       
       firstDigit = number%10;
       newNum=(newNum+ firstDigit)*10;
       number=number/10;
       
       firstDigit = number%10;
       newNum=(newNum+ firstDigit)*10;
       number=number/10;
       
       firstDigit = number%10;
       newNum=(newNum+ firstDigit)*10;
       number=number/10;
       
       firstDigit = number%10;
       newNum=newNum+ firstDigit;
       number=number/10;
       
       if (newNum == number1) {
           System.out.println("the number is a palindrom");}
           else{ 
           System.out.println("the number is not a palindrom");
        }
    }
}