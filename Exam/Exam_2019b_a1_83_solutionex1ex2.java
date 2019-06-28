public class Exam_2019b_a1_83 {

    public static void main(String[] args) {

        //ex1Mat and ex2Mat are the matrices used in the test for demonstration
        int[][] ex1Mat = new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1}};
        int[][] ex2Mat = new int[][]{{-99, -72, -64, -55, -28, -10, -5}, {-72, -53, -46, -38, 11, 13, 22}, {-63, -48, -27, -12, 14, 16, 23}, {-44, -29, -10, 0, 18, 20, 28}, {0, 12, 14, 20, 28, 30, 35}};

        //test the given examples to check that the code works
        System.out.println("Ex.1 answer: " + longestPath(ex1Mat, 2, 5));
        System.out.println("Ex.2 answer: " + howManyNegativeNumbers(ex2Mat));
    }

    // ------------- EX 1 -------------
    public static int longestPath(int mat[][], int x, int y) {

        //check if x,y out of bound
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[x].length) {
            return 0;
        }

        //recursive call, with 0,0,0
        return longestPath(mat, x, y, 0, 0, 0);
    }

    //overloading recursive function, has i,j to track current position and a counter var
    public static int longestPath(int[][] mat, int x, int y, int i, int j, int counter) {

        // --------- STOPPING CONDITIONS ---------

        //check if indexes are out of bound
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length) {
            return 0;
        }

        //check if cell already visited
        if (mat[i][j] == 0)
            return 0;

        //mark that we've visited the cell, and increase the counter for a visited cell
        mat[i][j] = 0;
        counter++;

        //check if we've made it to our destination, if we did, return the counter.
        if (i == x && j == y) {

            //make sure to unvisit the cell for future iterations
            mat[i][j] = 1;
            return counter;
        }
        // --------- END OF STOPPING CONDITIONS ---------

        // --------- MAIN RECURSION LOOP ---------

        //we're here because we didn't met a stopping condition. so we're somewhere in the middle of the iteration.
        //so try to go in all directions, and return the longest route
        int a = longestPath(mat, x, y, i + 1, j, counter); //go down
        int b = longestPath(mat, x, y, i, j + 1, counter); //go right
        int c = longestPath(mat, x, y, i - 1, j, counter); //go up
        int d = longestPath(mat, x, y, i, j - 1, counter); //go left

        //unvisit the cell, as it will be needed for other iterations
        mat[i][j] = 1;

        //return the max of all routes
        return Math.max(Math.max(a, b), Math.max(c, d));
        // --------- END OF MAIN RECURSION LOOP ---------
    }


    // ------------- EX 2 -------------
    // [X} represents a negative number, and [_] represents a non-negative number.
    // this is the example matrix given in the test, it looks like this:

    //[X][X][X][X][X}[X}[X]
    //[X][X][X][X][_][_][_]
    //[X][X][X][X][_][_][_]
    //[X][X][X][_][_][_][_]
    //[_][_][_][_][_][_][_]

    //notice that if we go from the bottom to the top,
    //the negative depth only gets shorter when we go from left to right.
    //so we need to go from the left most column to the right most column,
    //and go up in the column (from the bottom) until we reach a negative number.
    //we know for sure everything above it will be negative, so we add that "negative depth" to a counter variable.
    //then we go one column to the right. the negative depth can't be higher,
    //so we only need to go up again until we reach a negative number.
    //then we add the negative depth number to the counter var, and do this for the remaining columns.
    //(if we reach negative depth of zero, return counter as there won't be any more negative numbers)
    //time complexity is O(n+m), where n is the number of rows and m is the number of columns,
    //as we loop from 1 to n ONCE and from 1 to m ONCE
    //(notice the looping aren't related to each other, nested, so it's not n*m)
    //space complexity is O(1) because we don't use any additional space.
    //notice that you can also implement this logic going from right to left, top to bottom.
    //sorry for the wall of text, not sure how to describe it more simply.

    public static int howManyNegativeNumbers(int[][] mat) {

        //check edge case
        if (mat == null)
            return 0;

        //variables
        int counter = 0;

        //i is the row, we want to start at the bottom of each column
        int i = mat.length - 1;

        //loop through the columns, left to right, starting from column 0
        for (int j = 0; j < mat[0].length; j++) {

            //go up in the column until we meet a negative number
            while (mat[i][j] >= 0) {
                i--;

                //if i<0, everything else is positive. return the counter
                if (i < 0)
                    return counter;
            }

            //all cells above are negative, count them
            counter += (i + 1);

        }
        return counter;
    }


}
