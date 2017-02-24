import java.util.*;
/**
 * Created by apple on 17/2/22.
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 注意事项：数组中可能含有重复元素。
 */
public class SearchInRotatedSortedArrayII {
    /*
        方法一： 先排序，然后在进行Binary Search方法，但是时间复杂度从 O(logn) 上升到O(n)
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        return search(nums, 0, nums.length - 1, target);
    }
    private boolean search(int[] nums, int left, int right, int target) {
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return true;
        if (target >= nums[left] && target < nums[mid])
            return search(nums, left, mid - 1, target);
        else
            return search(nums, mid + 1, right, target);
    }
    /*
        方法二： 采用Binary Search 方法,乱序方法
     */
    public boolean search_B(int[] nums, int target) {
        if (nums.length == 0) return false;
        return search_B(nums, 0, nums.length - 1, target);
    }
    private boolean search_B(int[] nums, int left, int right, int target) {
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (target == nums[mid]) return true;

        // left is ordered or right is unordered
        if (nums[mid] > nums[left] || nums[mid]  > nums[right]) {
            if (target >= nums[left] && target < nums[mid])
                return search(nums, left, mid - 1, target);
            else
                return search(nums, mid + 1, right, target);
        } else if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
            // right is ordered or left is unordered
            if (target > nums[mid] && target <= nums[right])
                return search(nums, mid + 1, right, target);
            else
                return search(nums, left, mid - 1, target);
        } else {
            // nums[mid] = nums[left] = nums[right]
            return search(nums, left, right - 1, target);
        }

    }
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII mySolution = new SearchInRotatedSortedArrayII();
        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        int target = 5;
        boolean result = mySolution.search_B(nums, target);
        System.out.println(result);
    }
}

