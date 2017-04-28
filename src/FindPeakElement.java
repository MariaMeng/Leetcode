/**
 * Created by apple on 17/4/28.
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 如果单调的增，则返回 n
 如果单调递减，则返回 0
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int n = nums.length;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return - 1;
    }
    public static int findPeakElement_B(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length - 1);
    }
    private static int helper(int[] nums, int left, int right) {
        if (left == right) return left;
        else if (left + 1 == right) {
            if (nums[left] > nums[right]) return left;
            else return right;
        }
        int m = (left + right) / 2;
        if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) return m;
        else if (nums[m - 1] < nums[m] && nums[m] < nums[m + 1]) return helper(nums, m + 1, right);
        else if (nums[m - 1] > nums[m] && nums[m] > nums[m - 1]) return helper(nums, left, m - 1);
        else
            return helper(nums, left, m - 1);
    }

}
