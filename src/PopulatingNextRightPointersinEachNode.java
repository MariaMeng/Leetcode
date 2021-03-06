import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by apple on 17/4/22.
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL

 解题思路：
 使用两个pointer,一个指着行
 一个指着列
 这题给的树为满二叉树
 */
public class PopulatingNextRightPointersinEachNode {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return ;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }

}
