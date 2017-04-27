import java.util.Scanner;

/**
 * Created by apple on 17/4/25.
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 题目含义：
 找到第一个丢失的整数
 hashmap不行
 找到最小值

 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        // 如果当前的元素有正的，且在数组长度范围之内，则将A[i] = i + 1
        for (int i = 0;i < A.length; i++) {
            if (A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if(A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1; // 如果数组满足所有情况，则直接长度 + 1
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        System.out.println(firstMissingPositive(data));
    }
}
