import java.util.Scanner;
public class A2_2018b_q1
{
    public static void main (String[] args) {
        int[][] arr = new int[][]{{2,0,1,2,3}, {2,3,5,5,4}, {8,-1,6,8,7}, {3,4,7,2,4}, {2,4,3,1,2}}; 
        Scanner scan = new Scanner (System.in);
        String matrix = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix);
        System.out.println(prince(arr, 0, 0));

        String matrix2 = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix2 += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix2 += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix2);
    }

    public static int prince (int[][] drm, int i, int j) {
        int result = prince (drm, i, j, drm[i][j]);
        if (result == drm.length*drm.length+1)
            return -1;
        else return result;
    }

    public static int prince (int[][] drm, int i, int j, int preVal) {
        if (i<0 || i>drm.length-1 || j<0 || j>drm[0].length-1 || drm[i][j] == -5)
            return drm.length*drm.length;       
        if (drm[i][j] == -1)
            return 1;
        if (drm[i][j] > preVal+1 || drm[i][j] < preVal-2)
            return drm.length*drm.length;   
        int temp = drm[i][j];
        drm[i][j] = -5;
        int up = prince(drm, i-1, j, temp);
        int down = prince(drm, i+1, j, temp);
        int left = prince(drm, i, j-1, temp);
        int right = prince(drm, i, j+1, temp);
        drm[i][j] = temp;
        return 1 + Math.min(Math.min(up,down),Math.min(left, right));
    }
}

