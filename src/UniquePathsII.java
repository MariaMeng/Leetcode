/**
 * Created by apple on 17/2/15.
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 解题思路：
 1. 如果当前为1，则置为0.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;
        for (int i = 1; i < m; i++)
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
        for (int j = 1; j < n; j++)
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 1) ? 0 : obstacleGrid[0][j - 1];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        return obstacleGrid[m - 1][n - 1];
    }
}
