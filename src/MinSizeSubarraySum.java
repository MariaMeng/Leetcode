

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by apple on 17/1/25.
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinSizeSubarraySum {
    /*
        Wrong Solution!!
        错误原因：该题目没有排序，并且原有乱序的数列不能排序。
        因此，该方法是错误的！不能排序之后再找子数组。
     */
    public int minSubArray_Wrong(int s, int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        boolean flag = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            arrayList.add(nums[i]);
            sum += nums[i];
            if(sum >= s) {
                flag = true;
                break;
            }
        }
        if(flag == false)
            return 0;
        return arrayList.size();
    }
    /*
        方法一： Time complexity :O(n)
                Use two pointers that both start from the zero

     */
    public int minSubArray(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 0; // two pointers
        int length = Integer.MAX_VALUE; // initial length
        int sum = 0; // Check whether the substring is valid or not
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                /*
                int temp = right - left + 1;
                if (temp < length)
                    length = temp;
                */
                length = Math.min(length, right - left + 1);
                sum -= nums[left++]; // subtract the nums[left]
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length ;
    }
    /*
        该方法将for循环改为while循环，仿照10-line-template substring problem模板
     */
    public int minSubArray_another(int s, int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int left = 0, right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while(sum >= s) {
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }


    /*
        方法二： Time Complexity O(n)
                Another Two pointer algorithm that both start from zero
                Use Two while loop
     */
    public int minSubArray_B(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = 0; // two pointers
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while(right < nums.length) {
            while(right < nums.length && sum < s) sum += nums[right++];
            if(sum < s) break;
            while(left < right && sum >= s) sum -= nums[left++];
            length = Math.min(length, right - left + 1);
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    /*
        方法三： Time Complexity O(nlogn)
                Space Complexity O(n)
                Use Two pointers that start from left and right
                Space Complexity O(n) : Store the sum in the array
     */
    public int minSubArray_C(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        // calculate the accumulative sum array
        for (int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + nums[i - 1];

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /*
        方法四： Time Complexity: O(nlogn)
                Space Complexity: O(1)
                Use Two pointers that start from left and right
     */
    public int minSubArray_D(int s, int[] nums) {
        int i = 1, j = nums.length, min = 0;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (windowExist(mid, nums, s)) {
                j = mid - 1;
                min = mid;
            } else
                i = mid + 1;
        }
        return min;
    }
    /*
        Given the window size, this method checks whether there exists a window specifying the requirements
     */
    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size)
                sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MinSizeSubarraySum mySolution = new MinSizeSubarraySum();
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int s = 213;
        int[] another = {2, 3, 1, 2, 4, 3};
        int another_s = 7;
        int result = mySolution.minSubArray_B(s, nums);
        //int result = mySolution.minSubArray_B(another_s, another);
        System.out.println(result);
        int[] answer = new int[32]; // initially all elements are zeros

    }
}
