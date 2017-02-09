import java.util.List;

/**
 * Created by apple on 17/2/2.
 */
public class MergeTwoSortedLists {
    /*
        方法一： 采用Two pointers
        19ms
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        ListNode first = l1, second = l2; //two pointers
        while(first != null && second != null) {
            if(first.val <= second.val) {
                start.next = first;
                first = first.next;
            }else {
                start.next = second;
                second = second.next;
            }
            start = start.next;
        }
        start.next = first != null ? first : second;
        return dummy.next;
    }
    /*
        方法二：递归法
     */
    public ListNode mergeTwoLists_B(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists_B(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists_B(l1, l2.next);
            return l2;
        }
    }

}
