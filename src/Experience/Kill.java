package Experience;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 17/4/7.
 */
public class Kill {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = in.nextInt();
            R[i] = L[i] + in.nextInt();
        }
        System.out.println(findMax(L, R));

    }
    private static int findMax(int[] X, int[] L) {
        int[] copy = new int[X.length];
        for (int i = 0; i < X.length; i++) {
            copy[i] = X[i];
        }
        Arrays.sort(copy);
        int min = copy[0];
        int[] copyR = new int[L.length];
        for (int j = 0; j < L.length; j++) {
            copyR[j] = L[j];
        }
        Arrays.sort(copyR);
        int max = copyR[copyR.length - 1];

        int[] range = new int[max - min + 1];
        for (int i = 0; i < X.length; i++) {
            range[X[i] - min]++;
            range[L[i] - min]++;
        }
        Arrays.sort(range);
        return range[range.length - 1] + range[range.length - 2];
    }
}
