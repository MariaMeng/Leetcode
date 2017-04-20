import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 17/4/20.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        helper(list, new ArrayList<Integer>(), root, sum);
        return list;
    }
    private void helper(List<List<Integer>> list, List<Integer> temp, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null ) {
            if (root.val == sum) {
                temp.add(root.val);
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        helper(list, temp, root.left, sum - root.val);
        helper(list, temp, root.right, sum - root.val);
        temp.remove(temp.size() - 1);
    }
    public static void main(String[] args) {

    }
}

