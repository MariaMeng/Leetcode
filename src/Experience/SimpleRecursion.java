package Experience;
import java.util.*;
/**
 * Created by apple on 17/4/2.
 */
public class SimpleRecursion {
    public static void main(String[] args) {
        //System.out.println(Long.MAX_VALUE);
        Scanner my = new Scanner(System.in);
        long n = my.nextLong();
        long result = findResult(n);
        result %= 1000000007;
        System.out.println(result);
    }
    public static long findResult(long n) {
        int[] result = {1, 1};
        if (n == 1) return result[1];
        if (n == 0) return result[0];
        long currentOne = 1;
        long currentTwo = 1;
        long r = 0;
        for (long i = 2; i <= n; i++) {
            r = 2 * currentOne + 3 * currentTwo;
            currentTwo = currentOne;
            currentOne = r;
        }
        return r;
    }
}
