import java.util.*;
/**
 * Created by apple on 17/2/12.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    private int backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remains, int start) {
        if (remains == 0) {
            list.add(new ArrayList<>(tempList));
            return 1;
        }else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                else if (remains < nums[i]) break;
                tempList.add(nums[i]);
                if (backtrack(list, tempList, nums, remains - nums[i], i + 1) != 0) {
                    tempList.remove(tempList.size() - 1);
                    break;
                }
                tempList.remove(tempList.size() - 1);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        CombinationSumII mySolution = new CombinationSumII();
        int[] nums = {1, 1, 1, 2, 5, 6, 7, 10};
        int target = 8;
        List<List<Integer>> list = mySolution.combinationSum2(nums, target);
        System.out.println(list);
    }
}
