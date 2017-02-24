/**
 * Created by apple on 17/2/23.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    /*
        方法一： 采用递归方法Binary Search
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return search(nums, 0, nums.length - 1, target);
    }
    private int search(int[] nums, int left, int right, int target) {
        if (left > right) return left;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (target < nums[mid])
            return search(nums, left, mid - 1, target);
        else
            return search(nums, mid + 1, right, target);
    }
    /*
        方法二： 迭代法
     */
    public int searchInsert_B(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
    public static void main(String[] args) {
        SearchInsertPosition mySolution = new SearchInsertPosition();
        int[] nums = {1, 2, 3};
        int target = 5;
        int result = mySolution.searchInsert_B(nums, target);
        System.out.println(result);
    }
}
