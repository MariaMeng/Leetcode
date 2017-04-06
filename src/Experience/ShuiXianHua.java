package Experience;
import java.util.*;

/**
 * Created by apple on 17/3/29.
 */
public class ShuiXianHua {
    public static void main(String[] args) {
        Scanner my = new Scanner(System.in);
        int m = 0;
        int n = 0;
        while (my.hasNext()) {
            m = my.nextInt();
            n = my.nextInt();
            int k = 0;
            for (int i = m; i <= n; i++) {
                int num = i;
                int sum = 0;
                while (num / 10 != 0) {
                    sum += Math.pow(num % 10, 3);
                    num /= 10;
                }
                sum += Math.pow(num % 10, 3);
                if (sum == i) {
                    System.out.print(i + " ");
                    k++;
                }
            }
            if (k == 0) {
                System.out.print("no");
            }
        }
    }
}
