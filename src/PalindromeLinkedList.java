/**
 * Created by apple on 17/2/1.
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow =slow.next;
        }
        if(fast != null) // odd length
            slow = slow.next;
        slow = reverse(slow);
        fast = head;
        while(slow != null) {
            if(slow.val != fast.val)
                return false;
            else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return true;
    }
}
