/**
 * Created by apple on 17/2/19.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    /*
        方法一：动态规划方法
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    /*
        方法二：分治思想
     */
    public int maxSubArray_B(int[] nums) {
        return devide(nums, 0, nums.length - 1);
    }
    public int devide(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int m = (left + right) / 2;
        int leftmax = devide(nums, left, m);
        int rightmax = devide(nums, m + 1, right);
        int leftsum = nums[m];
        int sum = nums[m];
        for (int i = m - 1; i >= left; i--) {
            sum += nums[i];
            leftsum = Math.max(sum, leftsum);
        }
        sum = nums[m + 1];
        int rightsum = nums[m + 1];
        for (int i = m + 2; i <= right; i++) {
            sum += nums[i];
            rightsum = Math.max(sum, rightsum);
        }
        return Math.max(leftsum + rightsum, Math.max(leftmax, rightmax));
    }
    public static void main(String[] args) {

    }
}
