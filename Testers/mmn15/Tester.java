/**
 * @author Ben Brandes
 * @version 04/06/2019
 */

import java.util.Random;

public class Tester {
    final static String GOOD = "\t\t\t\t\t\t\t\t\t OK!";
    final static String BAD = "\t *** Oops, something's smelly with your node ***";
    final static int MAX = 500;
    final static int MIN = -500;

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("***                                   ***");
        System.out.println("***           MMN 15 Tester           ***");
        System.out.println("***                                   ***");
        System.out.println("*****************************************");

        /*         toString         */
        printCheck("toString");
        if(checkToString()){
            System.out.println(GOOD);

            /*         AddNumber         */
            printCheck("addNumber");
            checkFunc(checkAddNumber());

            /*         RemoveNumber         */
            printCheck("removeNumber");
            checkFunc(checkRemoveNumber());
        }else {
            printErr("Please fix toString before proceeding");
        }

        /*         length         */
        printCheck("length");
        checkFunc(checkLength());

        /*         sum         */
        printCheck("sum");
        checkFunc(checkSum());

        /*         maxLength         */
        printCheck("maxLength");
        checkFunc(checkMaxLength());

        /*         isAverage         */
        printCheck("isAverage");
        checkFunc(checkIsAverage());
    }

    //helper checkFunc function to reduce code
    private static void checkFunc(boolean funcResult) {
        System.out.println(funcResult ? GOOD : BAD);
    }

    private static void printCheck(String check) {
        System.out.println("Checking <" + check + "> functionality:");
    }

    private static boolean checkToString(){
        IntListTwo list = new IntListTwo();
        list.addNumber(1);
        list.addNumber(2);
        list.addNumber(3);
        String correctList = "{1, 2, 3}";

        return correctList.equals(list.toString());
    }

    private static IntListTwo generateList(int size) {
        IntListTwo list = new IntListTwo();
        Random rnd = new Random();

        // Insert random numbers to the list
        for (int i = 0; i < size; i++) {
            list.addNumber(rnd.nextInt(MAX + 1 - MIN) + MIN);
        }

        return list;
    }

    private static int[] listToArray(IntListTwo list) {
        // Save the list to string and remove '{' and '}'
        String nodes = list.toString().replace("{", "").replace("}", "");
        // Replace all the ', ' with empty char
        String[] arr = nodes.split(", ");
        int[] listArr = new int[arr.length];
        // Insert all the values into the int[] array
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = Integer.parseInt(arr[i]);
        }

        return listArr;
    }

    private static boolean checkAddNumber() {
        IntListTwo list = generateList(50);

        int[] arrFromList = listToArray(list);

        for (int i = 0; i < arrFromList.length - 1; i++) {
            if (arrFromList[i] > arrFromList[i + 1]) {
                System.out.println("The list: \n" + list.toString());
                System.out.println(arrFromList[i] + " should be smaller than " + arrFromList[i + 1]);
                return false;
            }
        }

        return true;
    }

    private static int[] removeIndex(int[] arr, int num) {
        int[] newArr = new int[arr.length - 1];

        boolean found = false;
        int i = 0;
        while (i < newArr.length) {
            if (arr[i] == num)
                found = true;

            if (found)
                newArr[i] = arr[i + 1];
            else
                newArr[i] = arr[i];

            i++;
        }

        return newArr;
    }

    private static boolean compareListArr(IntListTwo list, int[] arr) {
        int[] arrFromList = listToArray(list);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arrFromList[i])
                return false;
        }
        return true;
    }

    private static boolean checkRemoveNumber() {
        /*        Part 1        */
        /* Remove head and tail */
        IntListTwo list = generateList(20);
        int[] arrFromList = listToArray(list);

        list.removeNumber(arrFromList[0]);
        arrFromList = removeIndex(arrFromList, arrFromList[0]);
        if (!compareListArr(list, arrFromList))
            return false;

        list.removeNumber(arrFromList[arrFromList.length - 1]);
        arrFromList = removeIndex(arrFromList, arrFromList[arrFromList.length - 1]);
        if (!compareListArr(list, arrFromList))
            return false;

        /*       Part 2       */
        /* Remove with 1 node */
        IntListTwo list2 = generateList(1);
        int[] arrFromList2 = listToArray(list2);

        list2.removeNumber(arrFromList2[0]);
        if (!list2.toString().equals("{}"))
            return false;

        return true;
    }

    private static boolean checkLength() {
        IntListTwo list1 = generateList(1);
        if (list1.length() != 1)
            return false;

        IntListTwo list2 = generateList(5);
        if (list2.length() != 5)
            return false;

        IntListTwo list3 = generateList(100);
        if (list3.length() != 100)
            return false;

        return true;
    }

    private static int sumArr(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static boolean checkSum() {
        IntListTwo list = generateList(20);
        int[] arr = listToArray(list);

        if (list.sum() != sumArr(arr))
            return false;

        IntListTwo list1 = generateList(1);
        int[] arr1 = listToArray(list1);

        if (list1.sum() != sumArr(arr1))
            return false;

        return true;
    }

    // As a gesture for mmn14
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

    private static boolean checkMaxLength() {
        IntListTwo list = generateList(1000);
        int[] arr = listToArray(list);

        if (list.maxLength() != what(arr))
            return false;

        return true;
    }


    /**
     * @Author Matan האנונימי
     *
     */
    // Counts on properly working IntListTwo!
    private static boolean checkIsAverage() {
        double tempAvg;

        // Test for empty list
        IntListTwo list = generateList(0);

        if (!list.isAverage(0)) {
            printErr("Empty list isn't working");
            return false;
        }

        list.addNumber(30);
        list.addNumber(11);
        list.addNumber(11);

        // Test for casting problems
        if (list.isAverage((30 + 11 + 11) / 3)) {
            printErr("You might have casting issues");
            return false;
        }

        tempAvg = (30.0 + 11 + 11) / 3;

        // Casting works correctly
        if (!list.isAverage(tempAvg)) {
            printErr("make sure you average correctly");
            return false;
        }

        // Add more numbers to check sub arrays
        list.addNumber(700);
        list.addNumber(900);

        // List should look like {11, 11, 30, 700, 900} (if people got this far it is probably correct)
        // Total sum so far is 1652, and 5 items

        // Check left sub-array[0..2]
        if (!list.isAverage(tempAvg)) {
            printSubArrayErr(list, tempAvg, "left", "{11,11,30}");
            return false;
        }

        tempAvg = (11.0 + 30 + 700) / 3;

        // Check middle sub-array[1..3]
        if (!list.isAverage(tempAvg)) {
            printSubArrayErr(list, tempAvg, "middle", "{11, 30, 700}");
            return false;
        }

        tempAvg = (30.0 + 700 + 900) / 3;

        // Check right sub-array[2..4]
        if (!list.isAverage(tempAvg)) {
            printSubArrayErr(list, tempAvg, "right", "{30, 700, 900}");
            return false;
        }

        //TODO: maybe there are more edge cases to add
        return true;
    }

    //save some code
    private static void printSubArrayErr(IntListTwo list, double avg, String side, String subArray) {
        String err = "your list is: " + list
                + "\n tested avg is " + avg
                + "\n you should have a " + side + " subarray with " + subArray + " with the correct avg, but got 'false'";
        printErr(err.replaceAll("\n", "\n\t *** "));
    }

    //too long to type
    private static void printErr(String err) {
        System.err.println("\t *** " + err);
    }
}
