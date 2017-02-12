import java.util.*;
/**
 * Created by apple on 17/2/11.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 注意事项：
 1. boolean[] 数组 默认值为：false
 2. 一定要排序，排序之后可以避免重复的情况
 3. 在排序的情况下，如果当前元素与上一个元素相等，如果前一个元素没有被使用，则当前元素不用使用。
    反之，如果上一个元素被使用，则当前元素也使用。
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); //sorting is necessary
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int nums[], boolean[] used) {
        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII mySolution = new PermutationsII();
        int[] nums = {1, 1, 1, 3};
        List l = mySolution.permuteUnique(nums);
        System.out.println(l);
    }
}
