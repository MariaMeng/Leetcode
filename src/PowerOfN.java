/**
 * Created by apple on 17/2/27.
 * Implement pow(x, n).
 */
public class PowerOfN {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        if (n < 0) x = 1 / x;

        return helper(x, n);
    }
    private double helper(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;

        double t = helper(x, n / 2);
        if (n % 2 == 0) return t * t;
        else return t * t * x;
    }
    public static void main(String[] args) {
        String str = "你";
        System.out.println(str.length());
        char[] a = str.toCharArray();
        System.out.println(a[0]);
        char b = '你';
        System.out.print(b);
        PowerOfN mySolution = new PowerOfN();
        double x = 50;
        int n = 2;
        double result = mySolution.myPow(x, n);
        System.out.println(result);
        Object obj = new Object();

    }

}
