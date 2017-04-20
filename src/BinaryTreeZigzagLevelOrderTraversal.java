import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by apple on 17/4/20.
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 这题与level order区别在于反转顺序，可以使用add(0, xxx)，
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;

        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                } if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (order) {
                    temp.add(queue.poll().val);
                } else {
                    temp.add(0, queue.poll().val);
                }
            }
            res.add(temp);
            order = !order;
        }
        return res;
    }
}
