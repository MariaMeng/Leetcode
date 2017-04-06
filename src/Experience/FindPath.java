package Experience;
import java.util.*;
/**
 * Created by apple on 17/3/20.
 * 剑指Offer 面试题 25
 */
public class FindPath {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> findPath(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        backtrack(list, new ArrayList<>(), root, target);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, TreeNode root, int target) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                tempList.add(root.val);
                list.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size() - 1);
            }
        }
        else {
            tempList.add(root.val);
            backtrack(list, tempList, root.left, target - root.val);
            backtrack(list, tempList, root.right, target - root.val);
            tempList.remove(tempList.size() -1);
        }
    }
}
