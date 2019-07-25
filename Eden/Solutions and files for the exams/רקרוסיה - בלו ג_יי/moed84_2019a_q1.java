import java.util.Scanner;
public class moed84_2019a_q1
{

    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println(sumPower3(82));
                System.out.println((-167)%15);

    }

    public static boolean sumPower3(int num) {
        return sumPower3(num, 0, 0);
    }

    public static boolean sumPower3(int num, int power, int sum) {
        sum += Math.pow(3, power);
        if (sum > num)
            return false;
        if (sum == num)
            return true;
        if (!sumPower3(num, power+1, sum))
            sum -= Math.pow(3, power);
        return sumPower3(num, power+1, sum);
    }
}
