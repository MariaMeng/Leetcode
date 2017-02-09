/**
 * Created by apple on 17/2/4.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    /*
        方法一： My Own Solution 效率低！速度慢！
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;

        while (head != null && head.next != null) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            start.next = head;
            head = head.next;
            start = start.next;
        }
        return dummy.next;
    }
    /*
        方法二：Recursive method 速度快！
     */
    public ListNode deleteDuplicates_B(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates_B(head.next);
        return head.val == head.next.val ? head.next : head;
    }
    /*
        方法三： 非递归方法，迭代法
     */
    public ListNode deleteDuplicates_C(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head;

        while (dummy.next != null){
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else dummy = dummy.next;
        }
        return head;
    }
}

