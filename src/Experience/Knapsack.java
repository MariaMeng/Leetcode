package Experience;
import java.util.*;
/**
 * Created by apple on 17/3/30.
 */
public class Knapsack {
    public static void main(String[] args) {
        Scanner my = new Scanner(System.in);
        int N = my.nextInt();
        int M = my.nextInt();
        int[] need = new int[N];
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            need[i] = my.nextInt();
            value[i] = my.nextInt();
        }
        System.out.println(helper(need, value, M));
    }
    private static int helper(int[] need, int[] value, int M) {
        int n = need.length;
        int[] f = new int[M + 1];
        for(int i = 0; i < f.length; i++){
            f[i] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = need[i]; j < f.length; j++){
                f[j] = Math.max(f[j], f[j - need[i]] + value[i]);
            }
        }
        return f[M];
    }
}
