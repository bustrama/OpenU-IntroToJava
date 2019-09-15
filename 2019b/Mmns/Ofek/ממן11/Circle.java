// ******************************************************************
// This class prints calculation of different attributes in the
// inscribed and the circumscribed circles of a given rectangle
// 
// Author: Ofek Marks
// ID: 325131886
// Version: 16.3.2019
// ******************************************************************

import java.util.Scanner;
public class Circle
{
   /* Gets the x and y values of the left-upper and the right-bottom corners
   of a rectangle, and for both the inscribed and the circumscribed circles
   of the rectangle, the program calculates the radiuses, the areas
   and the perimeters and prints them */
   
   public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the areas " +
            "and the perimeters of the excircle and the incircle " +
            "of a given rectangle ");
        System.out.print("Please enter the two coordinates of the " +
            "left-upper point of the rectangle");
        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();
        
        System.out.print("Please enter the two coordinates of the " +
            "right-bottom point of the rectangle");
        int rightBottomX = scan.nextInt();
        int rightBottomY = scan.nextInt();
        
        /* Calculating the length of the hypotenuse of the rectangle ,which is the distance between the left-upper
        point of the rectangle and the right-bottom point of the rectangle, would give us the diameter (and divided by 2, the radius)
        of the excircle */
        double exRadius = Math.sqrt(Math.pow(rightBottomX - leftUpX, 2) + Math.pow(rightBottomY - leftUpY, 2)) / 2;
        
        double inRadius = (leftUpY - rightBottomY) / 2.0; /* The radius of the incircle is the distance between the counter sides in a rectangle which are parallel to 
                                                             the x axis, divided by 2 */
        
        /* Next, we will calculate the areas and the perimiters of the circles using the following formulas:
        area = PI * radius ^ 2
        perimeter = 2 * PI * radius */
           
        double exArea = Math.PI * Math.pow(exRadius, 2), inArea = Math.PI * Math.pow(inRadius, 2);
        double exPerimeter = 2 * Math.PI * exRadius, inPerimeter = 2 * Math.PI * inRadius;
        
        // Prints the requested message:
        System.out.println("Incircle: radius = " + inRadius + ", area = " + inArea + ", perimiter = " + inPerimeter);
        System.out.println("Excircle: radius = " + exRadius + ", area = " + exArea + ", perimiter = " + exPerimeter);
    } // end of main method
} // end of class Circle