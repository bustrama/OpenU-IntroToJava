/**
 * MMN14
 *
 * @author Ben Brandes
 * @version 31.05.19
 */
public class Ex14 {

    /**
     * Calculates the rain water that can be contained within the given heights array
     * <p>
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     *
     * @param heights - the heights array
     * @return the rain water that can be contained within the given heights array
     */
    public static int waterVolume(int[] heights) {
        int left = 0;                           // First tower
        int right = heights.length - 1;         // Last tower
        int totalWater = 0;                     // Total water volume
        int highestLeft = 0, highestRight = 0;  // Highest Tower on the right and left

        // This loop will advance each side until they meets
        while (left < right) {
            // Enter this condition if the right bar is higher than the left one
            if (heights[left] < heights[right]) {
                // Enter this condition if the current bar is higher than the highest
                if (heights[left] >= highestLeft) {
                    highestLeft = heights[left];
                }
                // Enter this loop if lower than the highest left bar
                else {
                    totalWater += (highestLeft - heights[left]);
                }
                left++; // Advance 1 step to the right
            }
            // Enter this condition if the right bar is lower than the left one or equal
            else {
                // Enter this condition if the current bar is higher than the highest
                if (heights[right] >= highestRight) {
                    highestRight = heights[right];
                }
                // Enter this loop if lower than the highest right bar
                else {
                    totalWater += (highestRight - heights[right]);
                }
                right--;
            }
        }

        return totalWater;
    }


    /**
     * A.   The method return the number of continuous cells that their sum is even.
     *
     * B.   Time Complexity - o(n^3)
     * Space Complexity - o(1)
     *
     * C.   Written below.
     *
     * D.   Time Complexity - o(n) - Two loops that runs separately with constant size.
     * Space Complexity - o(1) - Fixed number of variables that has been created.
     *
     * @param a - the array that will be checked
     * @return return the number of continuous cells that their sum is even
     */
    public static int what(int[] a) {
        int sum = 0;

        // Calculate the sum of the entire array
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum % 2 == 0) // if the whole array is even return it's length
            return a.length;
        else {
            int left = 0;               // Initial to the first cell
            int right = a.length - 1;   // Initial to the last cell

            while (left <= right) {      // Will run until they meet in the middle
                if (a[left] % 2 != 0)   // Check whether the left cell is odd number
                    return right;       // If it's odd number then, Odd - Odd = even, then return it's place
                else if (a[right] % 2 != 0) // Check whether the right cell is odd number
                    return right;       // If it's odd number then, Odd - Odd = even, then return it's place
                else {                  // If none is odd number then move towards the center
                    right--;
                    left++;
                }
            }
        }
        return 0;
    }


    /**
     * The function shows all the possible combinations for triplets that will sum the given number
     *
     * @param num - The given number
     * @return all the possible combinations for triplets that will sum the given number
     */
    public static int solutions(int num) {
        if (num < 3 || num > 30)
            return 0;
        else {
            return solutions(num, 1, 1, 1, 0);
        }
    }

    private static int solutions(int num, int x1, int x2, int x3, int counter) {
        if (x1 + x2 + x3 == num) { // print if it's the sum of the given number
            System.out.println(x1 + " + " + x2 + " + " + x3);
            counter++;
        }
        if (x1 == 10) { // All the possible options until x1 will be 10
            if (x2 == 10) { // All the possible options until x2 will be 10
                if (x3 == 10) { // All the possible options until x3 will be 10
                    return counter;
                } else {
                    x1 = 1;
                    x2 = 1;
                    return solutions(num, x1, x2, x3 + 1, counter); // Increase x3 by 1
                }
            } else {
                x1 = 1;
                return solutions(num, x1, x2 + 1, x3, counter); // Increase x2 by 1
            }
        } else
            return solutions(num, x1 + 1, x2, x3, counter); // Increase x1 by 1
    }


    /**
     * The function tries to create a path that will sum the given number parameter
     *
     * @param mat  - The 2D array that will be searched
     * @param sum  - The given sum number to reach
     * @param path - Will be marked as the path
     * @return
     */
    public static boolean findSum(int mat[][], int sum, int path[][]) {
        return findSum(mat, path, sum, 0, 0);
    }

    private static boolean findSum(int[][] mat, int[][] path, int sum, int i, int j) {
        // Simulate nested loop, go through the rows and then columns
        if (i == mat.length - 1) {
            if (j == mat.length - 1) {
                return lookAround(mat, path, sum, i, j, 0); // last cell condition
            } else {
                // If it's not the last column
                i = 0;
                return lookAround(mat, path, sum, i, j, 0) ? true : findSum(mat, path, sum, i, j + 1);
            }
        } else {
            // If it's not the last row
            return lookAround(mat, path, sum, i, j, 0) ? true : findSum(mat, path, sum, i + 1, j);

        }
    }

    private static boolean lookAround(int[][] mat, int[][] path, int sum, int i, int j, int tempSum) {
        // Checks array out of bounds
        if (j >= mat.length || i >= mat.length || i < 0 || j < 0)
            return false;

        // Checks if the cell has been marked before
        if (path[i][j] == 1)
            return false;

        tempSum += mat[i][j];   // Add to tempSum
        path[i][j] = 1;         // Mark the path

        // If reached to the given sum, return true
        if (tempSum == sum)
            return true;

        boolean right = lookAround(mat, path, sum, i, j + 1, tempSum); // Recursive call with right neighbor
        boolean left = lookAround(mat, path, sum, i, j - 1, tempSum); // Recursive call with left neighbor
        boolean down = lookAround(mat, path, sum, i + 1, j, tempSum); // Recursive call with lower neighbor
        boolean up = lookAround(mat, path, sum, i - 1, j, tempSum); // Recursive call with upper neighbor

        boolean checkPath = right || left || up || down;

        if (!(checkPath)) { // If it's not the right path unmark
            path[i][j] = 0;
        }
        return checkPath;
    }
}
