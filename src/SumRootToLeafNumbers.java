/**
 * Created by apple on 17/2/15.
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

 注意事项：
       1
      / \
     3   4
    / \ / \
   2  3 3  1
 sum = 132 + 133 + 143 + 141
 解题思路：
 1. 采用preOrder Traversal
 2. 递归遍历，将当前10 * x + root.val 传给下一次迭代。
 */
public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumR(root, 0);
    }
    private int sumR(TreeNode root, int x) {
        if (root.left == null && root.right == null) {
            return 10 * x + root.val;
        }
        int val = 0;
        if (root.left != null)
            val += sumR(root.left, 10 * x + root.val);
        if (root.right != null)
            val += sumR(root.right, 10 * x + root.val);
        return val;
    }
}
