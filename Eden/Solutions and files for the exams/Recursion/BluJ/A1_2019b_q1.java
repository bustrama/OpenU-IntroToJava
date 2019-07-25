import java.util.Scanner;
public class A1_2019b_q1

{
    public static void main (String[] args) {
        int[][] arr = new int[][]{{1,1,1,1,1,1,1}, {1,1,0,1,0,0,1}, {1,1,1,1,0,1,1}}; 
        Scanner scan = new Scanner (System.in);
        String matrix = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix);
        System.out.println(longestPath(arr, 2, 5));

        String matrix2 = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix2 += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix2 += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix2);
    }

    public static int longestPath (int[][] mat, int x, int y) {
        return longestPath (mat, x, y, 0, 0);
    }

    private static int longestPath (int[][] mat, int x, int y, int r, int c) {
        if ((r==x) && (c==y))
            return 1;
        if (!(insideBounds(mat, r, c)) || (mat[r][c] == 0))
            return 0;
        mat[r][c] = 0;
        int up = longestPath (mat, x, y, r-1, c);
        int down = longestPath (mat, x, y, r+1, c);
        int left = longestPath (mat, x, y, r, c-1);
        int right = longestPath (mat, x, y, r, c+1);
        mat[r][c] = 1;
        return 1 + Math.max(Math.max(up,down),Math.max(left, right));
    }

    private static boolean insideBounds (int [][] mat, int r, int c) {
        return (r>=0 && r<mat.length && c>=0 && c<mat[0].length);     
    } 
}
