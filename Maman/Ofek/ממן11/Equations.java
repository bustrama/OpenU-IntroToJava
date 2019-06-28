// ****************************************
//  Solves a system of 2 linear equations
//
// Author: Ofek Marks
// ID: 325131886
// Version: 16.3.2019
// ****************************************

import java.util.Scanner;
public class Equations
{
    /* Gets the coefficients of two linear equations and solves them according to "Cramer's rule".
    If the 2 linear equations have one solution, the solution would be printed as shown: "(x1Solution,x2Solution)".
    otherwise, the program would print "No solution" or "Many solutions" for each unique case */
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program solves a system of 2 linear equations");
        System.out.println("Enter the coefficients a11 a12 a21 a22 b1 b2");
        int a11 = scan.nextInt();
        int a12 = scan.nextInt();
        int a21 = scan.nextInt();
        int a22 = scan.nextInt();
        int b1 = scan.nextInt();
        int b2 = scan.nextInt();
        System.out.println("Eq1: " + a11 + "*x1+" + a12 + "*x2=" + b1);
        System.out.println("Eq2: " + a21 + "*x1+" + a22 + "*x2=" + b2);
        if(a11*a22 != a12*a21) // Checks if the equations have a single solution
        {
            double x1 = (double)(b1*a22 - b2*a12)/(a11*a22 - a12*a21), x2 = (double)(b2*a11 - b1*a21)/(a11*a22 - a12*a21);
            /* The division and multiplication by the final ROUND, combined with the method round from the 
            Math class is done in order to round the number to 3 digits (in this requested case) after the decimal point: */
            final double ROUND = 1000;
            x1 = Math.round (x1 * ROUND) / ROUND;
            x2 = Math.round (x2 * ROUND) / ROUND;
            // Prints the requested message in a case of a single solution:
            System.out.println("Single solution: (" + x1 + "," + x2 + ")");
        } // end of if
        else
        {
            if(b2*a11 == b1*a21 && b1*a22 == b2*a12 && !(a11 == 0 && 
            a12 == 0 && b1 != 0) && !(a21 == 0 && a22 == 0 && b2 != 0)) // Checks if the equations have many solutions
                System.out.println("Many solutions"); 
            else // Otherwise, the 2 linear equations have no solution
                System.out.println("No solution");
        } // end of else
    } // end of main method
} // end of class Equations
