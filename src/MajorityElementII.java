import java.util.*;
/**
 * Created by apple on 17/3/12.
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 * 解题思路：
 * 这道题只可以有2个或者2个以下数字满足条件
 * 假设 7 / 3 = 2;
 * more than 7 / 3 最小为 2 + 1 = 3；（一个数字至少出现3次）
 * 倘若有3个数字，则至少应该有 3 * 3 = 9 个数字，与题目中7 不符合
 * 倘若有2个数字，则至少英爱有 2 * 3 = 6 个数字，满足题目要求
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) { // traverse array
            if (nums[i] == num1)
                count1++;
            else if (nums[i] == num2)
                count2++;
            else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1)
                count1++;
            else if (nums[i] == num2)
                count2++;
        }
        if (count1 > n / 3)
            list.add(num1);
        if (count2 > n / 3)
            list.add(num2);
        return list;
    }
    public static void main(String[] args) {
        MajorityElementII my = new MajorityElementII();
        int[] nums = {3, 8, 8, 2, 1, 3, 8, 3};
        List list = my.majorityElement(nums);
        System.out.println(list);
    }
}
