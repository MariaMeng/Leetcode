import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 17/1/4.
 */
public class FourSum {
    /*
        Method 1: My solution
     */
    public List<List<Integer>> fourSum_MyAnswer(int[] nums, int target) {
        List<List<Integer>> myList = new ArrayList<>();
        if(nums == null || nums.length < 4) return myList;//如果为空数组
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++ ) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++ ) {
                if(j>i+1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right ) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        System.out.println(nums[i] + "\t" + nums[j]+ "\t" + nums[left] + "\t" + nums[right]);

                        myList.add(temp);

                        //方法一：
                        while(left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }else if(sum > target) {
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return myList;
    }
    /*
        Method 2: Standard Solution
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //System.out.println("Is empty:"+res.isEmpty());

        int len = nums.length;
        //如果数组为空或数组长度<4,则直接返回
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);


        int max = nums[len - 1];//选出最大值
        if (4 * nums[0] > target || 4 * max < target)//如果数组中最大值*4<target||数组中最小值*4>target，则无法满足需求，直接返回
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z) //如果距离末尾还有至少4个数 并且 4 个数相等
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }
        return res;
    }

    /*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high) //如果左右指针重合 或者 左右指针相邻，则无法找到到三个数，则直接返回
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target) //最小的*3比target还大，或者， 最大的*3比target还小，无法找到合适的三个数，直接返回
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z) //如果距离末尾至少还有三个数，并且，三个数相等
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }



    public static void main(String[] args) {
        FourSum mySolution = new FourSum();
        //int[] nums={-1,0,1,2,-1,-4};
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        //int[] nums={0,0,0,0};
        int target=0;
        mySolution.fourSum_MyAnswer(nums,target);
        //mySolution.fourSum(nums,target);
    }

}
