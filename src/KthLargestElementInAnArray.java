import java.util.PriorityQueue;

/**
 * Created by apple on 17/3/10.
 * 注意事项：
 * PriorityQueue默认排好序，之后是值小的，先出队列
 */
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5, 5};
        int k = 2;
        int result = findKthLargest(nums, k);
        System.out.println(result);
    }
}
