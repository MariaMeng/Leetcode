package Experience.QQ;
import java.util.*;
/**
 * Created by apple on 17/4/4.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            min = Math.min(a, b);
            min = Math.min(min, c);
            max = Math.max(a, b);
            max = Math.max(max, c);

            if (min == max) {
                System.out.println(min);
                continue;
            }
            if (k == 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(helper(max, min, 1 << k, 0));
        }
    }
    private static int helper(int max, int min, int n, int offset) {
        int mid = n / 2 + offset;
        if (mid < min) {
            return helper(max, min, n / 2, offset + n / 2);
        } else if (mid > max) {
            return helper(max, min, n / 2, offset);
        } else
            return mid;
    }

}
