/**
 * Created by apple on 17/1/31.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {
    /*
        方法一： 采用 两个dummy List,一个保存小于x的序列，另一个保存大于等于x的序列
                然后拼接
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode first = dummy1, second = dummy2;
        while(head != null) {
            if(head.val < x) {
                first.next = head;
                first = first.next;
            }else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        second.next = null;
        first.next = dummy2.next;
        return dummy1.next;
    }

}
