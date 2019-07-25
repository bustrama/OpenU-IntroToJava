import java.util.Scanner;
public class B1_2018a_q1
{

    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        int[] a = {2,8,3,4,7,1,3,2};
        System.out.println(cheapestRoute(a));
    }

    public static int cheapestRoute(int[] s) {
        return cheapestRoute(s, 0);
    }

    private static int cheapestRoute(int[] s, int i) {
        if (i == s.length -1)
            return s[s.length -1];
        if (i == s.length -2)
            return s[s.length -1] +  s[s.length -2];
        return s[i] + Math.min(cheapestRoute(s, i+1), cheapestRoute(s, i+2));
    }
}