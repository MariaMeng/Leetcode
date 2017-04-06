package Experience;

/**
 * Created by apple on 17/3/19.
 */
public class MirrowTree {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode findMirrowTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null)
            return root;
        // swap the left subtree with right subtree
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null)
            root.left = findMirrowTree(root.left);
        if (root.right != null)
            root.right = findMirrowTree(root.right);
        return root;
    }
   public static void main(String[] args) {
        int[][] matrix = new int[0][0];
   }
}
