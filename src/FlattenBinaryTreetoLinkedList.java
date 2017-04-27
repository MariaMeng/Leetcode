/**
 * Created by apple on 17/4/21.
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

      1
     / \
    2   5
   / \   \
  3   4   6
 The flattened tree should look like:
 1
  \
   2
    \
     3
      \
      4
       \
        5
         \
          6

 If you notice carefully in the flattened tree,
 each node's right child points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return ;
        helper(root);

    }
    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode right = root.right;
        TreeNode left = root.left;

        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            TreeNode node = helper(left);
            if (right != null) {
                node.right = right;
                return helper(right);
            } else return node;
        }
        if (right != null)
            return helper(right);
        else return root;

    }

    /*
        方法二：从右子树，左子树，根的顺序判断赞
     */
    TreeNode prev = null;
    public void flatten_B(TreeNode root) {
        if (root == null)
            return;
        flatten_B(root.right);
        flatten_B(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
