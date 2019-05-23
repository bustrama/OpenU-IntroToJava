import java.util.Scanner;

/**
 * This class demonstrates three sorting algorithms of an array.
 *
 * @author (Tamar Vilner)
 */

public class Sort {
    // _data = the array
    private int[] _data;
    // MAX = the length of the array
    final int MAX = 6;

    /**
     * Constructor for objects of class Sorting
     */
    public Sort() {
        _data = new int[MAX];
    }

    /**
     * enterNumbers is a method that fills the array with data from
     * the user
     */
    public void enterNumbers() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < _data.length; i++) {
            System.out.print("enter an integer ");
            _data[i] = scan.nextInt();
        }
    }

    /**
     * printArray prints the array content
     */
    public void printArray() {
        System.out.print("The array is: ");
        for (int i = 0; i < _data.length; i++)
            System.out.print("\t" + _data[i]);
        System.out.println();
    }


//-----------------------------------------------------------------//
// Selection Sort
//-----------------------------------------------------------------//

    /**
     * selectionSort sorts the array using the selelction-sort
     * algorithm
     *
     * @param lo the lowest index of the array
     * @param hi the highest index of the array
     */
    public void selectionSort(int lo, int hi) {
        // data[0]…data[lo-1] contain the largest values in data,
        //  in descending order
        if (lo < hi)    //subarray has more than one element
        {
            swap(lo, findMaximum(lo, hi));
            selectionSort(lo + 1, hi);
        }
    }

    private int findMaximum(int lo, int hi) {
        // finds the maximum in the array betwen the indexes
        // lo and hi
        if (lo == hi) return lo;
        else {
            int locationOfMax = findMaximum(lo + 1, hi);
            if (_data[lo] > _data[locationOfMax]) return lo;
            else return locationOfMax;
        }
    }

    private void swap(int first, int second) {
        //swaps between the contents of the array cells in
        //indexes first and second
        int temp;
        temp = _data[first];
        _data[first] = _data[second];
        _data[second] = temp;
    }


//----------------------------------------------------------------//
// Insertion Sort
//----------------------------------------------------------------//

    /**
     * insertionSort sorts the array using the insertion-sort
     * algorithm
     *
     * @param hi the highest index of the array
     */
    public void insertionSort(int hi) {
        //  Sort data[0]…data[hi]
        if (hi > 0) {
            insertionSort(hi - 1);
            insertInOrder(hi, _data[hi]);
        }
    }

    private void insertInOrder(int hi, int x) {
        // Insert x into data[0]…data[hi-1], filling
        // in data[hi] in the process.
        // data[0]…data[hi-1] are sorted.
        if ((hi == 0) || (_data[hi - 1] >= x))
            _data[hi] = x;
        else {
            _data[hi] = _data[hi - 1];
            insertInOrder(hi - 1, x);
        }
    }
