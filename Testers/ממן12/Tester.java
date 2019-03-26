public class Tester {
    public static final String NOT_OK = "\n\t\t\t\t\t\t Not Ok!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    public static final String OK = "\n\t\t\t\t\t\t OK!";

    public static void main(String[] args){
        System.out.println("**********************************");
        System.out.println("**      Tester for Point3D      **");
        System.out.println("**********************************");
        testPoint();
        System.out.println();
        System.out.println("**********************************");
        System.out.println("**       Tester for Box3D       **");
        System.out.println("**********************************");
        testBox();
    }

    public static void testPoint(){
        Point3D pointDefault = new Point3D();
        Point3D pointValues = new Point3D(1,2,3);
        Point3D pointCopy = new Point3D(pointValues);

        System.out.print("Checking Aliasing: ");
        pointValues.setX(5);
        if(pointValues.getX() == pointCopy.getX())
            System.out.println(NOT_OK);
        else
            System.out.println(OK);

        System.out.print("Checking Setters: ");
        pointDefault.setX(10);
        pointDefault.setY(20);
        pointDefault.setZ(30);
        if(pointDefault.getX() == 10 && pointDefault.getY() == 20 && pointDefault.getZ() == 30){
            System.out.println(OK);
        }else{
            System.out.println(NOT_OK);
        }

        System.out.print("Checking toString: ");
        if(pointCopy.toString().equals("(1.0,2.0,3.0)")){
            System.out.println(OK);
        }else{
            System.out.println(NOT_OK);
            System.out.println("\t\t Should like this: (1.0,2.0,3.0)");
        }

        System.out.print("Checking equals: ");
        if(!pointValues.equals(pointCopy)){
            pointCopy = new Point3D(5,2,3);
            if(pointValues.equals(pointCopy))
                System.out.println(OK);
            else
                System.out.println(NOT_OK);
        }else
            System.out.println(NOT_OK);

        System.out.print("Checking isAbove: ");
        pointValues.setZ(30);
        if(pointDefault.isAbove(pointCopy) && !pointDefault.isAbove(pointValues)){
            System.out.println(OK);
        }else
            System.out.println(NOT_OK);

        System.out.print("Checking isUnder: ");
        if(pointCopy.isUnder(pointDefault) && !pointDefault.isUnder(pointValues))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking isLeft: ");
        if(pointValues.isLeft(pointDefault) && !pointValues.isLeft(pointCopy))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking isRight: ");
        if(pointDefault.isRight(pointValues) && !pointValues.isRight(pointCopy))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking isBehind: ");
        if(pointCopy.isBehind(pointDefault) && !pointCopy.isBehind(pointValues))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking isInFrontOf: ");
        if(pointDefault.isInFrontOf(pointCopy) && !pointCopy.isInFrontOf(pointValues))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking Move: ");
        pointCopy.move(2,2,2);
        pointDefault.move(0,-10,-20);
        pointValues.move(-10,-17, -60);
        if(pointCopy.equals(new Point3D(7,4,5)) && pointDefault.equals(new Point3D(10,10,10)) && pointValues.equals(new Point3D(-5,-15,-30)))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        //Default:  (10,10,10)
        //Values:   (5,2,30)
        //Copy:     (-5,-15,-30)
        System.out.print("Checking Distance: ");
        double calc = Math.sqrt((Math.pow(pointCopy.getX() - pointDefault.getX(), 2)) + (Math.pow(pointCopy.getY() - pointDefault.getY(), 2)) + (Math.pow(pointCopy.getZ() - pointDefault.getZ(), 2)));
        if(pointCopy.distance(pointDefault) == calc)
            System.out.println(OK);
        else
            System.out.println(NOT_OK);
    }

    public static void testBox(){
        Box3D boxDefault = new Box3D();
        Box3D boxValues = new Box3D(new Point3D(1,2,3), 3,4,5);
        Box3D boxCopy = new Box3D(boxValues);

        System.out.print("Checking Aliasing: ");
        boxValues.getBase().setX(5);
        if(boxCopy.getCenter().getX() == boxValues.getBase().getX())
            System.out.println(NOT_OK);
        else
            System.out.println(OK);

        System.out.print("Checking Measures Setters: ");
        boxDefault.setLength(10);
        boxDefault.setHeight(-5);
        boxDefault.setWidth(0);
        if(boxDefault.getLength() == 10 && boxDefault.getHeight() == 1 && boxDefault.getWidth() == 1)
            System.out.println(OK);
        else
            System.out.println(NOT_OK + "\n Check חיובי ממש");

        System.out.print("Checking Base Setter: ");
        Point3D p = new Point3D(7,7,7);
        boxDefault.setBase(p);
        p.setY(8); // For Aliasing check
        if(boxDefault.getBase().equals(new Point3D(7,7,7)))
            System.out.println(OK);
        else if(boxDefault.getBase().getY() == 8)
            System.out.println("Check for Aliasing");
        else
            System.out.println(NOT_OK);

        System.out.print("Checking toString: ");
        boxDefault = new Box3D(new Point3D(3,4,5), 10, 14, 6);
        if(boxDefault.toString().equals("The base point is (3.0,4.0,5.0), length = 10, width = 14, height = 6"))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking Equals: ");
        if(boxDefault.equals(new Box3D(new Point3D(3,4,5), 10, 14, 6)))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking move: ");
        if(boxValues.move(0,3,2).getBase().equals(new Point3D(5,5,5)) && boxValues.getBase().equals(new Point3D(5,2,3)))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking getUpRightBackPoint: ");
        p = new Point3D(boxCopy.getBase().getX()-boxCopy.getLength(), boxCopy.getBase().getY() + boxCopy.getWidth(), boxCopy.getBase().getZ() + boxCopy.getHeight());
        if(boxCopy.getUpRightBackPoint().equals(p))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking getCenter: ");
        p = new Point3D(boxCopy.getBase().getX()-boxCopy.getLength()/2.0, boxCopy.getBase().getY() + boxCopy.getWidth()/2.0, boxCopy.getBase().getZ() + boxCopy.getHeight()/2.0);
        if(boxCopy.getCenter().equals(p))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking Distance: ");
        double calc = Math.sqrt((Math.pow(boxCopy.getCenter().getX() - boxDefault.getCenter().getX(), 2)) + (Math.pow(boxCopy.getCenter().getY() - boxDefault.getCenter().getY(), 2)) + (Math.pow(boxCopy.getCenter().getZ() - boxDefault.getCenter().getZ(), 2)));
        if(boxDefault.distance(boxCopy) == calc)
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking getVolume: ");
        if(boxCopy.getVolume() == (boxCopy.getHeight() * boxCopy.getWidth() * boxCopy.getLength()))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking getSurfaceArea: ");
        double surfaceArea = 2 * (boxValues.getWidth() * boxValues.getHeight() + boxValues.getLength() * boxValues.getWidth() + boxValues.getLength() * boxValues.getHeight());
        if(boxValues.getSurfaceArea() == surfaceArea)
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking isLargerCapacity: ");
        boolean check = (boxCopy.getVolume() > boxValues.getVolume()) ? true : false;
        if(boxCopy.isLargerCapacity(boxValues) == check)
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking contains: ");
        check = (boxDefault.getLength() > boxCopy.getLength()) && (boxDefault.getHeight() > boxCopy.getHeight()) && (boxDefault.getWidth() > boxCopy.getWidth());
        if(boxDefault.contains(boxCopy) == check)
            System.out.println(OK);
        else
            System.out.println(NOT_OK);

        System.out.print("Checking isAbove: ");
        boxDefault = new Box3D();
        boxCopy = new Box3D(new Point3D(2,2,2), 2,2,2);
        boxValues = new Box3D(new Point3D(0.5,0.5,0.5), 1,1,1);
        if(boxCopy.isAbove(boxDefault) && !boxValues.isAbove(boxDefault))
            System.out.println(OK);
        else
            System.out.println(NOT_OK);
    }
}
