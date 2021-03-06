
import java.util.*;
import java.util.Map;
/**
 * Created by apple on 17/3/17.
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 解题思路：
 查看
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                int tempH = height[tp];
                int tempWidth = s.isEmpty() ? i : i - 1 - s.peek();
                maxArea = Math.max(maxArea, tempH * tempWidth);
                i--;
            }
        }
        return maxArea;
    }

    public int largestRectangleArea_B(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        // 栈中保存的是地址。
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            // 如果当前的位置小于n， 则赋值height[i]给h，否则，置为零。
            int h =  (i == n? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            }
            else {
                // 如果当前stack中非空并且当前的高度小于栈中的高度
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int top = stack.pop();
                    // 注意这里有可能在弹栈之后，栈为空。
                    int area = heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                    maxArea = Math.max(area, maxArea);
                }
                // 当不满足while中的条件时，跳出while， 并将i压栈。
                stack.push(i);
            }
        }
        return maxArea;
    }

    public static String findChar(String s) {
        String ans = null;
        Map<Character, Integer> sMap = new LinkedHashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(!sMap.containsKey(c)){
                sMap.put(c, 1);
            }else{
                sMap.put(c, sMap.get(c)+1);
            }
        }

        for (Map.Entry<Character, Integer> en : sMap.entrySet()) {
            System.out.println(en.getKey() + "," + en.getValue());
        }

        for(Map.Entry<Character, Integer> en: sMap.entrySet()){
            if(en.getValue()==1) return en.getKey().toString();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height = {2, 3, 1};
        LargestRectangleInHistogram my = new LargestRectangleInHistogram();
        int result = my.largestRectangleArea(height);
        System.out.println(result);
        String str = "abcefabcd";
        findChar(str);
        HashMap<Character, Integer> map = new HashMap<>();
        LinkedHashMap<Character,Integer> link = new LinkedHashMap<>();

    }



}
