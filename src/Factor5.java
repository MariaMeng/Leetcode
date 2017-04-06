import java.util.*;
/**
 * Created by apple on 17/3/29.
 */
public class Factor5 {

    public static void main(String[] args) {

        Scanner my = new Scanner(System.in);
        while (my.hasNext()) {
            long x = my.nextLong();
            long result = x * 5;
            if (factorial(result) == -1) System.out.print(-1);
            else System.out.print(result);
        }
    }
    private static long factorial(long result) {
        long sum = 1;
        for (int i = 1; i <= result; i++) {
            long temp = sum;
            sum *= i;
            if (sum  < temp) return -1;
        }
        return 1;
    }
}
