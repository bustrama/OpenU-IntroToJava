/**
 * This class represents a Matrix of intgers, representing a black and white picture.
 *
 * @author Ofek Marks
 * @version 20.4.2019
 */
public class Matrix
{
    private int[][] _matrix;
    
    final int WHITE = 0, BLACK = 255;
    
    /**
     * Constructs a Matrix from a two-dimensional array; the dimensions as well as the values of this Matrix will be the same as the dimensions and values of the two-dimensional array.
     * @param array the two-dimensional array that will be copied into the Matrix
     */
    public Matrix(int[][] array)
    {
        _matrix = new int[array.length][array[0].length]; // The dimensions of the Matrix are the same as the two-dimensional array
        for(int index1 = 0; index1 < array.length; index1++) // The nested for loops scan the two-dimensional array
        {
            for(int index2 = 0; index2 < array[index1].length; index2++)
                _matrix[index1][index2] = array[index1][index2]; // The values of the Matrix are the same as the two-dimensional array
        }
    }
    
    /**
     * Constructs a size1 by size2 Matrix of zeroes.
     * @param size1 the length of the Matrix
     * @param size2 the width of the Matrix
     */
    public Matrix(int size1, int size2)
    {
        _matrix = new int[size1][size2]; // Each cell in a two-dimensional array is initiated with a value of 0 by default
    }
    
    /**
     * Returns a string representation of this Matrix object
     * @return A string that describes the Matrix object
     */
    public String toString()
    {
        String str = "";
        for(int index1 = 0; index1 < _matrix.length; index1++) // The nested for loops scan the Matrix
        {
            for(int index2 = 0; index2 < _matrix[index1].length - 1; index2++)
                str += _matrix[index1][index2] + "\t"; // The value of the cell is added to the string, followed by a tab
            str += _matrix[index1][_matrix[index1].length - 1] + "\n"; // At the end of the line, the value of the cell is added to the string, followed by a new line
        }
        return str;
    }
    
    /**
     * Returns a negative image of a given Matrix 
     * @return A Matrix filled with the negative values (negative value = 255 - value) of the given Matrix
     */
    public Matrix makeNegative()
    {
        Matrix matrix = new Matrix(_matrix); // Creates a copy of the given Matrix
        for(int index1 = 0; index1 < _matrix.length; index1++) // The nested for loops scan the Matrix
        {
            for(int index2 = 0; index2 < _matrix[index1].length; index2++)
                matrix._matrix[index1][index2] = BLACK - _matrix[index1][index2]; // Creates a negative image of the value in the specific cell, in the new Matrix
        }
        return matrix;
    }
    
    /**
     * Filters the image of a given Matrix
     * @return A Matrix filled with the average of all its neigbors, including itself
     */
    public Matrix imageFilterAverage()
    {
        Matrix matrix = new Matrix(_matrix.length, _matrix[0].length); // Creates a copy of the given Matrix filled with 0 values
        for(int index1 = 0; index1 < matrix._matrix.length; index1++) // The nested for loops scan the Matrix
        {
            for(int index2 = 0; index2 < matrix._matrix[index1].length; index2++)
            {
                int average = cellAverage(index1, index2, matrix); // The number of a cell's neighbors
                matrix._matrix[index1][index2] /= average; // Calculates the integer average of the new cell
            }
        }
        return matrix;
    }
    
    private int cellAverage(int index1, int index2, Matrix matrix)
    {
        int numOfNeighborCells = 0;
        for(int index3 = index1 - 1; index3 < index1 + 2; index3++) //  The nested for loops scan the neighbors of the cell including itself
        {
            {
                for(int index4 = index2 - 1; index4 < index2 + 2 && /* Checks if the row of the cell exsists: */ index3 >= 0 && index3 < matrix._matrix.length; index4++)
                {
                    if(index4 >= 0 && index4 < matrix._matrix[index1].length)//  Checks if the column of the cell exsists
                    {
                        matrix._matrix[index1][index2] += _matrix[index3][index4]; // Adds the value of the neigbor call to the cell in the new Matrix
                        numOfNeighborCells++; // Increments the number of neighbor cells. The number of neighbor cells also includes the cell itself
                    }
                }
            }
        }
        return numOfNeighborCells;
    }
    
    /**
     * Rotates a Matrix 90 degrees clockwise
     * @return The rotated Matrix 
     */
    public Matrix rotateClockwise()
    {
        Matrix matrix = new Matrix(_matrix[0].length, _matrix.length); // Creates a copy of the given Matrix (with switched dimensions) filled with 0 values
        for(int index1 = 0; index1 < matrix._matrix.length; index1++) // The nested for loops scan the Matrix
        {
            for(int index2 = 0; index2 < matrix._matrix[index1].length; index2++)
                // The current cell should have the value of the cell with the row as the column, and the opposite column as the row
                matrix._matrix[index1][index2] = _matrix[matrix._matrix[0].length - 1 - index2][index1];
        }
        return matrix;
    }
    
    /**
     * Rotates a Matrix 90 degrees counter clockwise
     * @return The rotated Matrix 
     */
    public Matrix rotateCounterClockwise()
    {
        return rotateClockwise().rotateClockwise().rotateClockwise(); // Rotating the matrix 90 degrees clockwise 3 times is equal to rotating the matrix 90 degrees counter clockwise
    }
}