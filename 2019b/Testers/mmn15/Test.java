/**
 * @author Etamar Cohen
 *
 */

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[][] mat = generateArrays();

        /*
         * Test for isAverage
         */
        for (int i = 0; i < mat.length; i++) {
            sort(mat[i], 0, mat[i].length - 1);
            for (int k = 0; k < mat[i].length; k++) {
                for (int l = k; l < mat[i].length; l++) {
                    IntListTwo a = new IntListTwo();
                    double res = 0;
                    for (int m = k; m <= l; m++) {
                        res += mat[i][m];
                        a.addNumber(mat[i][m]);
                    }
                    res = (double) res / (l - k + 1);
                    if (a.isAverage(res) == false) {
                        System.out.println("not good");
                    }
                }
            }
        }

        /*
         * Test for maxLength
         */
        for (int i = 0; i < mat.length; i++) {
            IntListTwo a = new IntListTwo();
            for (int j = 0; j < mat[i].length; j++) {
                a.addNumber(mat[i][j]);
            }
            if (a.maxLength() != what(mat[i]))
                System.out.println("not good");
        }
    }


    private static int f(int[] a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    private static int what(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int c = f(a, i, j);
                if (c % 2 == 0) {
                    if (j - i + 1 > temp)
                        temp = j - i + 1;
                }
            }
        }
        return temp;
    }

    private static int[][] generateArrays() {
        int[][] mat = new int[1000][];
        Random rnd = new Random();

        for (int i = 0; i < mat.length; i++) {
            mat[i] = new int[rnd.nextInt(30) + 1];
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (int) ((Math.random() * 200) - 100);
            }
        }

        return mat;
    }

    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    static /* The main function that implements QuickSort()
    arr[] --> Array to be sorted, 
    low  --> Starting index, 
    high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
          /* pi is partitioning index, arr[pi] is  
            now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
