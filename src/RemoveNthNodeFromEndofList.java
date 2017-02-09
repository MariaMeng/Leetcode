/**
 * Created by apple on 17/1/30.
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid. //这句话意思是删除的位置不会超过长度，也就是说 空List这种情况不存在
 Try to do this in one pass.


 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class RemoveNthNodeFromEndofList {

    /*
        方法一： 采用dummy node 方法，即添加一个start 节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||head.next==null) return head;// 这个可以不用考虑
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        fast.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i = 1; i <= n + 1; i++)
            fast = fast.next;

        
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
    /*
        方法二： 采用Baozipu方法。分情况：
            如果 fast 经过n步 为null, 去掉头节点
            如果 fast 经过n步 非null, slow fast都++
     */
    public ListNode removeNthFromEnd_B(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode slow = head, fast = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null)
            return head.next;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList mySolution = new RemoveNthNodeFromEndofList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode test = node;
        while(test != null) {
            System.out.print(test.val + "->");
            test = test.next;
        }
        System.out.println();

        ListNode result = mySolution.removeNthFromEnd(node, 2);

        ListNode temp = result;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
