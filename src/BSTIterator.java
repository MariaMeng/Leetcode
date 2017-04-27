import java.util.Stack;

/**
 * Created by apple on 17/4/21.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack();

    public BSTIterator(TreeNode root) {
        findMin(root);
    }

    private void findMin(TreeNode root) {
        if (root == null) return ;
        stack.push(root);
        findMin(root.left);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        findMin(node.right);
        return node.val;
    }
    public static void main(String[] args) {

    }
}
