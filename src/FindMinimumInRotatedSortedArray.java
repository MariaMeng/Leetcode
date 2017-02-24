/**
 * Created by apple on 17/2/22.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 注意：
 这道题没有重复情况。
 */
public class FindMinimumInRotatedSortedArray {
    /*
        方法一： 采用递归方法
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return search(nums, 0, nums.length - 1);
    }
    private int search(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) / 2;
        if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
        if (nums[mid] >= nums[left] && nums[mid] > nums[right])
            return search(nums, mid + 1, right);
        else
            return search(nums, left, mid - 1);
    }
    /*
        方法二： 采用迭代法
     */
    public int findMin_B(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            // if find the pivot (current > previous)
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            // left is ordered and right is unordered
            if (nums[mid] >= nums[left] && nums[mid] > nums[right])
                left = mid + 1;
            // if left is unordered or left and right are both ordered
            else
                right = mid - 1;
        }
        return nums[left];
    }

}
