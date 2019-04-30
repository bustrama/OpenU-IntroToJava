/**
 * A class that using a 2D array to simulate a Matrix and alter it's cells
 *
 * @author Ben Brandes
 * @version 13.04.19
 */
public class Matrix {
    final int MAX = 255;
    private int[][] _array;

    /**
     * Constructs a Matrix from a two-dimensional array, the dimensions as well as the
     * values of the this Matrix will be the same as the dimensions and the values of the
     * two-dimensional array.
     *
     * @param array the array to be set
     */
    public Matrix(int[][] array) {
        _array = new int[array.length][];
        copyArray(_array, array);
    }


    /**
     * Constructs a size1 by size2 Matrix of zeros.
     *
     * @param size1 represents the columns
     * @param size2 represents the rows
     */
    public Matrix(int size1, int size2) {
        _array = new int[size1][size2];
    }

    /**
     * Makes a new Matrix with the opposite values when the max value is 255
     *
     * @return
     */
    public Matrix makeNegative() {
        int[][] negArr = new int[_array.length][];
        copyArray(negArr, _array);

        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                negArr[i][j] = MAX - negArr[i][j];
            }
        }

        return new Matrix(negArr);
    }

    // Copy a given array to new one
    private void copyArray(int[][] blank, int[][] full) {
        for (int i = 0; i < full.length; i++) {
            blank[i] = new int[full[i].length];
            for (int j = 0; j < full[0].length; j++) {
                blank[i][j] = full[i][j];
            }
        }
    }

    /**
     * Return a Matrix that will change every cell to it's neighbors's average
     *
     * @return a Matrix that will change every cell to it's neighbors's average
     */
    public Matrix imageFilterAverage() {
        int[][] filterArr = new int[_array.length][];

        for (int i = 0; i < filterArr.length; i++) {
            filterArr[i] = new int[_array[i].length];
            for (int j = 0; j < filterArr[0].length; j++) {
                filterArr[i][j] = sumNeighbors(_array, i, j);
            }
        }

        return new Matrix(filterArr);
    }

    // Running with a loop on all the neighbors around (i,j) and summing up
    private int sumNeighbors(int[][] arr, int col, int row) {
        int sum = 0;
        int cells = 0;

        // Start at the left upper corner to the right lower corner
        // Depends on whether has only one row or only one column
        // And if it's one of the forth walls
        for (int i = ((col == 0) ? 0 : col - 1); i <= ((col == arr.length - 1) ? col : col + 1); i++) {
            for (int j = ((row == 0) ? 0 : row - 1); j <= ((row == arr[i].length - 1) ? row : row + 1); j++) {
                sum += arr[i][j];
                cells++;
            }
        }

        return sum / cells;
    }

    /**
     * Return the matrix after rotating it 90 degrees clockwise
     *
     * @return the matrix after rotating it 90 degrees clockwise
     */
    public Matrix rotateClockwise() {
        int[][] rotate = new int[maxCols(_array)][_array.length];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = _array[_array.length - j - 1][i];
            }
        }

        return new Matrix(rotate);
    }

    /**
     * Return the matrix after rotating it 90 degrees clockwise
     *
     * @return the matrix after rotating it 90 degrees clockwise
     */
    public Matrix rotateCounterClockwise() {
        int[][] rotate = new int[maxCols(_array)][_array.length];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = _array[j][rotate.length - i - 1];
            }
        }

        return new Matrix(rotate);
    }

    // Return the number that represent the array with the highest column number
    private int maxCols(int[][] arr) {
        int rows = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > rows)
                rows = arr[i].length;
        }

        return rows;
    }

    /**
     * Return the Matrix in table form
     *
     * @return the Matrix in table form
     */
    public String toString() {
        String mat = "";

        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                mat += _array[i][j];
                if (j < _array[i].length - 1) {
                    mat += "\t";
                }
            }
            mat += "\n";
        }
        return mat;
    }
}
