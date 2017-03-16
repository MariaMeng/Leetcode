/**
 * Created by apple on 17/3/4.
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 If n is the length of array, assume the following constraints are satisfied:

 1 ≤ n ≤ 1000
 1 ≤ m ≤ min(50, n)
 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.
 解题思路：
 采用二分法来完成。
 最小值：如果m == nums.length,那么个人数组元素都为一个子数组，找到数组中的最大值，作为最小值情况
 最大值，若m == 1,则子数组为本身。最大值为所有数组元素之和。
 其余情况在两者范围之内，采用二分法完成。
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0) return 0;
        int max = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if (m == 1) return (int)sum;
        long left = max, right = sum;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (valid (mid, nums, m))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (int)left;
    }
    private boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long  sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                sum = nums[i];
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        SplitArrayLargestSum mySolution = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        int[] another = {1, 2, 3, 4, 5};
        int m = 3;
        int result = mySolution.splitArray(another, m);
        System.out.println(result);

    }
}
