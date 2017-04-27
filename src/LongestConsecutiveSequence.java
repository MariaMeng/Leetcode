import java.util.HashMap;

/**
 * Created by apple on 17/4/25.
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 解题思路：
 Hashmap保存所有的元素
 两边边界保存最新的最长序列的数值
 注意事项：
 不要忘了把当前的元素插入到map中
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            else {
                // 1. 边界值
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = left + right + 1;

                // 2. 当前的值， 重要！！！
                map.put(n, sum);

                max = Math.max(max, sum);

                // 3. 更新边界值
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return max;
    }
}
