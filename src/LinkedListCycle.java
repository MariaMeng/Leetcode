/**
 * Created by apple on 17/1/31.
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */

public class LinkedListCycle {

    /*
        方法一： My Own Solution
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
    /*
        方法二： Top Solution: O(1) Space Solution
     */
    public boolean hasCycl_B(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

}
