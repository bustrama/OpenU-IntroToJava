import java.util.Scanner;
public class A4_2018a_q1
{
    public static void main (String[] args) {
        int[][] arr = new int[][]{{3,13,15,28,30}, {55,54,53,25,22}, {54,12,52,51,50}, {50,10,8,53,11}}; 
        Scanner scan = new Scanner (System.in);
        String matrix = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix);
        System.out.println(longestSlope(arr, 3));
    }

    public static int longestSlope (int[][] mat, int num) {
        return checkAllCells (mat, num, 0, 0);
    }

    private static int checkAllCells (int[][] mat, int num, int i, int j) {
        if (!isValid(mat, i, j)) {
            if (i == mat.length -1)
                return 0;               
            else 
                return Math.max(longestSlope(mat,num,i,j,mat[i][j-1]), checkAllCells(mat, num, i+1, 0));
        }
        return Math.max(longestSlope(mat,num,i,j,mat[i][j]+num), checkAllCells(mat, num, i, j+1));
    }

    private static int longestSlope (int[][] mat, int num, int i, int j, int prev) {
        if (!isValid(mat, i, j) || ((prev - num) != mat[i][j]))
            return 0;
        int up = longestSlope (mat, num, i-1, j, mat[i][j]);
        int down = longestSlope (mat, num, i+1, j, mat[i][j]);
        int left = longestSlope (mat, num, i, j-1, mat[i][j]);
        int right = longestSlope (mat, num, i, j+1, mat[i][j]);
        return 1 + Math.max(Math.max(up,down),Math.max(left, right));
    }

    private static boolean isValid(int [][] mat, int r, int c) {
        return (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length);     
    } 
}
