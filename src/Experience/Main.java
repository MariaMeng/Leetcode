package Experience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by apple on 17/3/4.
 */
public class Main {


    static boolean resolve(int[] A) {
        if (A.length <= 3) return false;

        int left = 0, right = A.length - 1;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> array = new ArrayList<>();
        int suml = A[left], sumr = A[right];
        while (left < right) {
            while(suml < sumr) {
                suml += A[++left];
            }

            while (suml > sumr) {
                sumr += A[--right];
            }
            if (suml == sumr) {
                set.add(suml);
                array.add(++left);
                array.add(--right);
                left++;
                right--;
                suml = A[left];
                sumr = A[right];
            }

        }
        if (set.size() == 1) return true;
        else return false;
    }
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
        int[] another = {1};
        int[] test = {10, 2, 3, 4, 12, 3, 1};
        int[] a = {10, 10, 10, 10};
        boolean result = resolve(a);
        System.out.println(result);
    }
}
