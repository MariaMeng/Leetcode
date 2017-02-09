/**
 * Created by apple on 17/2/5.
 */
public class RemoveDuplicatesFromSortedListII {
    /*
        方法一： 迭代法： 与RemoveDuplicatesFromSortedList题目中的方法三 是一种解法。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        start.next = head;

        while (start.next != null) {
            while(head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (start.next == head)
                start = start.next;
            else
                start.next = head.next;
            head = head.next;
        }
        return dummy.next;
    }
    /*
        方法二：Recursive方法
     */
    public ListNode deleteDuplicates_B(ListNode head) {
        if (head == null) return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates_B(head.next);
        }
        else
            head.next = deleteDuplicates_B(head.next);
        return head;
    }
}
