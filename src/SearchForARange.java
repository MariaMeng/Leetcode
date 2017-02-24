/**
 * Created by apple on 17/2/24.
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 注意事项：
 1. 采用两次二分搜索法，分别搜索左区间， 和右区间。
 2. 左区间要看它与前一个相比是否相等， 右区间要看它与后一个相比是否相等
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) return res;
        int left = searchLeft(nums, 0, nums.length - 1, target);
        if (left == -1)
            return res;
        int right = searchRight(nums, 0, nums.length - 1, target);
        res[0] = left;
        res[1] = right;
        return res;
    }
    private int searchLeft(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] > target)
            return searchLeft(nums, left, mid - 1, target);
        else if (nums[mid] < target)
            return searchLeft(nums, mid + 1, right, target);
        else { // target == nums[mid]
            if (mid == 0 || nums[mid - 1] != target)
                return mid;
            else
                return searchLeft(nums, left, mid - 1, target);
        }
    }
    private int searchRight(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] > target)
            return searchRight(nums, left, mid - 1, target);
        else if (nums[mid] < target)
            return searchRight(nums, mid + 1, right, target);
        else { // target == nums[mid]
            if (mid == nums.length - 1 || nums[mid + 1] != target)
                return mid;
            else
                return searchRight(nums, mid + 1, right, target);
        }
    }
    public static void main(String[] args) {
        SearchForARange mySolution = new SearchForARange();
        int[] nums = {3, 3, 3, 3, 3, 3};
        int target = 3;
        int[] result = mySolution.searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
