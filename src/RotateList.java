/**
 * Created by apple on 17/1/31.
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    /*
        方法一： 采用 dummy node方法
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head; //空List绕多少圈也为本身；只有一个元素绕多少圈也为本身。因此这两种情况直接返回。
        ListNode dummy = new ListNode(0); // dummy node
        ListNode slow = dummy, fast = dummy;
        fast.next = head;
        int i, j;
        for(i = 0; fast.next!= null; i++) { // get the length of the list i
            fast = fast.next;
        }

        for(j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }
        fast.next = dummy.next; // 尾（原LIST）
        dummy.next = slow.next; // 首（原LIST）
        slow.next = null; //中 (原LIST)
        return dummy.next;
    }
}
