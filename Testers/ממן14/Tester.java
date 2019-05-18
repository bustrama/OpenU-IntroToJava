import java.util.Random;

public class Tester {
    final static String GOOD = "\t\t\t OK!";
    final static String BAD = "\t\t\t *** Bummer you're wrong! ***";

    public static void main(String[] args) {
        System.out.println("******************************************");
        System.out.println("***                                    ***");
        System.out.println("***            MMN14 Tester            ***");
        System.out.println("***                                    ***");
        System.out.println("******************************************");
        System.out.println();
        Ex14 ex14 = new Ex14();

        /*         Question 1         */
        System.out.println("Question 1: ");
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};                           // 0
        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 3};                                   // 1
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};                                   // 0
        int[] arr4 = {2, 1, 1, 20, 1, 1, 2, 3};                                     // 7
        int[] arr5 = {2, 1, 5, 1, 4, 1, 1, 1, 2};                                   // 7
        int[] arr6 = {9, 8, 7, 6, 5, 4, 3, 2, 1};                                   // 0
        int[] arr7 = {1, 5, 4, 3, 2, 1, 3, 3, 3, 3, 2, 1, 2, 6, 6, 5, 4, 3, 2, 1};  // 28
        boolean trapWater = (ex14.waterVolume(arr) == 0) && (ex14.waterVolume(arr2) == 1) &&
                (ex14.waterVolume(arr3) == 0) && (ex14.waterVolume(arr4) == 7) && (ex14.waterVolume(arr5) == 7) &&
                (ex14.waterVolume(arr6) == 0) && (ex14.waterVolume(arr7) == 28);
        if(trapWater)
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        /*         Question 2         */
        System.out.println("Question 2: ");
        int[] temp = checkWTF();
        if(temp == null)
            System.out.println(GOOD);
        else {
            System.out.println(BAD);
            System.out.println("\t\t\t The Array: " + printArr(temp));
            System.out.println("\t\t\t Expected: " + what(temp));
            System.out.println("\t\t\t Your stupid method: " + ex14.what(temp));
        }

    }

    public static String printArr(int[] arr){
        String ar = "";
        for (int i = 0; i < arr.length; i++) {
            ar += arr[i] + ", ";
        }
        return ar;
    }

    public static int[][] generateArrays(){
        int[][] mat = new int[10][];
        Random rnd = new Random();

        for (int i = 0; i < mat.length; i++) {
            mat[i] = new int[rnd.nextInt(30)];
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = rnd.nextInt(200);
            }
        }

        return mat;
    }

    public static int[] checkWTF(){
        Ex14 ex14 = new Ex14();
        int[][] mat = generateArrays();
        for (int i = 0; i < mat.length; i++) {
            if(ex14.what(mat[i]) != what(mat[i]))
                return mat[i];
        }
        return null;
    }

    private static int f (int[]a, int low, int high)
    {
        int res = 0;
        for (int i=low; i<=high; i++)
            res += a[i];
        return res;
    }
    public static int what (int []a)
    {
        int temp = 0;
        for (int i=0; i<a.length; i++)
        {
            for (int j=i; j<a.length; j++)
            {
                int c = f(a, i, j);
                if (c%2 == 0)
                {
                    if (j-i+1 > temp)
                        temp = j-i+1;
                }
            }
        }
        return temp;
    }
}
