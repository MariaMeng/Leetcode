/**
 * Created by apple on 17/3/12.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return majority(nums, 0, nums.length - 1);
    }
    private int majority(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        int leftM = majority(nums, left, mid);
        int rightM = majority(nums, mid + 1, right);
        if (leftM == rightM)
            return leftM;
        else {
            int leftCount = 0;
            int rightCount = 0;
            for (int i = left; i <= right; i++) {
                if (nums[i] == leftM)
                    leftCount++;
                else
                    rightCount++;
            }
            return leftCount > rightCount ? leftM : rightM;
        }
    }
    public static void main(String[] args) {
        MajorityElement my = new MajorityElement();
        int[] nums = {7, 3, 7, 8, 7, 7, 7, 5};
        int result = my.majorityElement(nums);
        System.out.println(result);
    }
}
