import java.util.Scanner;

/**
 * Created by apple on 17/4/25.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 *
 */
public class JumpGame {

    /*
        TLE,这个方法超时了
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        return helper(nums, 0, n - 1);
    }
    private static boolean helper(int[] nums, int start, int end) {
        if (start >= end) return true;
        if (nums[start] == 0) return false;
        for (int i = nums[start]; i > 0; i++) {
            if (helper(nums, start + nums[start], end)) {
                return true;
            }
        }
        return false;
    }

    /*
        快速方法
     */
    public static boolean canJump_B(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(A[i] + i, max);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        System.out.println(canJump(data));
    }
}
