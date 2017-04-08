package Experience.JingDong;

/**
 * Created by apple on 17/4/7.
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<int[]> nodes = new ArrayList<>();
        ArrayList<Integer> tail = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            if (!tail.contains(temp[0] + temp[1])) {
                tail.add(temp[0] + temp[1]);
            }
            nodes.add(temp);
        }
        Collections.sort(tail);
        int size = tail.size();
        int F[] = new int[size];
        for (int i = 0; i < F.length; i++) {
            int cur = tail.get(i);
            for (int j = 0; j < N; j++) {
                int[] temp = nodes.get(j);
                if (temp[0] <= cur && cur <= temp[0] + temp[1]) {
                    F[i]++;
                }
            }
        }
        int max = -1;
        int count = -1;
        for (int i = 0; i < F.length; i++) {
            for (int j = i + 1; j < F.length; j++) {
                int cur1 = tail.get(i);
                int cur2 = tail.get(j);
                count = F[i] + F[j];
                for (int k = 0; k < N; k++) {
                    int[] temp = nodes.get(k);
                    if (temp[0] <= cur1 && cur2 <= temp[0] + temp[1]) {
                        count--;
                    }
                }
                if (max < count) {
                    max = count;
                }
            }
        }
        System.out.println(max);
    }

}


