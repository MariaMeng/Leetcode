/**
 * Created by apple on 17/3/18.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    private TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inOrder, int[] postOrder) {
        if (postStart < 0 || inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inOrder, postOrder);
        root.right = helper(postStart + inIndex - inStart, postEnd - 1, inIndex + 1, inEnd, inOrder, postOrder);
        return root;
    }
}
