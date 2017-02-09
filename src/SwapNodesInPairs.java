/**
 * Created by apple on 17/2/3.
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    /*
        方法一： My Own Solution
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;

        while(head != null && head.next != null) {
            ListNode next = head.next.next;
            start.next = head.next;
            head.next.next = head;
            head.next = next;
            head = head.next;
            start = start.next.next;
        }
        return dummy.next;
    }

    /*
       方法二： 采用Recursive 方法
     */
    public ListNode swapPairs_B(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs_B(head.next.next);
        n.next = head;
        return n;
    }
}
