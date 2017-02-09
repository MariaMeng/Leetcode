import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 17/2/7.
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 注意：backtrack回溯题目进行分析时，要画状态图，包括每个状态的i的变化
 此题特点：长度相等，即在每次递归时，先判断长度是否符合要求
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList)); // 创建新的ArrayList，防止引用变量修改
            //list.add(tempList); // 这样写，则返回的为[[], [], [], [], [], []],因为tempList被remove之后就为空了。
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations mySolution = new Permutations();
        int[] array = {1, 2, 3};
        List list = mySolution.permute(array);
        System.out.println(list);
    }
}
