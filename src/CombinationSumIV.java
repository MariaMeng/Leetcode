import java.util.*;

/**
 * Created by apple on 17/2/14.
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 注意事项：
 1. 此题与39题CombinationSum 区别在于
    377题：解集可以满足同一集合，不同排序的情况，
    39题：同一个集合，只能出现一次。
 解题思路：
 1. 动态规划思想 Target = nums[i] +  preTarget
                comb[Target] = sum(comb[Target - nums[i]])
 2. 分别计算Target = 1 ~ target 中每个可能的值的comb
 3. 当前的target的comb值来自之前每个preTarget的comb的和。
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {

        CombinationSumIV mySolution = new CombinationSumIV();
        int[] nums = {3, 2, 4};
        int target = 4;
        int reuslt = mySolution.combinationSum4(nums, target);
        System.out.println(reuslt);


    }
}
