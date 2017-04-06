package Experience;
import java.util.*;
/**
 * Created by apple on 17/4/2.
 */
public class StrangePlanet {
    public static void main(String[] args) {
        //Math.round();
        System.out.printf("%.7f", 1.123456789);
        Scanner my = new Scanner(System.in);
        while (my.hasNext()) {
            int n = my.nextInt();
            int T = my.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = my.nextInt();
            }
            //double g = fingGravity(h, T);
            //System.out.printf("%.7f", g);
            System.out.println();
        }
    }
    /*
    private static int fingGravity(int[] h, int T) {

        int n = h.length;

        return mergesort(h, T, 0, n - 1);


    }
    */
    /*
    private static int mergesort(int[] h, int T, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        merge(h, 0, mid);
        merge(h, mid + 1, right);
    }
    private  static void merge(int[] h, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        merge(h, 0, )
    }
    */
}
