/**
 * Created by apple on 17/2/2.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode first = l1, second = l2, start = dummy;
        int sum = 0;
        while(l1 != null || l2 != null) {
            sum /= 10;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            start.next = new ListNode(sum % 10);
            start = start.next;
        }
        if(sum / 10 == 1)
            start.next = new ListNode(1);
        return dummy.next;
    }
}