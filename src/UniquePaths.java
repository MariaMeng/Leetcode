/**
 * Created by apple on 17/2/15.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 解题思路：
 DP方法，只能向右向下走，因此第一列第一行都为1； 其余位置为它的上和左位置求和得到。
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++)
            map[i][0] = 1;
        for (int j = 0; j < n; j++)
            map[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }
        return map[m - 1][n - 1];
    }
}
