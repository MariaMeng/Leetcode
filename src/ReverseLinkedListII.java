/**
 * Created by apple on 17/2/6.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 注意：这道题是从m开始反转到n截止，而不是交换m位置和n位置
 */
public class ReverseLinkedListII {
    /*
        方法一：
                采用4个pointers,分别是dummy, prev, start, then
                dummy在开头，prev在反转头节点前面一个节点
                start为反转头节点，then为不断后移的节点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < m - 1; i++)
            prev = prev.next;
        ListNode start = prev.next, then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
