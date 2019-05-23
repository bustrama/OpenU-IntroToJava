/**
 * @author Eden
 */
import java.util.Scanner;
public class TestBox
{
    public static void main (String[] args) 
    {        
        System.out.println("POINT CONSTRUCTORS");
        Point3D pEmpty = new Point3D ();
        Point3D pOrdinary = new Point3D (1,2,3);
        Point3D pOther = new Point3D (pOrdinary);
        System.out.println("empty: "+pEmpty+"\nordinary: "+pOrdinary+"\notherPoint: "+pOther);
        
        System.out.println("\nBOX CONSTRUCTORS");
        Box3D bEmpty = new Box3D();
        Box3D bOrdinary = new Box3D(pOrdinary,1,2,3);
        Box3D bOther = new Box3D(bOrdinary);
        System.out.println("empty: "+bEmpty+"\nordinary: "+bOrdinary+"\notherPoint: "+bOther);
        
        System.out.println("\n\nBOX METHODS");
        Point3D base = new Point3D (2,2,2);
        Box3D box = new Box3D (base,4,2,4);
        
        System.out.println("\nbox: "+box);
        System.out.println("box moving: "+box.move(4,5,6));
        System.out.println("box after moving: "+ box);
        box.setBase(pOrdinary);
        System.out.println("box base after set: "+box.getBase());
        System.out.println("box center: " +box.getCenter());
        System.out.println("box UpRightBackPoint: "+box.getUpRightBackPoint());
        System.out.println("box capacity: "+box.getVolume());
        System.out.println("box Surface Area: " +box.getSurfaceArea());

        Point3D otherBase = new Point3D (2,0,0);
        Box3D otherBox = new Box3D (otherBase,1,-5,3);
        
        System.out.println("\notherBox: "+otherBox);
        System.out.println("otherBox center: "+otherBox.getCenter());
        System.out.println("otherBox UpRightBackPoint: "+otherBox.getUpRightBackPoint());
        System.out.println("otherBox capacity: "+otherBox.getVolume());
        
        System.out.println("\nBOOLEANS");
        System.out.println("distance: "+box.distance(otherBox));
        System.out.println("is box larger? "+box.isLargerCapacity(otherBox));
        System.out.println("is box contains other box? "+box.contains(otherBox));
        System.out.println("is box above other box? "+box.isAbove(otherBox));
    }
}