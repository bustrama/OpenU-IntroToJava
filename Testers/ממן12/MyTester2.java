/**
 * @author Oren
 */

public class MyTester2 {

	public static void main(String[] args) {
        Point3D p1 = new Point3D(1, 0, 0);
        Point3D p2 = new Point3D(p1);
        Point3D p3 = new Point3D();
        
        p2.move(-1, 0, 0);
        
        if(! p2.equals(p3))
        	System.out.println("Create new point at 0, 0, 0 : *** Failed ***");
        else
        	System.out.println("Create new point at 0, 0, 0 : Ok");

        Box3D b1 = new Box3D(p1, 1, 1, 1);
        Box3D b2 = b1.move(99, 20, 0);
        Box3D b3 = b1.move(96, 0, 72);
        Box3D b4 = b1.move(0, 92, 69);
        Box3D b5 = b1.move(0, 1, 5);
        Box3D b6 = new Box3D(p1, -1, -1, -1);
        Box3D b7 = new Box3D(p2, 2, 2, 2);
        Box3D b8 = new Box3D(p2, 2, 2, 2);
        Box3D b9 = new Box3D();
        Box3D b10 = new Box3D(p2, 0, 0, 0);

        
        b9.setHeight(2);
        b9.setWidth(2);
        b9.setLength(2);
        
        if(b9.getHeight() != b7.getHeight())
        	System.out.println("getHeight : *** Failed ***");
        else
        	System.out.println("getHeight : Ok");
        
        if(b9.getWidth() != b7.getWidth())
        	System.out.println("getWidth : *** Failed ***");
        else
        	System.out.println("getWidth : Ok");
        
        if(b9.getLength() != b7.getLength())
        	System.out.println("getLength : *** Failed ***");
        else
        	System.out.println("getLength : Ok");

        b7.setHeight(40);
        b7.setWidth(40);
        b7.setLength(40);

        b7 = b7.move(40, 0, 0);
        b8 = b8.move(21, 19, 19);
        
        if(! b8.getCenter().equals(b7.getCenter()))
        	System.out.println("getCenter : *** Failed ***");
        else
        	System.out.println("getCenter : Ok");

        b8.setHeight(10);
        b8.setWidth(40);
        b8.setLength(160);
        
        if(b8.getVolume() == b7.getVolume())
        	System.out.println("getVolume check 1 : Ok");
        else
        	System.out.println("getVolume check 1 : *** Failed ***");

        b8.setHeight(10);
        b8.setWidth(40);
        b8.setLength(161);
        
        if(b8.getVolume() != b7.getVolume())
        	System.out.println("getVolume check 2 : Ok");
        else
        	System.out.println("getVolume check 2 : *** Failed ***");
        
        
        b8.setHeight(40);
        b8.setWidth(40);
        b8.setLength(40);
        
        if(b8.getSurfaceArea() == b7.getSurfaceArea())
        	System.out.println("getSurfaceArea check 1 : Ok");
        else
        	System.out.println("getSurfaceArea check 1 : *** Failed ***");

        b8.setHeight(40);
        b8.setWidth(40);
        b8.setLength(41);
        
        if(b8.getSurfaceArea() != b7.getSurfaceArea())
        	System.out.println("getSurfaceArea check 2 : Ok");
        else
        	System.out.println("getSurfaceArea check 2 : *** Failed ***");
        
        
        b8.setHeight(10);
        b8.setWidth(40);
        b8.setLength(160);
        
        if(b8.isLargerCapacity(b7))
        	System.out.println("isLargerCapacity check 1 : *** Failed ***");
        else
        	System.out.println("isLargerCapacity check 1 : Ok");

        b7.setHeight(39);

        if(b8.isLargerCapacity(b7))
        	System.out.println("isLargerCapacity check 2 : Ok");
        else
        	System.out.println("isLargerCapacity check 2 : *** Failed ***");
        
        b7.setHeight(40);
        b8.setHeight(10);
        b8.setWidth(40);
        b8.setLength(161);
        
        if(b8.isLargerCapacity(b7))
        	System.out.println("isLargerCapacity check 3 : Ok");
        else
        	System.out.println("isLargerCapacity check 3 : *** Failed ***");
        
        
        if(! b1.equals(b6))
        	System.out.println("handle negative dimensions values : *** Failed ***");
        else
        	System.out.println("handle negative dimensions values : Ok");
        
        System.out.printf("distance check 1 : ");
        if(b1.distance(b2) != 101)
        	System.out.printf("%s instead of 101\n", b1.distance(b2));
        else
        	System.out.println("Ok");
        
        System.out.printf("distance check 2 : ");
        if(b1.distance(b3) != 120)
        	System.out.printf("%s instead of 120\n", b1.distance(b3));
        else
        	System.out.println("Ok");
        
        System.out.printf("distance check 3 : ");
        if(b1.distance(b4) != 115)
        	System.out.printf("%s instead of 115\n", b1.distance(b4));
        else
        	System.out.println("Ok");
        
        b2.setLength(3);
        b2.setWidth(3);
        b2.setHeight(3);
        
        b1.toString();
        b1 = b1.move(0, 0, 3);
        if (b1.isAbove(b2))
        	System.out.println("isAbove : *** Failed ***");
        else
        	System.out.println("isAbove : Ok");
        
        b1 = b1.move(0, 0, 1);
        if (! b1.isAbove(b2))
        	System.out.println("isAbove : *** Failed ***");
        else
        	System.out.println("isAbove : Ok");
        
        if (b1.getUpRightBackPoint().equals(b5.getBase()))
        	System.out.println("isAbove : *** Failed ***");
        else
        	System.out.println("isAbove : Ok");
        
        System.out.printf("contains : ");
        if (! b2.contains(b1))
        	System.out.printf("contains : b2 should contain b1 %s\n", b2.contains(b1));
        else
        	System.out.println("Ok");
        
        b2.setLength(1);
        b2.setWidth(1);
        b2.setHeight(1);
        
        System.out.printf("contains : ");
        if (b2.contains(b1))
        	System.out.printf("contains : b2 should not contain b1\n", b2.contains(b1));
        else
        	System.out.println("Ok");
        
        System.out.printf("center b1 : %s\n", b1.toString());
        System.out.printf("center b2 : %s\n", b2.toString());
        System.out.printf("center b3 : %s\n", b3.toString());
        System.out.printf("center b4 : %s\n", b4.toString());
        System.out.printf("center b5 : %s\n", b5.toString());
        System.out.printf("center b6 : %s\n", b6.toString());
        System.out.printf("center b7 : %s\n", b7.toString());
        System.out.printf("center b8 : %s\n", b8.toString());
        System.out.printf("center b10 : %s\n", b10.toString());
	}
}
