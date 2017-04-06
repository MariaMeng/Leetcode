import java.util.*;
/**
 * Created by apple on 17/2/22.
 * Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {
    /*
        方法一： My Own Solution
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid > 0 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] >= nums[left] && nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[left] && nums[mid] <= nums[right])
                right = mid - 1;
            else
                right--;
        }
        return nums[left];
    }
    /*
        方法二：
     */
    public int FindMin_B(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[left])
                right = mid;
            else
                right--;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
    }

}
