import java.util.Scanner;
public class moed84_2019a_q2
{

    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        int[] arr = {5,7,-2,10};
        System.out.println(average(arr));
    }

    public static int average(int[] arr) {
        double leftSum = 0;
        double rightSum = 0;
        for (int j = 0; j<arr.length; j++)
            rightSum += arr[j];

        double minDif = 0;
        int finalInd = 0;

        for (int i = 0; i<arr.length-1; i++) {
            leftSum += arr[i];
            double leftAv = leftSum / (i+1);
            rightSum -= arr[i];
            double rightAv = rightSum / (arr.length - i - 1);
            double dif = Math.abs (leftAv - rightAv); 
            if (dif > minDif) {
                minDif = dif;
                finalInd = i;
            }
        }
        return finalInd;
    }
}