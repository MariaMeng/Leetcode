import java.util.Scanner;

/**
 * Created by apple on 17/4/25.
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Hint:
 Could you do it in-place with O(1) extra space?
 Related problem: Reverse Words in a String II
 解题思路：
 至少有三种解法：

 */
public class RotateArray {
    /**
     * 方法一：笨办法，TLE超时了
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1 || nums == null) return ;
        if (k % nums.length == 0) return ;
        k = k % nums.length;
        int n = nums.length;
        for (int i = 1; i <= k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    /**
     * 方法二： 采用对称交换的方法，速度快
     * @param nums
     * @param k
     */
    public static void rotate_B(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        int k = in.nextInt();
        rotate(data, k);
        for (int item : data) {
            System.out.print(item + "\t");
        }
    }

}
