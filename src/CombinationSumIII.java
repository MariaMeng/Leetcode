import java.util.*;
/**
 * Created by apple on 17/2/14.
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers
 * Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    /*
        方法一： My Own Solution 与标准答案相比，更快。
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, n, 1);
        return list;
    }
    private int backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
        if (k == 0) {
            list.add(new ArrayList<>(tempList));
            return 1;
        }
        else {
            for (int i = start; i <= 9; i++) {
                if (remain < i) break;
                if (k == 1 && remain >= i &&remain <=9) {
                    i = remain;
                } else if (k == 1 && remain > 9)
                    break;
                tempList.add(i);
                if (backtrack(list, tempList, k - 1, remain - i, i + 1) != 0 ) {
                    tempList.remove(tempList.size() - 1);
                    break;
                }
                tempList.remove(tempList.size() - 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CombinationSumIII mySolution = new CombinationSumIII();
        int k = 3, n = 15;
        List<List<Integer>> list = mySolution.combinationSum3(k, n);
        System.out.println(list);
    }
}
