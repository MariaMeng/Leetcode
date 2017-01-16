/**
 * Created by apple on 17/1/16.
 */
public class RemoveDuplicatesFrSortedII {
    /*
        方法一： my own solution
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int j = 0; //current index
        int i = 1; // iterator through index
        for (; i < nums.length ; i++) {
            if (i == nums.length - 1 && nums[i] == nums[i -1]){ //if the end element equals the former
                j++;
                nums[j] = nums[i];
            }
            else if(nums[i] != nums[i - 1] || nums[i] != nums[i + 1]) { //if the current differs from left or right
                j++;
                nums[j] = nums[i];
            }
        }
        return ++j;
    }
    /*
        方法二：3-6 easy lines from Top Solution
        Just go through the numbers and include those in the result that haven't been included twice already.
     */
    public int removeDuplicates_B(int[] nums) {
        int i = 0; //current index
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) { //如果为前两个元素 OR 当前元素比 nums[i-2]大时，则更新nums[i]和
                nums[i++] = n;
            }
        }
        return i;
    }

    /*
        方法三：when duplicates are allowed at most K times
        We need a count variable to keep how many times the duplicated element appears,
        if we encounter a different element, just set counter to 1,
        if we encounter a duplicated one, we need to check this count,
        if it is already k, then we need to skip it, otherwise, we can keep this element.

        A[]: The input array
        n: length of Array
        k: the number of the duplicated times
     */
    int removeDuplicates_C(int A[], int k) {
        int n = A.length;
        if (n <= k) return n;
        int i = 1, j = 1; // two pointers
        int cnt = 1; // counter which keeps how many times the duplicated element appears
        while (j < n) {
            if (A[j] != A[j-1]) { //if we encounter a different element, just set counter to 1,
                cnt = 1;
                A[i++] = A[j];
            }
            else if (cnt < k) { //if we encounter a duplicated one, we need to check this count,
                A[i++] = A[j];
                cnt++;
            }
            ++j;
        }
        return i;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFrSortedII mySolution = new RemoveDuplicatesFrSortedII();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums_another = {1, 1, 1, 1, 2, 2, 2, 2};
        int[] other ={1, 1, 1, 1, 1, 1};
        int result = mySolution.removeDuplicates(nums_another);
        System.out.println(result);
    }


}
