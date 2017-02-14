import java.util.*;
/**
 * Created by apple on 17/2/12.
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 注意事项：
 1. 此题与377题CombinationSumIV 区别在于：
    377题：解集可以满足同一集合，不同排序的情况，
    39题：同一个集合，只能出现一次。
 解题思路：
 1. 先数组排序
 2. 元素左侧的小于右侧的，start自增
 3. remains = target ;
    remains = remains - nums[i];
    如果remains < nums[i]则表示可以终止档次遍历。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    /*
        方法一： My Own Solution
                在标准答案的基础上进行优化。
     */
    private int backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain == 0) {
            list.add(new ArrayList<>(tempList));
            return 1;
        }
        else{
            for(int i = start; i < nums.length; i++){
                if (remain < nums[i]) break;
                tempList.add(nums[i]);
                if (backtrack(list, tempList, nums, remain - nums[i], i) != 0) {
                    tempList.remove(tempList.size() - 1);
                    break;
                }
                tempList.remove(tempList.size() - 1);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        CombinationSum mySolution = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = mySolution.combinationSum(nums, target);
        System.out.println(list);
    }
}
