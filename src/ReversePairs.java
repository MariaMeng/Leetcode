/**
 * Created by apple on 17/3/14.
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

 You need to return the number of important reverse pairs in the given array.

 Example1:

 Input: [1,3,2,3,1]
 Output: 2
 Example2:

 Input: [2,4,3,5,1]
 Output: 3
 Note:
 The length of the given array will not exceed 50,000.
 All the numbers in the input array are in the range of 32-bit integer.

 注意事项：
 这道题与
 315 Count Of Smaller Numbers After Self
 327 Count Of Range Sum
 两道题相似
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > 2L * nums[p]) p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }

    /*
        anther 区别范围为[start, end)状态
     */
    public int reversePairs_B(int[] nums) {
        int n = nums.length;
        return mergesort(nums, 0, n);
    }
    private int mergesort(int[] nums, int left, int right) {
        if (right - left <= 1) return 0;

        int mid = (right + left) / 2;
        int res = mergesort(nums, left, mid) + mergesort(nums, mid, right);

        int[] cache = new int[right - left];

        int  j = mid, k = mid, r = 0;
        for (int i = left; i < mid; i++) {
            while (k < right && nums[i] > 2L * nums[k]) k++;
            while (j < right && nums[i] > nums[j]) cache[r++] = nums[j++];
            res += k - mid;
            cache[r++] = nums[i];
        }
        while (j < right) cache[r++] = nums[j++];

        System.arraycopy(cache, 0, nums, left, cache.length);
        return res;
    }

    public static void main(String[] args) {
        ReversePairs my = new ReversePairs();
        int[] nums = {1,3,2,3,1};
        int result = my.reversePairs_B(nums);
        System.out.println(result);

    }
}
