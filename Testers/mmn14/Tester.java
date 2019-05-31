import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

public class Tester {
    final static String GOOD = "\t\t\t OK!";
    final static String BAD = "\t\t\t *** Bummer you're wrong! ***";

    static PrintStream originalStream = System.out;
    static PrintStream dummyStream = new PrintStream(new OutputStream() {
        public void write(int b) {
        }
    });

    public static void main(String[] args) {

        System.out.println("******************************************");
        System.out.println("***                                    ***");
        System.out.println("***            MMN14 Tester            ***");
        System.out.println("***                                    ***");
        System.out.println("******************************************");
        System.out.println();

        /*         Question 1         */
        System.out.println("Question 1: ");
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};                           // 0
        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 3};                                   // 1
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};                                   // 0
        int[] arr4 = {2, 1, 1, 20, 1, 1, 2, 3};                                     // 7
        int[] arr5 = {2, 1, 5, 1, 4, 1, 1, 1, 2};                                   // 7
        int[] arr6 = {9, 8, 7, 6, 5, 4, 3, 2, 1};                                   // 0
        int[] arr7 = {1, 5, 4, 3, 2, 1, 3, 3, 3, 3, 2, 1, 2, 6, 6, 5, 4, 3, 2, 1};  // 28

        boolean trapWater = (Ex14.waterVolume(arr) == 0) && (Ex14.waterVolume(arr2) == 1) &&
                (Ex14.waterVolume(arr3) == 0) && (Ex14.waterVolume(arr4) == 7) && (Ex14.waterVolume(arr5) == 7) &&
                (Ex14.waterVolume(arr6) == 0) && (Ex14.waterVolume(arr7) == 28);

        if (trapWater)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        /*         Question 2         */
        System.out.println("Question 2: ");
        int[] temp = checkWTF();
        if (temp == null)
            System.out.println(GOOD);
        else {
            System.out.println(BAD);
            System.out.println("\t\t\t The Array: " + printArr(temp));
            System.out.println("\t\t\t Expected: " + what(temp));
            System.out.println("\t\t\t Your method: " + Ex14.what(temp));
        }

        /*         Question 3         */
        System.out.println("Question 3: ");
        if (checkSol())
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        /*         Question 4         */
        System.out.println("Question 4: ");
        if (ex4Checker())
            System.out.println(GOOD);
        else
            System.out.println(BAD);

    }

    /*        Helper Methods        */

    private static String printArr(int[] arr) {
        String ar = "";
        for (int i = 0; i < arr.length; i++) {
            ar += arr[i];
            if (i < arr.length - 1)
                ar += ", ";
        }
        return ar;
    }

    /*    Question 2    */
    private static int[][] generateArrays() {
        int[][] mat = new int[1000][];
        Random rnd = new Random();

        for (int i = 0; i < mat.length; i++) {
            mat[i] = new int[rnd.nextInt(30) + 1];
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (int) ((Math.random() * 200) - 100);
            }
        }

        return mat;
    }

    private static int[] checkWTF() {
        int[][] mat = generateArrays();
        for (int i = 0; i < mat.length; i++) {
            if (Ex14.what(mat[i]) != what(mat[i]))
                return mat[i];
        }
        return null;
    }

    private static int f(int[] a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    private static int what(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int c = f(a, i, j);
                if (c % 2 == 0) {
                    if (j - i + 1 > temp)
                        temp = j - i + 1;
                }
            }
        }
        return temp;
    }

    /*    Question 3    */
    private static boolean checkSol() {
        System.setOut(dummyStream);
        int[] ans = new int[]{0, 0, 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1, 0};
        for (int i = 0; i < ans.length; i++) {
            int a = Ex14.solutions(i);
            if (a != ans[i]) {
                System.setOut(originalStream);
                System.out.println("\t\t\t Solutions(" + i + ")");
                System.out.println("\t\t\t Expected: " + ans[i]);
                System.out.println("\t\t\t Got: " + a);
                return false;
            }
        }
        System.setOut(originalStream);
        return true;
    }


    /*    Question 4    */
    private static boolean ex4Checker() {
        int mat1[][] = {{100, 1, 1, 1},
                {100, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};

        int mat1path[][] = {{1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        int mat2[][] = {{100, 1, 1, 1},
                {100, 1, 1, 1},
                {100, 100, 1, 1},
                {1, 1, 1, 1}};

        int mat2path[][] = {{1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}};

        int mat3[][] = {{100, 1, 1, 1},
                {100, 1, 1, 100},
                {100, 100, 100, 100},
                {1, 1, 1, 1}};

        int mat3path[][] = {{1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        int mat4[][] = {{1, 1, 1, 1},
                {1, 100, 100, 1},
                {1, 100, 100, 1},
                {1, 1, 1, 1}};

        int mat4path[][] = {{0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int mat5[][] = {{100}};

        int mat5path[][] = {{1}};

        int mat6[][] = {{100, 100, 100, 100},
                {100, 100, 100, 100},
                {100, 100, 100, 100},
                {100, 100, 100, 100}};

        int mat6path[][] = {{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};

        int mat7[][] = {{1, 100, 1, 1},
                {1, 100, 100, 1},
                {100, 1, 100, 1},
                {100, 100, 100, 1}};

        int mat7path[][] = {{0, 1, 0, 0},
                {0, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 0}};

        int[][] emptyPath = new int[4][4];

        Ex14Mat test1 = new Ex14Mat(mat1, 200);
        Ex14Mat test1Expected = new Ex14Mat(true, mat1path);

        Ex14Mat test1false = new Ex14Mat(mat1, 99999999);
        Ex14Mat test1falseExpected = new Ex14Mat(false, emptyPath);

        Ex14Mat test2 = new Ex14Mat(mat2, 400);
        Ex14Mat test2Expected = new Ex14Mat(true, mat2path);

        Ex14Mat test3 = new Ex14Mat(mat3, 700);
        Ex14Mat test3Expected = new Ex14Mat(true, mat3path);

        Ex14Mat test4 = new Ex14Mat(mat4, 400);
        Ex14Mat test4Expected = new Ex14Mat(true, mat4path);

        Ex14Mat test5 = new Ex14Mat(mat5, 100);
        Ex14Mat test5Expected = new Ex14Mat(true, mat5path);

        Ex14Mat test6 = new Ex14Mat(mat6, 1600);
        Ex14Mat test6Expected = new Ex14Mat(true, mat6path);

        Ex14Mat test7 = new Ex14Mat(mat7, 800);
        Ex14Mat test7Expected = new Ex14Mat(true, mat7path);

        boolean didPass = testMat(test1, test1Expected)
                && testMat(test1false, test1falseExpected)
                && testMat(test2, test2Expected)
                && testMat(test3, test3Expected)
                && testMat(test4, test4Expected)
                && testMat(test5, test5Expected)
                && testMat(test6, test6Expected)
                && testMat(test7, test7Expected);

        return didPass;
    }

    public static boolean testMat(Ex14Mat test, Ex14Mat expected) {
        if (!comparePaths(test.path, expected.path) || test.isPathExists != expected.isPathExists) {
            printMatError(test, expected);
            return false;
        }
        return true;
    }

    private static void printMatError(Ex14Mat test, Ex14Mat expected) {
        System.out.println("Something seems wrong. \n The matrix: \n");
        printPath(test.mat, true);
        System.out.println("\n your answer:\n is there a solution: " + test.isPathExists);
        System.out.println("Your matrix: ");
        printPath(test.path);
        System.out.println("\n Expected result: ");
        System.out.println("Is there a solution: " + expected.isPathExists);
        System.out.println("Expected matrix: ");
        printPath(expected.path);
    }

    private static boolean comparePaths(int[][] exPath, int[][] expectedPath) {
        if (exPath.length != expectedPath.length)
            return false;

        for (int i = 0; i < exPath.length; i++) {
            if (exPath[i].length != expectedPath[i].length)
                return false;
        }

        for (int i = 0; i < exPath.length; i++) {
            for (int j = 0; j < exPath[i].length; j++) {
                if (exPath[i][j] != expectedPath[i][j])
                    return false;
            }
        }
        return true;
    }

    private static int[][] makeMat(int numToFill, int size) {
        int[][] mat = new int[size][size];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = numToFill;
            }
        }
        return mat;
    }

    private static void printPath(int path[][], boolean isMatrix) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                if (isMatrix) {
                    System.out.print(path[i][j] + "\t");
                } else {
                    if (path[i][j] == 1) {
                        System.out.print("[X]");
                    } else {
                        System.out.print("[_]");
                    }
                }
            }
            System.out.println("");
        }
    }

    private static void printPath(int path[][]) {
        printPath(path, false);
    }

    private static class Ex14Mat {
        boolean isPathExists;
        int[][] path;
        int[][] mat;

        public Ex14Mat(boolean isPathExists, int[][] path) {
            this.isPathExists = isPathExists;
            this.path = path;
        }

        public Ex14Mat(int[][] mat, int sum) {
            int[][] path = makeMat(0, mat.length);
            this.mat = mat;
            this.isPathExists = Ex14.findSum(mat, sum, path);
            this.path = path;
        }
    }
}


