import java.util.*;

/**
 * Created by apple on 17/2/3.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */
public class MergeKSortedLists {
    /*
        方法一： 采用Priority Queue方法，这种方法没看明白
     */
    public ListNode mergeKLists(ListNode[] mylists) {
        //change array to list
        List<ListNode> lists = Arrays.asList(mylists);

        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    /*
        方法二：采用recursive方法进行递归归并
               采用分而治之的思想,先考虑哪两个队列先归并，然后与其他的继续归并。

                1     2     3     4     5     6     7     8             1    2    3    4    5    6
                |_____|     |_____|     |_____|     |_____|             |____|         |____|
                   |___________|           |___________|                   |______|       |______|
                         |_______________________|                             |______________|
     */
    public ListNode mergeKLists_B(ListNode[] lists) {
        return partion(lists,0,lists.length - 1);
    }
    public ListNode partion(ListNode[] lists, int s, int e){
        if(s == e) return lists[s];
        if(s < e){
            int q = (s + e) / 2; //将档次数组 分 两个自组
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists,q+1, e);
            return mergeTwoLists_B(l1, l2);
        }else
            return null;
    }

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

    public static void main(String[] args) {
        String s = "   1E2";
        char a = ' ';
        int c = a;
        System.out.println(s);
        System.out.println(s.trim());
    }

}
