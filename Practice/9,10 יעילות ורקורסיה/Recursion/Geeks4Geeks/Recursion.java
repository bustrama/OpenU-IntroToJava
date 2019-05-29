public class Recursion {
    public static int fun1(int x, int y) {
        if (x == 0) {
            System.out.println("Returning y: " + y);
            return y;
        } else {
            System.out.println("Calling: fun1(" + (x - 1) + ", " + (x + y) + ")");
            return fun1(x - 1, x + y);
        }
    }

    public static void fun2(int arr[], int start_index, int end_index) {
        if (start_index >= end_index) {
            System.out.println("The array: " + printArray(arr) + "\n");
            return;
        }
        int min_index = minIndex(arr, start_index, end_index);

        int temp = arr[start_index];
        arr[start_index] = arr[min_index];
        arr[min_index] = temp;

        System.out.println("The array: " + printArray(arr) + "\n");
        System.out.println("Calling: fun2(arr, " + (start_index + 1) + ", " + end_index + ")");
        fun2(arr, start_index + 1, end_index);
    }

    private static int minIndex(int[] arr, int start_index, int end_index) {
        int lowest = start_index;
        for (int i = start_index; i <= end_index; i++) {
            if (arr[i] < arr[lowest])
                lowest = i;
        }
        System.out.println("The lowest is: arr[" + lowest + "], " + arr[lowest]);
        return lowest;
    }

    public static String printArray(int[] arr) {
        String array = "";
        array += "{ ";
        for (int i = 0; i < arr.length; i++) {
            array += arr[i];
            if (i < arr.length - 1)
                array += ", ";
        }
        array += " }";
        return array;
    }
}
