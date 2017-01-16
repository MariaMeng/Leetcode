import java.util.Arrays;

/**
 * Created by apple on 17/1/4.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];
        for (int i = 0; i < nums.length - 2; i++ ) {
            int left = i + 1 ;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum - target == 0 ) {
                    return sum;
                } else if ( sum > target ) {
                    right--;
                } else {
                    left++;
                }
                if( Math.abs( sum - target) < Math.abs( result - target ) ) {
                    result = sum;
                }
            }
        }
        return result;

    }
    public static void main(String[] args) {
        ThreeSumClosest mySolution = new ThreeSumClosest();
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println( nums );
        System.out.println( mySolution.threeSumClosest( nums, target ) );
    }
}
