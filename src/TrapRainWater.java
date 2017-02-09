/**
 * Created by apple on 17/1/30.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrapRainWater {
    public int trap(int[] A){
        int a = 0, b = A.length - 1; //two pointers
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(a <= b){
            leftmax = Math.max(leftmax, A[a]);
            rightmax = Math.max(rightmax, A[b]);
            if(leftmax <= rightmax){
                max += leftmax - A[a];       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            } else{
                max += rightmax - A[b];
                b--;
            }
        }
        return max;
    }
    public int trap_another(int[] height) {
        int left = 0, right = height.length - 1;
        int leftmax = 0, rightmax = 0;
        int max = 0;
        while(left <= right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if(leftmax < rightmax){
                max += leftmax - height[left];
                left++;
            }else {
                max += rightmax - height[right];
                right--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        TrapRainWater mySolution = new TrapRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 1, 0, 1, 1};
        int result = mySolution.trap(height);
        System.out.println(result);
    }

}
