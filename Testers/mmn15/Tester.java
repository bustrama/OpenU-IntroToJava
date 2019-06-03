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
        System.out.println("Checking AddNumber functionality: ");
        if (checkAddNumber())
            System.out.println(GOOD);
        else
            System.out.println(BAD);

    }

    private static boolean checkAddNumber() {
        IntListTwo list = new IntListTwo();
        Random rnd = new Random();

        // Insert random numbers to the list
        for (int i = 0; i < 20; i++) {
            list.addNumber(rnd.nextInt(MAX + 1 - MIN) + MIN);
        }

        // Save the list to string and remove '{' and '}'
        String nodes = list.toString().replace("{", "").replace("}", "");
        // Replace all the ', ' with empty char
        String[] arr = nodes.split(", ");
        int[] listArr = new int[arr.length];
        // Insert all the values into the int[] array
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = Integer.parseInt(arr[i]);
        }


        for (int i = 0; i < listArr.length - 1; i++) {
            if (listArr[i] > listArr[i + 1]) {
                System.out.println("The list: \n" + list.toString());
                System.out.println(listArr[i] + " should be smaller than " + listArr[i + 1]);
                return false;
            }
        }

        return true;
    }
}
