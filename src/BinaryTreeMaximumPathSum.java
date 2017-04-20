import java.util.Scanner;

/**
 * Created by apple on 17/4/20.
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.


 */
public class BinaryTreeMaximumPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    TreeNode root;
    int max ;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        DFS(root);
        return max;
    }
    private int DFS(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, DFS(root.left)); // left path
        int right = Math.max(0, DFS(root.right)); // right path
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum my = new BinaryTreeMaximumPathSum();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] data = new String[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.next();
        }


    }
}
