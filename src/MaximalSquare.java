import java.util.Scanner;
import java.util.Stack;

/**
 * Created by apple on 17/4/10.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 题意：返回最大的正方形面积
 正方形是由1组成的
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int maxWidth = 0;
        // dp[i][j] represents the length of the square
        // whose right-down corner is located at (i, j)
        // dp[i][j] 表示右下角为（i, j）组成的1的正方形的边长
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    maxWidth = Math.max(maxWidth, dp[i][j]);
                }
            }
        }
        return maxWidth * maxWidth;
    }

    /*
        方法二： 自己的笨方法，由 Maximal Square 改编而来的
     */
    public static int maximalSquare_B(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= col; j++) {
                int h = 0;
                if (j < col) {
                    if (matrix[i][j] == '1')
                        h = (height[j]++);
                    else h = (height[j] = 0);
                }
                // 求面积
                if (stack.isEmpty() || h >= height[stack.peek()]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && h < height[stack.peek()]) {
                        int top = stack.pop();

                        int width = 0;
                        if (stack.isEmpty()) {
                            width = j;
                        } else width = j - stack.peek() - 1;
                        if (width <= height[top]) {
                            int area = width * width;
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                    stack.push(j);
                }
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = in.next().toCharArray();
        }
        System.out.println(maximalSquare(matrix));
    }

}
