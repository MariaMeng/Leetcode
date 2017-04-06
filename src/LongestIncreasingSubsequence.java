import java.util.LinkedList;

import java.util.*;
/**
 * Created by apple on 17/4/4.
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 解题思路：
 详见编程之美原题
 */
public class LongestIncreasingSubsequence {
    public static int getlength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    public static int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tail[mid] < x) {
                    i = mid + 1;
                } else
                    j = mid;
            }
            tail[i] = x;
            if (i == size)
                size++;
        }
        return size;
    }
    public static void main(String[] arg) {
        int[] arr = {-1, 1, 0, 3, 5, 2, 7};
        System.out.println(lengthOfLIS(arr));
        System.out.println(getlength(arr));
    }

}
