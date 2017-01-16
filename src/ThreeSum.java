import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 16/12/29.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * ========================================================================================
 *   For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
 * ========================================================================================
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mylist = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length - 2 ; i++ ) {
            if( i > 0 && nums[i] == nums[i - 1] ) continue;
            int left = i + 1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if ( sum == 0 ) {
                    ArrayList<Integer> temp = new ArrayList<>();

                    //方法二：
                    //Arrays.asList( nums[i], nums[left], nums[right] );

                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    mylist.add(temp);

                    System.out.println(nums[i]+"\t"+nums[left]+"\t"+nums[right]);

                    while ( left < right && nums[left] == nums[left + 1]   ) {
                        left++;
                    }
                    while ( left < right && nums[right] == nums[right - 1]  ) {
                        right--;
                    }

                    left++;
                    right--;
                }else if( sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }//End while
        }//End for loop
        return mylist;
    }
    public static void main(String[] args) {
        ThreeSum myAnswer = new ThreeSum();
        int[] A= {-4, -4, 0, 0, 0, 1, 2, 3, 4, 4, 8, 8};
        myAnswer.threeSum(A) ;

    }
}
