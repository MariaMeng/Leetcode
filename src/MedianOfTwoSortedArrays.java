/**
 * Created by apple on 17/3/15.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 注意事项：
 1. 这道题是求两个排好序的数组，组成的新数组，求它的中间数，而不是求两个数组中间数的平均数
 2. 转换成求 m + n 数组中的第 k 个数的值的问题
 */
public class MedianOfTwoSortedArrays {
    /*
        方法一： 采用Binary Search
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //如果两个值 m + n之和为奇数， 则 l == r， 如果两个值 m + n 之和为偶数, 则求平均
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;

        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    private double getKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid) // 如果比aMid < bMid
            return getKth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getKth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }


    /*
        方法二： 好理解一点
        Time Complexity: O(logn)
     */
    public double findMedianSortedArrays_B(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        return (getKth((total + 1) / 2, nums1, nums2, 0, 0) + getKth((total + 2) / 2, nums1, nums2, 0, 0)) / 2.0;
    }
    private double getKth(int k, int[] A, int[] B, int aStart, int bStart) {
        if (aStart > A.length) return B[bStart + k - 1];
        if (bStart > B.length) return A[aStart + k - 1];

        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int m1 = aStart + k / 2 - 1;
        int m2 = bStart + k / 2 - 1;

        int aMid = m1 < A.length ? A[m1] : Integer.MAX_VALUE;
        int bMid = m2 < B.length ? B[m2] : Integer.MAX_VALUE;

        if (aMid < bMid)
            return getKth(k - k / 2, A, B, aStart + k / 2, bStart);
        else
            return getKth(k - k / 2, A, B, aStart, bStart + k / 2);
    }

}
