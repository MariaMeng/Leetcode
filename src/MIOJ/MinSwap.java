package MIOJ;

import java.util.Scanner;

/**
 * Created by apple on 2018/12/30.
 */
public class MinSwap {

    static int count = 0;

    private static String solution(String line) {
        // please write your code here
        if (line == null || line.length() == 0) return null;

        count = 0;
        String[] str = line.split(",");
        if (str.length == 0)return null;
        int len = str.length;

        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = Integer.parseInt(str[i]);
        }

        mergeSort(data, 0, len - 1);
        return String.valueOf(count);
        // return ans;
    }

    public static void mergeSort(int[] str, int left, int right) {
        if (left >= right)
            return ;

        int mid = left + (right - left) / 2;

        mergeSort(str, left, mid);
        mergeSort(str, mid + 1, right);

        int[] cache = new int[right - left + 1];
        mergeArray(str, left, mid, right, cache);
    }

    public static void mergeArray(int[] str, int left, int mid, int right, int[] cache) {
        int i = left, j = mid + 1;
        int k = 0;
        int len = right - left + 1;

        while (i <= mid && j <= right) {
            if (str[i] > str[j]) {
                cache[k++] = str[j++];
                count += mid - i + 1;
            }
            else
                cache[k++] = str[i++];

        }

        while (i <= mid)
            cache[k++] = str[i++];

        while (j <= right)
            cache[k++] = str[j++];

        for (int m = 0; m < len; m++)
            str[left + m] = cache[m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(solution(in.nextLine()));
        }
    }

}
