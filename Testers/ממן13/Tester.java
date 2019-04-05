/**
 * @author Ben
 * @version v1.2
 * שימו לב שבבדיקה של המטריקס, הבדיקה מסתמכת על toString אז יש לדאוג שהוא תקין
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tester {
    final static String GOOD = "\t\t\t OK!";
    final static String BAD = "\t\t\t ** Oh snap! something is broken **";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;

        while (true) {
            System.out.println("*****************************************");
            System.out.println("*****         Mmn 13 Tester         *****");
            System.out.println("*****************************************");
            System.out.print("\n 1. Test Collection \n 2. Test Matrix \n 3. Test Both \n 4. Print Collection " +
                    "\n 5. Print Matrix \n Choose an option: ");

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

        for (int i = 0; i < 50; i++) {
            boolean cont = coll.addBox(new Point3D(i,i+1,i+2), i+1, i, i+3);
        }

        System.out.println("mostUpperBaseCorner: ");
        if(coll.mostUpperBaseCorner().toString().equals("The base point is (49.0,50.0,51.0), length = 50, width = 49, height = 52"))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("totalSurfaceArea: ");
        if(coll.totalSurfaceArea() == 262458.0)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("longestDistance: " );
        if(coll.longestDistance() == 106.44951855222267)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("howManyContains: ");
        if(coll.howManyContains(new Box3D(new Point3D(2,2,2), 5,7,8)) == 42)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("volumeOfSmallestBox: ");
        if(coll.volumeOfSmallestBox(40, 48) == 127400)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("getNumOfBoxes: ");
        if(coll.getNumOfBoxes() == 50)
            System.out.println(GOOD);
        else
            System.out.println(BAD);
    }

    public static void printCollection(){
        Collection coll = new Collection();

        boolean condition = true;
        Random rand = new Random();
        int i = 1;
        while(condition) {
            boolean cont = coll.addBox(new Point3D(rand.nextInt(i), rand.nextInt(i), rand.nextInt(i)), i, i+2, i*2);
            if(!cont)
                condition = false;
            i+=2;
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

        System.out.println("Regular Matrix:");
        toCheck = "19\t124\t28\t35\t38\n115\t22\t25\t230\t31\n9\t21\t22\t249\t230\n0\t6\t9\t232\t255\n2\t5\t10\t116\t129\n";
        if (toCheck.equals(mat.toString()))
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
        if (toCheck.equals(mat.imageFilterAverage().toString()) && toCheck2.equals(matr.imageFilterAverage().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        Matrix m1 = new Matrix(array);
        Matrix rot = new Matrix(rotate);

        System.out.println("90° Clockwise Matrix:");
        toCheck = "62\t0\t19\t115\t19\n35\t16\t21\t22\t124\n10\t9\t22\t25\t28\n116\t232\t249\t230\t35\n";
        toCheck2 = "100\t10\n150\t30\n200\t50\n";
        String toCheck3 = "19\n124\n28\n35\n";
        if (toCheck.equals(rot.rotateClockwise().toString()) && toCheck2.equals(m1.rotateClockwise().toString()) && toCheck3.equals(matr.rotateClockwise().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        System.out.println("90° Counter Clockwise Matrix:");
        toCheck = "35\t230\t249\t232\t116\n28\t25\t22\t9\t10\n124\t22\t21\t16\t35\n19\t115\t19\t0\t62\n";
        toCheck2 = "50\t200\n30\t150\n10\t100\n";
        toCheck3 = "35\n28\n124\n19\n";
        if (toCheck.equals(rot.rotateCounterClockwise().toString()) && toCheck2.equals(m1.rotateCounterClockwise().toString()) && toCheck3.equals(matr.rotateCounterClockwise().toString()))
            System.out.println(GOOD);
        else
            System.out.println(BAD);
    }

    public static void printMatrix() {
        Matrix mat = new Matrix(m);
        Matrix matr = new Matrix(ma);
        Matrix m1 = new Matrix(array);
        Matrix rot = new Matrix(rotate);

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
    }
}
