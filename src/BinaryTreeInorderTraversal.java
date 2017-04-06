import java.util.*;
/**
 * Created by apple on 17/3/17.
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Integer> stack = new Stack<>();
        helper(list, stack, root);
        return list;
    }
    private void helper(List<Integer> list, Stack<Integer> stack, TreeNode root) {
        if (root == null) return ;
        stack.push(root.val);
        helper(list, stack, root.left);
        list.add(stack.pop()); // pop the root
        helper(list, stack, root.right);

    }
    public List<Integer> inorderTraversal_B(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
}
