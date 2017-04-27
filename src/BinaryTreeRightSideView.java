import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by apple on 17/4/24.
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 解题思路：
 DFS: 根 右子树 左子树
 初始情况树的深度设置为0
 如果树深度 = 当前的 list 的大小，就加入当前的元素
 */
public class BinaryTreeRightSideView {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    /*
        方法一： 层次遍历： 慢
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    /*
        方法二： DFS遍历：快
     */
    public List<Integer> rightSideView_B(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }

}
