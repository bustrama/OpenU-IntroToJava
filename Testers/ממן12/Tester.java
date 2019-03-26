public class Tester {
    public static final String NOT_OK = "\n\t\t\t \u001B[31m Not Ok \u001B[0m";
    public static final String OK = "\n\t\t\t \u001B[34m OK! \u001B[0m";

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

        pointValues.setX(5);

        System.out.print("Checking Aliasing: ");
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

    }
}
