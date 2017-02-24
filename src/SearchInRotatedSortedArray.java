/**
 * Created by apple on 17/2/22.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(nums, 0, nums.length - 1, target);
    }
    private int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;

        //left is ordered
        if (nums[mid] >= nums[left]) {
            if (target >= nums[left] && target < nums[mid])
                return search(nums, left, mid - 1, target);
            else
                return search(nums, mid + 1, right, target);

        } else {
            // right is ordered
            if (target <= nums[right] && target > nums[mid])
                return search(nums, mid + 1, right, target);
            else
                return search(nums, left, mid - 1, target);
        }

    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray mySolution = new SearchInRotatedSortedArray();
        int[] nums = {5, 1, 3};
        int target = 3;
        int result = mySolution.search(nums, target);
        System.out.println(result);
    }
}
