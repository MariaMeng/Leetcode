/**
 * Created by apple on 17/4/22.
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 解题思路：
 三个指针；
 root: 当前行的节点
 head : 下一行的开始节点
 cur:下一行的每个节点
 */
public class PopulatingNextRightPointersinEachNodeII {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode head = new TreeLinkNode(0);
            TreeLinkNode cur = head;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = head.next;
        }
    }
    public static void main(String[] args) {
        System.gc();
    }
}

