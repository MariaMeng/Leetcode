/**
 * Created by apple on 17/1/17.
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicateNumber {

    /*
        方法一： My Own Solutions
                Using O(n2) runtime complexity
     */
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        int l = nums.length; // return the length of array
        int elem = 0;
        int i = 0;
        for (; i < l; i++) {
            elem = nums[i];
            do{
                nums[i] = nums[--l];
            }while(nums[i] != elem && i < l);
            if(nums[i] == elem) break;
            l = nums.length;
        }
        return nums[i];
    }

    /*
        方法二：Java O(n) time and O(1) space solution.
                Similar to find loop in linkedlist.
     */
    public int findDuplicate_B(int[] nums) {
        int n = nums.length;
        int slow = n; //two pointer, slow index
        int fast = n; //two pointer, fast index
        do{
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindDuplicateNumber mySolution = new FindDuplicateNumber();
        int[] nums ={1, 1, 1, 1, 1};
        int result = mySolution.findDuplicate(nums);
        System.out.println(result);
    }

}
