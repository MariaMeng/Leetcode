/**
 * Created by apple on 17/1/31.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?


 */
public class LinkedListCycleII {
    /*
        方法一： My Own Solution : 在LinkedListCycle中方法一基础之上，进行修改
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                ListNode p = head;
                ListNode q = slow;
                while(p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}
