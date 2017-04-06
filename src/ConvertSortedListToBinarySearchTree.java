import java.util.*;
/**
 * Created by apple on 17/3/21.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 采用Divide and conquer方法逐步构建二插搜索树
 */
public class ConvertSortedListToBinarySearchTree {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // 1. find the previous node of mid node, the next node is mid node
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. construct the root node
        TreeNode root = new TreeNode(slow.next.val);
        // 3. construct the right subtree
        root.right = sortedListToBST(slow.next.next);
        // 4. construct the left subtree
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int  r = random.nextInt(3);
    }
}
