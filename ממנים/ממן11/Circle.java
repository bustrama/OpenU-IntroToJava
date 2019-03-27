/*
 *  Author: Ben Brandes
 *  ID: ***REMOVED***
 *  Date: 16/03/19
 */

import java.util.Scanner;

public class Circle{
    // The user gives input for the corners coordiantes
    // according to this we'll calculate the radius, area and perimeter
    // of the Incircle and the Excircle
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("This program calculates the areas "
                + "and the perimeters of the excircle and the incircle of the given rectangle");

        System.out.println("Please enter the two coordiantes of the left-upper point of the rectangle");
        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();

        System.out.println("Please enter the two coordiantes of the right-lower point of the rectangle");
        int rightDownX = scan.nextInt();
        int rightDownY = scan.nextInt();

        /*      Circle Calculations         */

        // Incircle radius calculation
        double incircleRadius = (leftUpY - rightDownY)/2.0;
        // Excircle radius calculation
        double excircleRadius = (Math.sqrt(Math.pow((leftUpX-rightDownX), 2) + Math.pow((leftUpY-rightDownY), 2)))/2;

        // Incircle area calculation
        double incircleArea = Math.PI * Math.pow(incircleRadius, 2);
        // Excircle area calculation
        double excircleArea = Math.PI * Math.pow(excircleRadius, 2);

        // Incircle perimeter calculation
        double incirclePerimeter = 2 * Math.PI * incircleRadius;
        // Excircle perimeter calculation
        double excirclePerimeter = 2 * Math.PI * excircleRadius;

        /*    End of Circle Calculations    */

        System.out.println("Incircle: radius = " + incircleRadius + ", area = " + incircleArea + ", perimeter = " + incirclePerimeter);
        System.out.println("Excircle: radius = " + excircleRadius + ", area = " + excircleArea + ", perimeter = " + excirclePerimeter);
    }
}