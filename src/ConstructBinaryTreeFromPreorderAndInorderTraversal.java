/**
 * Created by apple on 17/3/18.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int preOrder[], int inOrder[]) {
        return helper(0, 0, inOrder.length - 1, preOrder, inOrder);
    }
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preStart >= preOrder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root.val){
                inIndex = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preOrder, inOrder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preOrder, inOrder);
        return root;
    }

}
