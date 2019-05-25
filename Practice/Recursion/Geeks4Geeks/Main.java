public class Main {
    public static void main(String[] args){
        System.out.println("***********************************************************");
        System.out.println("**************        Geeks for Geeks        **************");
        System.out.println("***********************************************************");
        System.out.println();

        System.out.println("    **** Practice Questions for Recursion | Set 1 ****");
        System.out.println();
        System.out.println("** Question 1: Explained");
        System.out.println("*************************************\n" +
                "int fun1(int x, int y) {\n" +
                "  if(x == 0) \n" +
                "    return y; \n" +
                "  else\n" +
                "    return fun1(x - 1,  x + y); \n" +
                "}\n" +
                "*************************************\n" +
                "fun1(5,2)\n");

        System.out.println("The result is: " + Recursion.fun1(5,2));

        System.out.println();System.out.println();
        int[] arr = new int[]{50,40,205,35,90,70};
        System.out.println("** Question 2: Explained");
        System.out.println("*************************************\n" +
                "void fun2(int arr[], int start_index, int end_index) {\n" +
                "   if (start_index >= end_index)\n" +
                "       return;\n" +
                "   int min_index = minIndex(arr, start_index, end_index);\n\n" +
                "   int temp = arr[start_index];\n" +
                "   arr[start_index] = arr[min_index];\n" +
                "   arr[min_index] = temp;\n" +
                "   fun2(arr, start_index + 1, end_index);\n}\n" +
                "*************************************\n" +
                "The Array: " + Recursion.printArray(arr) + "\nfun2(arr, 0, 5)\n");

        Recursion.fun2(arr, 0, arr.length-1);
    }
}
