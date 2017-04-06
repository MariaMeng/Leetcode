import java.util.*;
/**
 * Created by apple on 17/4/4.
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 解题思路：
 采用分治的方法，将原问题划分成子问题，再归并成原问题。
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (n == 0) return list;
        return generate(1, n);
    }
    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new LinkedList<TreeNode>();

        if (left > right) {
            res.add(null);
            return res;
        } else if (left == right) {
            res.add(new TreeNode(left));
            return res;
        }

        List<TreeNode> l, r;
        // for each root from left to right
        for (int i = left; i <= right; i++) {

            l = generate(left, i - 1);
            r = generate(i + 1, right);

            for (TreeNode ll : l) {
                for (TreeNode rr : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = ll;
                    root.right = rr;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int x) {
        val = x;
    }
}