/**
 * Created by apple on 17/1/16.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeros {
    /*
        方法一：
        寻找所有不为0的，只要不为零，就与前面交换
        如果前面为零则左指针不动，如果非零，则左右指针同时向右滑动1单元
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {

                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                /*
                自己与自己交换时，不能采用XOR方法
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[j] ^ nums[i];
                nums[i] = nums[i] ^ nums[j];
                */
                j++;
            }
        }
    }
    /*
        方法二： my own solution
     */
    public void moveZeros_another(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if(nums[i] == 0) {
                for (int j = i + 1; j < l; j++)
                    nums[j - 1] = nums[j];
                nums[l-- - 1] = 0;
                i--;

            }
        }
    }
    public static void main(String[] args) {
        MoveZeros mySolution = new MoveZeros();
        int[] nums = {0, 0, 1, 0, 0, 3, 1, 2};
        int[] another = {0, 1, 0, 3, 12};
        int[] other = {1};
        mySolution.moveZeroes(other);
    }
}
