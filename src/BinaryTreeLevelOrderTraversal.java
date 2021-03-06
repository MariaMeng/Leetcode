import java.util.*;
/**
 * Created by apple on 17/2/14.
 *
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
  /   \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
注意事项：
 1. 在while循环中，每次获取queue.size()这一步，一定要先保存到一个变量中，不然的话，队列是动态变化的
 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /*
        方法一： 采用Queue队列方法
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelNum = queue.size(); // 这里是关键
            List<Integer> subLiist = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subLiist.add(queue.poll().val);
            }
            list.add(subLiist);
        }
        return list;
    }
    public static void main(String [] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] aray = {};
        //String[] str = new String[3]{"1","2", "3"};
        //String[] array4 = new String[3]{"1","2","3"};
        System.out.println(Math.ceil(3.3));
        //Long j = (Long) (new Integer(4));
        Long i = new Long(3);
        if (true) ;
    }

}

