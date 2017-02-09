import java.util.*;

/**
 * Created by apple on 17/2/7.
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 注意：backtrack回溯题目进行分析时，要画状态图，包括每个状态的i的变化
 此题特点：长度不变化，去重，元素左侧的小于右侧的，在递归中start变量自增。
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    // start 表示下一次递归数组中开始的位置
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        Subsets mySolution = new Subsets();
        int[] nums = {1, 2, 3};
        List list = mySolution.subsets(nums);
        System.out.println(list);
    }
}
