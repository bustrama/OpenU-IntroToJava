/*
 *  Author: Ben Brandes
 *  Date: 16/03/19
 */

import java.util.Scanner;

public class Equations{
    // The user gives us the value of 2 parametes and solution
    // of two equation and the program will find out
    // whether we have Single solution, Many solutions or No solution at all

    public static void main(String[] args){
        // Final member that will help us round the digits after the decimal dot
        final double MAX = 1000.0;

        Scanner input = new Scanner(System.in);

        System.out.println("This program solves a system of 2 linear equations");
        System.out.println("Enter the coefficients a11 a12 a21 a22 b1 b2");
        int a11 = input.nextInt();
        int a12 = input.nextInt();
        int a21 = input.nextInt();
        int a22 = input.nextInt();
        int b1  = input.nextInt();
        int b2  = input.nextInt();

        // Show the equations after getting the input
        System.out.println("Eq1: " + a11 + "*x1+" + a12 + "*x2=" + b1);
        System.out.println("Eq2: " + a21 + "*x1+" + a22 + "*x2=" + b2);

        // If this condition is true we'll have a single solution
        if(((a11*a22) - (a12*a21)) != 0){
            double x1 = ((double)(b1*a22 - b2*a12)/(double)(a11*a22 - a12*a21));
            double x2 = ((double)(b2*a11 - b1*a21)/(double)(a11*a22 - a12*a21));

            // Using the final member we declared above, we'll shorten the digits after the '.'
            x1 = Math.round(x1 * MAX) / MAX;
            x2 = Math.round(x2 * MAX) / MAX;

            System.out.println("Single solution: (" + x1 + "," + x2 + ")");
        }
        // If the condition above will be false and this condition will be true we'll have many solutions
        else if((b2*a11 - b1*a21 == 0) && (b1*a22 - b2*a12 == 0) && !(b1 != 0 && a11 == 0 && a12 == 0) && !(b2 != 0 && a21 == 0 && a22 == 0)){
            System.out.println("Many solution");
        }
        // If all the conditions above are false we'll have no solution
        else{
            System.out.println("No solution");
        }
    }
}
