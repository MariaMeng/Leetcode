import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 16/12/28.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * =============================================================================================
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * =============================================================================================
 */
public class TwoSum {
    /*
        Method 1: use hashMap to store the element w.r.t their location in key-value pair
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        /* for testing */
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    /*
        Method 2: If change the question to answer whether there exist two numbers s.t. add up equals target.
                   use the sort method.
     */
    public boolean twoSumAnother(int[] nums,int target){
        Arrays.sort(nums);//我们假设采用的是最好的排序情况为O(nlogn)，不考虑具体采用哪种排序方法
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        TwoSum mytwo=new TwoSum();
        int[] num = {2, 7, 23, 32};
        int target = 56;
        int[] A=mytwo.twoSum(num, target);

        for(int i=0;i<A.length;i++){
            System.out.println(A[i]);
        }
    }

}
