/**
 * Created by apple on 17/2/27.
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int bitCount = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                bitCount++;
            n = n >> 1;
        }
        return bitCount == 1;
    }
    public boolean isPowerOfTwo_B(int n) {
        return n > 0 && (n & (n - 1)) == 0 ;
    }
    public static void main(String[] args) {
        int a = 9 & 1;
        int b = 7 & 3;
        int c = 15 & 13;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        PowerOfTwo mySolution = new PowerOfTwo();
        int n = Integer.MAX_VALUE;
        boolean result = mySolution.isPowerOfTwo(n);
        System.out.println(result);
    }
}
