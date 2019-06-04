import java.util.Random;

public class Tester {
    final static String GOOD = "\t\t\t OK!";
    final static String BAD = "\t\t\t *** Oops, something's smelly with your node ***";
    final static int MAX = 500;
    final static int MIN = -500;

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("***                                   ***");
        System.out.println("***           MMN 15 Tester           ***");
        System.out.println("***                                   ***");
        System.out.println("*****************************************");

        /*         AddNumber         */
        System.out.println("Checking addNumber functionality: ");
        if (checkAddNumber())
            System.out.println(GOOD);
        else
            System.out.println(BAD);

        /*         RemoveNumber         */
        System.out.println("Checking removeNumber functionality: ");
        if (checkRemoveNumber())
            System.out.println(GOOD);
        else
            System.out.println(BAD);

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
}
