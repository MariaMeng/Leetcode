import java.util.*;

/**
 * Created by apple on 17/2/8.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * int n : 范围
 * int k : 个数
 * [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 * 此题特点：长度固定,并且左侧元素小于右侧元素。
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i <= n; i++) {
                if (tempList.contains(i)) continue;
                tempList.add(i);
                backtrack(list, tempList, n ,k, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        Combinations mySolution = new Combinations();
        int n = 4, k = 2;
        List list = mySolution.combine(n, k);
        System.out.println(list);
    }
}
