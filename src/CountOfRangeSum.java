/**
 * Created by apple on 17/3/12.
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

 Note:
 A naive algorithm of O(n2) is trivial. You MUST do better than that.

 Example:
 Given nums = [-2, 5, -1], lower = -2, upper = 2,
 Return 3.
 The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question.
 解题思路：
 1). sum数组统计 0~i个数之和
 2). 划分成不能划分的独立的元素
 3). 看S(j) - S(i)是否满足，a <= S(j) - S(i) <= b
 4). cache[] 数组中维护满足条件

 该方法使用了Merge Sort来解，在混合的过程中，我们已经给**左半边[start, mid) 和右半边 [mid, end)** 排序了。
 当我们遍历左半边，对于每个i，我们需要在右半边找出k和j，使其满足：
 * j是第一个满足 sums[j] - sums[i] > upper 的下标
 * k是第一个满足 sums[k] - sums[i] >= lower 的下标
 那么在[lower, upper]之间的区间的个数是j - k，同时我们也需要另一个下标t，
 用来拷贝**所有满足sums[t] < sums[i]到一个寄存器Cache中以完成混合排序的过程。
 **(注意这里sums可能会整型溢出，我们使用长整型long long代替)。
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        CountOfRangeSum my = new CountOfRangeSum();
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        int result = my.countRangeSum(nums, lower, upper);
        System.out.println(result);
    }
}
