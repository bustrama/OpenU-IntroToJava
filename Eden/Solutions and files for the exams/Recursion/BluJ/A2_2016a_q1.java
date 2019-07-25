public class A2_2016a_q1
{

    /** Question #1 2016a a2 83 OpenU **/ // - Nadav Taragan (tarago)
    public static int minPoints (int[][] m) {
        if (minPoints(m, 0,0, 0, 0) <0)
            return Math.abs(minPoints(m, 0,0, 0, 0)) + 1;
        else
            return minPoints(m, 0,0, 0, 0);

    }

    private static int minPoints (int [] [] m, int i, int j, int sum, int min) {
        sum+= m[i][j];
        if (sum < min)
            min = sum;
        if (i == m.length -1 && j == m[0].length-1) {
            if (min > 0)
                return 1;
            else 
                return min; 
        }

        if (i< m.length -1 && j < m[0].length-1)
            return minPoints(m, i+1, j, sum,min) > minPoints(m, i, j+1, sum, min) ? minPoints(m, i+1, j, sum,min) : minPoints(m, i, j+1, sum, min); 
        if ( i< m.length -1)
            return minPoints(m, i+1, j, sum,min);
        else 
            return minPoints(m, i, j+1, sum, min);
    }

    /** תשובות של המגה **/    
    public static int minPoint (int [][] m) {
        if (m.length == 0) {
            return 0;
        }
        int min = minPoint (m,0,0,m[0][0],0);
        return (((-1)*min)+1);
    }

    private static int minPoint (int [][] m, int i,int j, int min, int sum) {
        sum += m[i][j];
        if (sum < min) {
            min = sum;
        }
        if (i==(m.length-1) && j==(m[0].length-1)) {
            return min;
        }
        if ((i+1)<=(m.length-1) && (j+1) <= (m[0].length-1)) {
            int way1 = minPoint (m,i+1,j,min,sum);
            int way2 = minPoint (m,i,j+1,min,sum);
            if (way1 > way2) {
                return way1;
            }
            else {
                return way2;
            }
        }
        if ((i+1)<=(m.length-1)) {
            return (minPoint (m,i+1,j,min,sum));
        }
        else {
            return (minPoint(m,i,j+1,min,sum));
        }
    }

    public static boolean findX (int [] a, int x)
    {
        if (a.length <= 1) {
            return false;
        }
        int low =0;
        int high =a.length-1;
        while (low<high) {
            int mid = (high-low)/2 +low;
            if (a[mid]+a[mid+1] == x) {
                return true;
            }
            else if (a[mid]+a[mid+1]<x) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return false;
    }

    public static void main (String [] args)
    {
        int[][] m = new int[][]{
                { -2, -3, 3},
                { -5,-10,1},
                { 10, 30,-5 },
            };
        System.out.println ("first Ex= " + minPoint (m));
        int [] a = {1,2,5,3,6,10,9};
        System.out.println ("Second Ex= " +findX (a,3));
        int [] b = {1,2,5,3,6,10,9};
        System.out.println ("Second Ex= " +findX (b,7));

    }
}