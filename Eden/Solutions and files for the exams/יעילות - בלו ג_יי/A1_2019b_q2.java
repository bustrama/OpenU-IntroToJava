import java.util.Scanner;
public class A1_2019b_q2
{
    public static void main (String[] args) {
        int[][] arr = new int[][]{{-99, -72, -64, -55, -28, -10, -5}, {-72, -53, -46, -38, 11, 13, 22}, {-63, -48, -27, -12, 14, 16, 23}, 
                {-44, -29, -10, 0, 18, 20, 28}, {0, 12, 14, 20, 28, 30, 35}}; 
        Scanner scan = new Scanner (System.in);
        String matrix = "";
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length - 1; column++) {
                matrix += arr[row][column] + "\t";            //adding this cell plus a space tab to the String
            } 
            matrix += arr[row][arr[0].length-1] + "\n";    //adding the last cell of the row and descends a line
        }        
        System.out.println(matrix);
        System.out.println(howManyNegativeNumbers(arr));
    }

    public static int howManyNegativeNumbers (int[][] arr) {
        int count = 0;
        int i = arr.length -1, j = 0;

        while ((i!=-1) && (j<arr[i].length)) {
            while (arr[i][j] >= 0)
                i--;
            if (arr[i][j] < 0) {
                count += i+1;
                j++;
            }
        }
        return count;
    }

}