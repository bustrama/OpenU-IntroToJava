/**
 * @author David Shambik
 */
public class Maman12Tester
{
    public static void main (String [] args)
    {
        System.out.println("\t\t\t*************************************");
        System.out.println("\t\t\t*             Point3D               *");
        System.out.println("\t\t\t*************************************");        

        Point3D p1 = new Point3D();

        Point3D p2 = new Point3D(1,2,3);
        Point3D p3 = new Point3D(p2);

        if(p2.getX() != 1 && p2.getY() != 2 && p2.getZ() != 3) 
            System.out.println("\nPoint3D(x,y,z) is not working properly");
        else
            System.out.println("\nPoint3D(x,y,z) constructor is ok");

        if(p3.getX() != p2.getX() && p3.getY() != p2.getY() && p3.getZ() != p2.getZ())
            System.out.println("Point3d(Point3D other) is not working properly");
        else
            System.out.println("Point3d(Point3D other) constructor is ok");

        System.out.println("\nCalling Getters...");
        if(p1.getX() != 0)
            System.out.println("\tgetX() is not correct or Point3D constructor is not correct");
        else
            System.out.println("\tgetX() is ok");

        if(p1.getY() != 0)
            System.out.println("\tgetY() is not correct Point3D constructor is not correct");
        else
            System.out.println("\tgetY() is ok");

        if(p1.getZ() != 0)
            System.out.println("\tgetZ() is not correct Point3D constructor is not correct");
        else
            System.out.println("\tgetZ() is ok");

        p1.setX(4);
        p1.setY(5);
        p1.setZ(6);

        System.out.println("\nCalling Setters...");
        if(p1.getX() != 4)
            System.out.println("\tsetX() is not ok");
        else
            System.out.println("\tsetX() is ok");
        if(p1.getY() != 5)
            System.out.println("\tsetY() is not ok");
        else
            System.out.println("\tsetY() is ok");
        if(p1.getZ() != 6)
            System.out.println("\tsetZ() is not ok");
        else
            System.out.println("\tsetZ() is ok");

        System.out.println("\nCalling toString()...");
        if(p1.toString().equals("(4.0,5.0,6.0)"))
            System.out.println("\ttoString() is  ok");
        else
            System.out.println("\ttoString() is not ok");

        System.out.println("\nCalling equals()...");
        if(!p2.equals(p3))
            System.out.println("\tequals() is not ok");
        else
            System.out.println("\tequals() is ok");

        System.out.println("\nCalling isAbove()...");
        Point3D p4 = new Point3D(-1,-2,-3);
        Point3D p5 = new Point3D(-4,-5,-6);
        if(p1.isAbove(p2) && p4.isAbove(p5))
            System.out.println("\tisAbove() is ok");
        else
            System.out.println("\tisAbove() is not ok");

        System.out.println("\nCalling isUnder()...");   
        if(p2.isUnder(p1) && p5.isUnder(p4))
            System.out.println("\tisUnder() is ok");
        else
            System.out.println("\tisUnder() is not ok");

        System.out.println("\nCalling isLeft()..."); 
        if(p2.isLeft(p1))
            System.out.println("\tisLeft() is ok");
        else
            System.out.println("\tisLeft() is not ok");

        System.out.println("\nCalling isRight()..."); 
        if(!p2.isRight(p1))
            System.out.println("\tisRight() is ok");
        else
            System.out.println("\tisRight() is not ok");

        System.out.println("\nCalling isBehind()..."); 
        if(p2.isBehind(p1) && p5.isBehind(p4))
            System.out.println("\tisBehind() is ok");
        else
            System.out.println("\tisBehind() is not ok");

        System.out.println("\nCalling isInFrontOf()..."); 
        if(!p2.isInFrontOf(p1) && !p5.isInFrontOf(p4))
            System.out.println("\tisInFrontOf() is ok");
        else
            System.out.println("\tisInFrontOf() is not ok");

        System.out.println("\nCalling move()...");
        p2.move(1,2,3);
        if(p2.toString().equals("(2.0,4.0,6.0)"))
            System.out.println("\tmove() is ok");
        else
            System.out.println("\tmove() is not ok ");

        System.out.println("\nCalling distance()..."); 
        double distance = p2.distance(p1);
        if(distance == ( Math.sqrt( Math.pow(p2.getX()-p1.getX(),2) + 
                Math.pow(p2.getY()-p1.getY(),2) + Math.pow(p2.getZ()-p1.getZ(),2) ) ))
            System.out.println("\tdistance() is ok");
        else
            System.out.println("\tdistance() is not ok ");

        System.out.println("\n\n\t\t\t*************************************");
        System.out.println("\t\t\t*               Box3D               *");
        System.out.println("\t\t\t*************************************"); 

        Point3D p6 = new Point3D(4,5,6);

        Box3D b1 = new Box3D(p6,2,2,1);
        Box3D b2 = new Box3D();
        Box3D b3 = new Box3D(b2);

        int length = b1.getLength();
        int height = b1.getHeight();
        int width = b1.getWidth();

        if(b2.getBase().toString().equals("(0.0,0.0,0.0)") && b2.getLength() == 1 &&
        b2.getWidth()==1 && b2.getHeight()==1)
            System.out.println("\nBox3D() constructor is ok");
        else
            System.out.println("\nBox3D() constructor is not ok ");

        if(p6.toString().equals("(4.0,5.0,6.0)") && length == 2 && width == 2 &&
        height == 1)
            System.out.println("\nBox3D(length,width,height) constructor is ok");
        else
            System.out.println("\nBox3D(length,width,height) constructor is not ok");

        if(b3.getBase().toString().equals("(0.0,0.0,0.0)") && b3.getLength() == 1 &&
        b3.getWidth()==1 && b3.getHeight()==1)
            System.out.println("\nBox3D(Box3D other) constructor is ok");
        else
            System.out.println("\nBox3D(Box3D other) constructor is not ok ");
        
        b3.setBase(new Point3D(1,2,3));
        b3.setLength(-4);
        b3.setWidth(-4);
        b3.setHeight(-4);
        
        if(b3.getLength() < 1 || b3.getWidth() < 1 || b3.getHeight() < 1)   
            System.out.println("\tSetters and Getters are not OK");
        else
            System.out.println("\tSetters and Getters are OK");
            
        System.out.println("\nCalling Setters & Getters...");
        
        b3.setLength(4);
        b3.setWidth(4);
        b3.setHeight(4);

        if(b3.getBase().toString().equals("(1.0,2.0,3.0)") && b3.getLength() == 4 && 
        b3.getWidth()==4 && b3.getHeight() ==4)
            System.out.println("\tSetters and Getters are OK");
        else
            System.out.println("\tEither Setters or Getters are not ok " + 
                b3.getBase().toString());

        System.out.println("\nCalling toString()...");  
        if(b3.toString().equals("The base point is (1.0,2.0,3.0), length = 4, width = 4, height = 4"))
            System.out.println("\ttoString() is OK");
        else
            System.out.println("\ttoString() is not OK");

        System.out.println("\nCalling equals()...");   
        if(!b3.equals(b1))
            System.out.println("\tequals() is OK");
        else
            System.out.println("\tequals() is not OK");     

        System.out.println("\nCalling move()...");
        Box3D b4 = b3.move(1,2,3);

        if(b3.getBase().toString().equals(b4.getBase().toString()))
            System.out.println("\tmove() is not OK " +"first box is " + b3 + "\n\t" +
                "second box is " + b4+"\n\tcheck for aliasing");
        else
            System.out.println("\tmove() is OK\n");

        System.out.println("\nCalling getUpRightBackPoint()...");  
        Point3D p7 = b4.getUpRightBackPoint();

        if((p7.getX()!= -2) || (p7.getY() != 8) || (p7.getZ() != 10))
            System.out.println( "\tgetUpRightBackPoint() is not OK" + " \n\tbase point is:" + 
                b4.getBase() + "\n\trightupbackpoint is: "+ b4.getUpRightBackPoint() +
                "\n\tshould be: " + "("+(b4.getBase().getX()-b4.getLength())+","+ // x
                (b4.getBase().getY()+b4.getWidth())+","+ // y
                (b4.getBase().getZ()+b4.getHeight())+")" ) ;//z
        else
            System.out.println("\tgetUpRightBackPoint() is OK\n");

        System.out.println("\nCalling getCenter()...");
        Point3D p8 = b4.getCenter();

        if(p8.getX() != 0 || p8.getY() != 6 || p8.getZ() != 8)
            System.out.println("\tgetCenter() is not OK " + "\n\tbase point is: " +
                b4.getBase() + "\n\tcenter point should be:" + 
                "("+(b4.getBase().getX()-b4.getLength()/2.0)+","+ // x
                (b4.getBase().getY()+b4.getWidth()/2.0)+","+ // y
                (b4.getBase().getZ()+b4.getHeight()/2.0)+")");  //z;
        else
            System.out.println("\tgetCenter() is OK");

        if(b4.getBase().equals(p8))
            System.out.println("\tcheck for aliasing");

        System.out.println("\nCalling distance()..."); 
        double dist = b4.distance(b1);

        if(dist - 3.3541019662496847 > 0.001)
            System.out.println("\tdistance() is not OK");   
        else
            System.out.println("\tdistance() is OK"); 

        System.out.println("\nCalling getVolume()..."); 
        double volume1 = b3.getVolume();
        double volume2 = b2.getVolume();

        if(volume1 - 64.0 > 0.001 || volume2 != 1)
            System.out.println("\tgetVolume() is not OK");   
        else
            System.out.println("\tgetVolume() is OK"); 

        System.out.println("\nCalling getSurfaceArea()..."); 
        double surf1 = b3.getSurfaceArea();
        double surf2 = b2.getSurfaceArea();

        if(surf1 != 96 || surf2 != 6)
            System.out.println("\tgetSurfaceArea() is not OK");   
        else
            System.out.println("\tgetSurfaceArea() is OK"); 

        System.out.println("\nCalling isLargerCapacity(Box3D other)...");
        if(!b3.isLargerCapacity(b2))
            System.out.println("\tisLargerCapacity() is not OK");   
        else
            System.out.println("\tisLargerCapacity() is OK");

        System.out.println("\nCalling contains(Box3D other)...");
        if((!b3.contains(b2)) && (b2.contains(b2)))
            System.out.println("\tisLargerCapacity() is not OK");   
        else
            System.out.println("\tisLargerCapacity() is OK");
        

        System.out.println("\nCalling isAbove (Box3D other)...");
        if( !b3.isAbove(b4) && !b4.getBase().isAbove(b3.getUpRightBackPoint()) )
            System.out.println("\tisAbove() is OK");   
        else
            System.out.println("\tisAbove() is not OK");
    }

}
