/**
 * Created by apple on 17/1/12.
 *   Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     Please note that your returned answers (both index1 and index2) are not zero-based.

     You may assume that each input would have exactly one solution.
     ========================================
     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2
     ========================================
 */
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length -1; //two pointers
        int sum = 0;
        if (numbers == null | numbers.length == 0) {
            return null;
        }
        while(left < right) {
            sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            }else if (sum > target) {
                right--;
            }else
                left++;
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        TwoSumSorted mySolution = new TwoSumSorted();
        int[] myNum = {2, 7, 11, 15};
        int myTarget = 9;
        int[] result = mySolution.twoSum(myNum, myTarget);
        /*
            For testing
         */
        System.out.println("The input array:");
        for (int j : myNum) {
            System.out.print(j + "\t");
        }
        System.out.println("\nTarget: "+ myTarget);
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }
}
