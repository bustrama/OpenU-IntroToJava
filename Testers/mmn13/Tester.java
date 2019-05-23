/**
 * @author Ben
 * @version v1.2
 *
 * שימו לב שבבדיקה של המטריקס, הבדיקה מסתמכת על toString אז יש לדאוג שהוא תקין
 *
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tester {
    final static String GOOD = "\t\t\t OK!";
    final static String BAD = "\t\t\t ** Oh snap! something is broken **";
    final static  String ALIASING = "\t\t\t ** Aliasing Problem ! **";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;

        boolean run = true;

        while (run) {
            System.out.println("*****************************************");
            System.out.println("*****         Mmn 13 Tester         *****");
            System.out.println("*****************************************");
            System.out.print("\n 1. Test Collection \n 2. Test Matrix \n 3. Test Both \n 4. Print Collection " +
                    "\n 5. Print Matrix \n 6. Quit. \n Choose an option: ");

            try {
                option = input.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("\n ***    Enter a number smart pants    ***");
                option = 0;
                input.next();
            }

            if (option != 0) {
                switch (option) {
                    case 1:
                        testCollection();
                        break;
                    case 2:
                        testMatrix();
                        break;
                    case 3:
                        testCollection();
                        testMatrix();
                        break;
                    case 4:
                        printCollection();
                        break;
                    case 5:
                        printMatrix();
                        break;
                    case 6:
                        run = false;
                        break;
                    default:
                        System.out.println("Enter a number from the options above");
                        break;
                }
            }

            System.out.println();
        }
    }

    public static void testCollection() {
        System.out.println();
        System.out.println("*******************************************");
        System.out.println("****         Collection Tester         ****");
        System.out.println("*******************************************");

        Collection coll = new Collection();

        Box3D mostUpper = coll.mostUpperBaseCorner();

        System.out.println("Checking Constructor: ");
        if(coll.getNumOfBoxes() == 0 && coll.getBoxes().length == 0)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        for (int i = 49; i >= 0; i--) {
            boolean cont = coll.addBox(new Point3D(i,i+1,i+2), i+1, i, i+3);
        }

        System.out.println("Checking Array sorted by volume:  ");
        String sorted = isSorted(coll);
        if(sorted == "true")
            System.out.println(GOOD);
        else if (sorted == "null")
            System.out.println("You've holes in the array");
        else
            System.out.println(BAD);

        Collection coll3 = new Collection();
        coll3.addBox(new Point3D(), 1 , 1, 1);
        Box3D highestBox = coll3.mostUpperBaseCorner();
        highestBox.setBase(new Point3D(2,2,2));

        System.out.println("Checking mostUpperBaseCorner: ");
        if(coll3.mostUpperBaseCorner().equals(highestBox))
            System.out.println(ALIASING);
        else if(coll.mostUpperBaseCorner().toString().equals("The base point is (49.0,50.0,51.0), length = 50, width = 49, height = 52") && mostUpper == null)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Checking totalSurfaceArea: ");
        if(coll.totalSurfaceArea() == 262458.0)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Checking longestDistance: " );
        if(coll.longestDistance() == 106.44951855222267 && coll3.longestDistance() == 0)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Checking howManyContains: ");
        if(coll.howManyContains(new Box3D(new Point3D(2,2,2), 5,7,8)) == 42)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        boolean smallestVolume = (coll.volumeOfSmallestBox(40, 48) == 127400) && (coll.volumeOfSmallestBox(40, 101) == 0) &&
                (coll.volumeOfSmallestBox(70, 8) == 0) && (coll.volumeOfSmallestBox(0, 3) == 140) &&
                (coll.volumeOfSmallestBox(6, 6) == 560) && (coll.volumeOfSmallestBox(-1, 2) == 0);

        System.out.println("Checking volumeOfSmallestBox: ");
        if(smallestVolume)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Checking getNumOfBoxes: ");
        if(coll.getNumOfBoxes() == 50)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        // Aliasing check
        Box3D[] boxes = coll3.getBoxes();
        boxes[0].setBase(new Point3D(5,5,5));
        // Get all boxes
        Box3D[] arr = coll.getBoxes();

        System.out.println("Checking getBoxes: ");
        if(coll3.getBoxes()[0].equals(boxes[0]))
            System.out.println(ALIASING);
        else if(arr.length == 50 && !nullExist(arr))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        Collection coll2 = new Collection();
        coll2.addBox(new Point3D(), 1, 1, 1);

        System.out.println("Checking toString: ");
        if(coll2.toString().equals("Box no. 1: The base point is (0.0,0.0,0.0), length = 1, width = 1, height = 1\n"))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Checking addBox functionality: ");
        Box3D box = new Box3D(coll.getBoxes()[coll.getNumOfBoxes()-1]);
        box.setBase(new Point3D());
        coll.addBox(new Point3D(), box.getLength(), box.getWidth(), box.getHeight());
        if(coll.getBoxes()[coll.getNumOfBoxes()-2].equals(box))
            System.out.println(GOOD);
        else
            System.out.println(BAD);
    }

    public static String isSorted(Collection coll){
        Box3D[] arr = coll.getBoxes(); // Aliasing doesn't matter cause we're not altering the values
        for (int i = 0; i < coll.getNumOfBoxes()-1; i++) {
            if(arr[i] == null)
                return "null";
            if(arr[i].getVolume() > arr[i+1].getVolume())
                return "false";
        }
        return "true";
    }

    public static boolean nullExist(Box3D[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null)
                return true;
        }
        return false;
    }

    public static void printCollection(){
        Collection coll = new Collection();

        boolean condition = true;
        Random rand = new Random();
        int i = 500;
        while(condition) {
            boolean cont = coll.addBox(new Point3D(rand.nextInt(i), rand.nextInt(i), rand.nextInt(i)), i, i+2, i*2);
            if(!cont)
                condition = false;
            i-=4;
        }

        System.out.println(coll.toString());
        System.out.println("Done printing 100 boxes with random values");

        System.out.println("\n********** Methods **********");
        System.out.println("mostUpperBaseCorner: \n\t\t\t\t" + coll.mostUpperBaseCorner());
        System.out.println("totalSurfaceArea: \n\t\t\t\t" + coll.totalSurfaceArea());
        Box3D box = new Box3D(new Point3D(2,2,2), 5,7,8);
        System.out.println("howManyContains: \n\t" + coll.howManyContains(box) + " boxes can contain this box: \n\t"  + box.toString());
        System.out.println("volumeOfSmallestBox: \n\t\t\t\t" + coll.volumeOfSmallestBox(40, 68));
        System.out.println("getNumOfBoxes: \n\t\t\t\t" + coll.getNumOfBoxes());
    }

    static int m[][] = {
            {19, 124, 28, 35, 38},
            {115, 22, 25, 230, 31},
            {9, 21, 22, 249, 230},
            {0, 6, 9, 232, 255},
            {2, 5, 10, 116, 129}
    };

    static int oneCol[][] = {
            {19},
            {11},
            {90},
            {20},
            {55}
    };

    static int ma[][] = {
            {19, 124, 28, 35}
    };

    static int rotate[][] = {
            {19, 124, 28, 35},
            {115, 22, 25, 230},
            {19, 21, 22, 249},
            {0, 16, 9, 232},
            {62, 35, 10, 116}
    };

    static int[][] array = {
            {10, 30, 50},
            {100, 150, 200}
    };

    public static void testMatrix() {
        System.out.println();
        System.out.println("*******************************************");
        System.out.println("****          Matrix Tester            ****");
        System.out.println("*******************************************");

        String toCheck;

        Matrix mat = new Matrix(m);
        Matrix matr = new Matrix(ma);
        Matrix col = new Matrix(oneCol);
        Matrix empty = new Matrix(2,2);

        System.out.println("Constructor Aliasing:");
        int[][] alias = { {10, 30, 50}, {100, 150, 200} };
        Matrix aliasing = new Matrix(alias);
        alias[1][1] = 222;
        Matrix aliasing2 = new Matrix(alias);
        if (!aliasing.toString().equals(aliasing2.toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Regular Matrix:");
        toCheck = "19\t124\t28\t35\t38\n115\t22\t25\t230\t31\n9\t21\t22\t249\t230\n0\t6\t9\t232\t255\n2\t5\t10\t116\t129\n";
        String emptyMat = "0\t0\n0\t0\n";
        if (toCheck.equals(mat.toString()) && emptyMat.equals(empty.toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Negative Matrix:");
        toCheck = "236\t131\t227\t220\t217\n140\t233\t230\t25\t224\n246\t234\t233\t6\t25\n255\t249\t246\t23\t0\n253\t250\t245\t139\t126\n";
        if (toCheck.equals(mat.makeNegative().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("Filtered Image Matrix:");
        toCheck = "70\t55\t77\t64\t83\n51\t42\t84\t98\t135\n28\t25\t90\t142\t204\n7\t9\t74\t139\t201\n3\t5\t63\t125\t183\n";
        String toCheck2 = "71\t57\t62\t31\n";
        String colCheck = "15\n40\n40\n55\n37\n";
        if (toCheck.equals(mat.imageFilterAverage().toString()) && toCheck2.equals(matr.imageFilterAverage().toString()) && colCheck.equals(col.imageFilterAverage().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        Matrix m1 = new Matrix(array);
        Matrix rot = new Matrix(rotate);

        System.out.println("90° Clockwise Matrix:");
        toCheck = "62\t0\t19\t115\t19\n35\t16\t21\t22\t124\n10\t9\t22\t25\t28\n116\t232\t249\t230\t35\n";
        toCheck2 = "100\t10\n150\t30\n200\t50\n";
        String toCheck3 = "19\n124\n28\n35\n";
        colCheck = "55\t20\t90\t11\t19\n";
        if (toCheck.equals(rot.rotateClockwise().toString()) && toCheck2.equals(m1.rotateClockwise().toString()) && toCheck3.equals(matr.rotateClockwise().toString()) && colCheck.equals(col.rotateClockwise().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("90° Counter Clockwise Matrix:");
        toCheck = "35\t230\t249\t232\t116\n28\t25\t22\t9\t10\n124\t22\t21\t16\t35\n19\t115\t19\t0\t62\n";
        toCheck2 = "50\t200\n30\t150\n10\t100\n";
        toCheck3 = "35\n28\n124\n19\n";
        colCheck = "19\t11\t90\t20\t55\n";
        if (toCheck.equals(rot.rotateCounterClockwise().toString()) && toCheck2.equals(m1.rotateCounterClockwise().toString()) && toCheck3.equals(matr.rotateCounterClockwise().toString()) && colCheck.equals(col.rotateCounterClockwise().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);
    }

    public static void printMatrix() {
        Matrix mat = new Matrix(m);
        Matrix matr = new Matrix(ma);
        Matrix m1 = new Matrix(array);
        Matrix rot = new Matrix(rotate);
        Matrix col = new Matrix(oneCol);

        System.out.println();
        System.out.println("*** Regular Matrix ***");
        System.out.println();
        System.out.println("*** Example 1:");
        System.out.println(mat.toString());
        System.out.println();
        System.out.println("*** Example 2:");
        System.out.println(matr.toString());
        System.out.println();
        System.out.println("*** Example 3:");
        System.out.println(m1.toString());
        System.out.println();
        System.out.println("*** Example 4:");
        System.out.println(rot.toString());
        System.out.println();
        System.out.println("*** Example 5:");
        System.out.println(col.toString());
        System.out.println();


        System.out.println("*** Negative Matrix ***");
        System.out.println();
        System.out.println("*** Example 1:");
        System.out.println(mat.makeNegative().toString());
        System.out.println();
        System.out.println("*** Example 2:");
        System.out.println(matr.makeNegative().toString());
        System.out.println();
        System.out.println("*** Example 3:");
        System.out.println(m1.makeNegative().toString());
        System.out.println();
        System.out.println("*** Example 4:");
        System.out.println(rot.makeNegative().toString());
        System.out.println();
        System.out.println("*** Example 5:");
        System.out.println(col.makeNegative().toString());
        System.out.println();

        System.out.println("*** Filtered Image Matrix ***");
        System.out.println();
        System.out.println("*** Example 1:");
        System.out.println(mat.imageFilterAverage().toString());
        System.out.println();
        System.out.println("*** Example 2:");
        System.out.println(matr.imageFilterAverage().toString());
        System.out.println();
        System.out.println("*** Example 3:");
        System.out.println(m1.imageFilterAverage().toString());
        System.out.println();
        System.out.println("*** Example 4:");
        System.out.println(rot.imageFilterAverage().toString());
        System.out.println();
        System.out.println("*** Example 5:");
        System.out.println(col.imageFilterAverage().toString());
        System.out.println();

        System.out.println("*** 90° Clockwise Matrix ***");
        System.out.println();
        System.out.println("*** Example 1:");
        System.out.println(mat.rotateClockwise().toString());
        System.out.println();
        System.out.println("*** Example 2:");
        System.out.println(matr.rotateClockwise().toString());
        System.out.println();
        System.out.println("*** Example 3:");
        System.out.println(m1.rotateClockwise().toString());
        System.out.println();
        System.out.println("*** Example 4:");
        System.out.println(rot.rotateClockwise().toString());
        System.out.println();
        System.out.println("*** Example 5:");
        System.out.println(col.rotateClockwise().toString());
        System.out.println();

        System.out.println("*** 90° Counter Clockwise Matrix ***");
        System.out.println();
        System.out.println("*** Example 1:");
        System.out.println(mat.rotateCounterClockwise().toString());
        System.out.println();
        System.out.println("*** Example 2:");
        System.out.println(matr.rotateCounterClockwise().toString());
        System.out.println();
        System.out.println("*** Example 3:");
        System.out.println(m1.rotateCounterClockwise().toString());
        System.out.println();
        System.out.println("*** Example 4:");
        System.out.println(rot.rotateCounterClockwise().toString());
        System.out.println();
        System.out.println("*** Example 5:");
        System.out.println(col.rotateCounterClockwise().toString());
        System.out.println();
    }
}
