public class Ex14
{
    // Question no. 1:
    /**
     * The method calculates the capacity of a container
     * @param heights an array filled with the heights of every column in the container
     * @return The capacity of the container
     * <p>Time complexity: <b><i>O</i>(n)</b>
     * <p>Space complexity: <b><i>O</i>(1)</b>
     */
    public static int waterVolume(int[] heights)
    {
        int maxIndex = 0, otherMax = 0, /* The max heights from both sides of the current index */ countWater = 0 /* Eventually, the water capacity of the container */, index = 0;
        for(; index < heights.length; index++) // First, find the max height in the array
            maxIndex = (heights[index] > heights[maxIndex]) ? index : maxIndex;
        for(index = 0; index < maxIndex; index++) // For the indexes to the left of the max height, the max height is their heighest to the right
        {
            if(otherMax < heights[index]) // Finding the max to the left mid-scaning
                otherMax = heights[index];
            else // If there's a max from both sides, subtract the height from the minimal max (left one) to calculate capacity at the index and adds it to the overall capacity
                countWater += otherMax - heights[index];
        }
        for(index = heights.length - 1, otherMax = 0; index > maxIndex; index--) // For the indexes to the right of the max height, the max height is their heighest to the left
        {
            if(otherMax < heights[index]) // Finding the max to the left mid-scaning
                otherMax = heights[index];
            else // If there's a max from both sides, subtracts the height from the minimal max (right one) to calculate capacity at the index and adds it to the overall capacity
                countWater += otherMax - heights[index];
        }
        return countWater;
    }
    // Question no. 2:
    /**
     * The method finds the length of the biggest sub-array which its sum of elements is even
     * @param a an array filled with integers
     * @return The length of the biggest sub-array with an even sum
     * <p><b>Answers:</b>
     * <p>1. The method what returns the length of the longest sub-array with an odd sum
     * <p>2. Method's time complexity: <b><i>O</i>(n^3)</b>, Method's space complexity: <b><i>O</i>(1)</b>
     * <p>4. New method's time complexity: <b><i>O</i>(n)</b> (Scanning the whole array for its sum, with no nested loops or bigger time complexities => <b><i>O</i>(n)</b>),
     * new method's space complexity: <b><i>O</i>(1)</b> 
     */
    public static int what(int[] a)
    {
        int length = a.length, sum = 0;
        for(int index1 = 0; index1 < a.length; index1++) // Calculating the sum of the array
            sum += a[index1];
        if(sum % 2 == 0)
            return length; // If the sum of the whole array, which has the biggest length, is even, we sould return the length of the array
        // Else, which means the sum of the array is odd
        for(int index2 = 0; index2 < a.length / 2; index2++)
        {
            length--;
            // When we get to the first odd element (from the end or from the beginning), the sum of the sub-array from/until this index is the longest sub-array with an even sum
            if(a[index2] % 2 != 0 || a[a.length - 1 - index2] % 2 != 0)
                return length;

        }
        return a.length / 2; // If we havn't found any odd number it's in the middle of the array, so both of the arrays to the middle (with half of the array's length) have even sums
    }

    // Question no. 3:
    /**
     * The method finds how many solutions are for the equation: <b> x1 + x2 + x3 = num</b>
     * <p>In addition, the method prints all the soultions in the format: <b> x1 + x2 + x3</b>
     * @param num the sum of the three solutions
     * @return The number of solutions
     */
    public static int solutions(int num)
    {
        int solution1 = 1, solution2 = 1; // The first two solutions and the counter are initiated
        return solutions(num, solution1, solution2); // Calling the "main" method that returns the amount of solutions and prints them
    }
    
    private static int solutions(int num, int solution1, int solution2)
    {
        final int MAX_X = 10; // The maximal value allowed for a variable
        if(solution1 > num - 2 || solution1 > MAX_X) // If the first solution is bigger then (num - 2), or it isn't in the requested range, the equation has no more solutions
            return 0;
        /* If the second solution is bigger then (num - solution1 - 1), the third solution won't be a positive number.
        Due to that, the second solution is reinitiated to 1 and the first solution is incremented. Also, the second solution should be in the requested range */
        if(solution2 > num - solution1 - 1 || solution2 > MAX_X)
            return solutions(num, ++solution1, 1);
        // Otherwise, we have a new solution, that we should print
        int solution3 = num - solution1 - solution2;
        if(solution3 <= MAX_X) // Only if the third solution is at the requested range, the equation has another solution
        {
            System.out.println(solution1 + " + " + solution2 + " + " + solution3);
            return 1 + solutions(num, solution1, ++solution2); // If we have a solutions, we add 1 to the number of soultion by backtracking and then return it
        }
        // If we din't have a solutions, we return the result of the next solutions by backtracking
        return solutions(num, solution1, ++solution2);
    }
    
    // Question no. 4:
    /**
     * The method finds a path in a two-dimensional array, that it's sum is equal to a given number and returns true (if there is one). Else, the method returns false
     * @param mat the two-dimensional array that will be checked for a path
     * @param sum the requested sum of the path
     * @param path a two-dimensional array that will hold the path (represented by 1). The rest of the array will hold 0
     * @return true if there's a path and false if there isn't
     */
    public static boolean findSum(int mat[][], int sum, int path[][])
    {
        int index1 = 0, index2 = 0; // Initiates the indexes in order to scan the 2D array
        return initIndex(mat, sum, path, index1, index2); // Calling the "main" method that returns true if there's a path and false if there isn't
    }
    
    private static boolean initIndex(int mat[][], int sum, int path[][], int index1, int index2)
    {
        if(findSum(mat, sum, path, index1, index2)) // Calling a method that will check if there's a requested path that starts at mat[index1][index2]
            return true;
        if(index2 == mat[index1].length - 1) // Check if the scanner is at the end of a line
        {
            if(index1 == mat.length - 1) // If were at the last place in the 2D array, there isn't any path that it's sum is equal to the variable sum
                return false;
            return initIndex(mat, sum, path, index1 + 1, 0); // If the scanner is at the end of the line, it will start checking the next line
        }
        return initIndex(mat, sum, path, index1, index2 + 1); // Else, the scanner will move to the next place in the array by incrementing index2
    }
    
    private static boolean findSum(int mat[][], int sum, int path[][], int index1, int index2)
    {
        final int MARK = 1;
        if(sum == mat[index1][index2]) // If the value is equal to sum, we have found a path
        {
            path[index1][index2] = MARK;
            return true;
        }
        if(sum < mat[index1][index2]) // If the value is greater than sum, the current path can't match the requested path
            return false;
        path[index1][index2] = MARK;
        // Checks all the paths that continue from the place [index1][index2]:
        if((index2 < mat[index1].length - 1 && path[index1][index2 + 1] != MARK && findSum(mat, sum - mat[index1][index2], path, index1, index2 + 1)) ||
        (index1 < mat.length - 1 && path[index1 + 1][index2] != MARK && findSum(mat, sum - mat[index1][index2], path, index1 + 1, index2)) ||
        (index2 > 0 && path[index1][index2 - 1] != MARK && findSum(mat, sum - mat[index1][index2], path, index1, index2 - 1)) ||
        (index1 > 0 && path[index1 - 1][index2] != MARK && findSum(mat, sum - mat[index1][index2], path, index1 - 1, index2)))
            return true;
        path[index1][index2] = 0; // Deletes the mark in the scanned path of the two-dimensional array
        return false; // If there isn't a path that passes at the place [index1][index2], the method returns false
    }
}