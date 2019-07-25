import java.util.Scanner;
public class A2_2019a_q1
{
    public static void main (String[] args) {
        int[][] arr = new int[][]{{2,1,3,7,9}, {5,3,10,11,2}, {4,12,13,14,1}, {1,16,2,15,2}}; 
        Scanner scan = new Scanner (System.in);
        String matrix = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix);
        System.out.println(howManyPaths(arr));

        String matrix2 = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix2 += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix2 += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix2);
    }

    
    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    public static int howManyPaths(int[][] mat, int i, int j){
        if (!isValid(mat, i, j) || mat[i][j] == 0)
            return 0;

        if (i == mat.length-1 && j == mat[0].length-1)
            return 1;

        int k = mat[i][j];
        mat[i][j] = 0;

        int up = howManyPaths (mat, i-k, j);
        int down = howManyPaths(mat, i+k, j);
        int right = howManyPaths(mat, i, j+k);
        int left = howManyPaths(mat, i, j-k);

        mat[i][j] = k;
        return (up + down + right + left); 

    }

    public static boolean isValid( int[][] mat , int i, int j){
        return (i>=0 && j>=0 && i<mat.length && j<mat[0].length);
    }
}
