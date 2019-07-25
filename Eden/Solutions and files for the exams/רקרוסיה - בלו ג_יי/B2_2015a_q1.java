import java.util.Scanner;
public class B2_2015a_q1

{
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        int[] a = {2,5,10,20,50};
        System.out.println(makeSum(a,40,4));
    }

    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths, k, num, 0);
    }

    private static int makeSum(int[] lengths, int k, int num, int i) {
        if (num>=0 && k==0)
            return 1;
        if (((k<0 || k>0) && num == 0) || (i == lengths.length))
            return 0;
        return makeSum(lengths, k-lengths[i], num-1, i) + makeSum(lengths, k, num, i+1);
    }
}