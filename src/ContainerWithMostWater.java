/**
 * Created by apple on 17/1/17.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    /*
        错误答案！！
        Wrong Solutions: Time Exceeded!!
     */
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = java.lang.Math.min(height[j], height[i]) * java.lang.Math.abs(j - i);
                if (temp > area) area = temp;
            }
        }
        return area;
    }

    /*
        方法一： Time Complexity with O(n)
        The idea is :
        to compute area, we need to take min(height[i],height[j]) as our height. Thus if height[i]<height[j],
        then the expression min(height[i],height[j]) will always lead to at maximum height[i] for all other j(i being fixed),
        hence no point checking them.
        Similarly when height[i]>height[j] then all the other i's can be ignored for that particular j.
     */
    public int maxArea_A(int[] height) {
        int left = 0, right = height.length - 1; // two pointers
        int area = 0; // Initialize the area
        while(left < right) {
            area = java.lang.Math.max(area, java.lang.Math.min(height[left], height[right]) * (right - left));
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater mySolution = new ContainerWithMostWater();
        int[] height = {1, 2, 3 ,1, 2, 4};
        int result = mySolution.maxArea_A(height);
        System.out.println("result = " + result);
    }


}
